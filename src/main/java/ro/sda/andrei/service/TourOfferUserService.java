package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.andrei.dto.TourOfferAdminDto;
import ro.sda.andrei.dto.TourOfferUserDto;
import ro.sda.andrei.entities.TourOfferAdmin;
import ro.sda.andrei.entities.TourOfferUser;
import ro.sda.andrei.repository.TourOfferUserRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TourOfferUserService {

    private TourOfferUserRepository tourOfferUserRepository;
    @Autowired
    private PriceCalculator priceCalculator;

    @Autowired
    private TourOfferAdminService tourOfferAdminService;

    @Autowired
    private HotelService hotelService;


    @Autowired
    public TourOfferUserService(TourOfferUserRepository tourOfferUserRepository) {
        this.tourOfferUserRepository = tourOfferUserRepository;

    }


    public List<TourOfferUser> findAll() {
        return tourOfferUserRepository.findAll();
    }


    public TourOfferUser findById(Long id) {
        return tourOfferUserRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Offer not found!"));
    }

    public void update(Long id, TourOfferUser tourOfferUser) {
        tourOfferUserRepository.findById(id)
                .map(existingTourOffer -> updateEntity(tourOfferUser, existingTourOffer))
                .map(updatedTourOffer -> tourOfferUserRepository.save(updatedTourOffer))
                .orElseThrow(() -> new RuntimeException("Offer not found!"));
    }

    private TourOfferUser updateEntity(TourOfferUser tourOfferUser, TourOfferUser existingTourOfferUser) {
        existingTourOfferUser.setTravelOption(tourOfferUser.getTravelOption());
        existingTourOfferUser.setCountry(tourOfferUser.getCountry());
        existingTourOfferUser.setCity(tourOfferUser.getCity());
        existingTourOfferUser.setAirport(tourOfferUser.getAirport());
        existingTourOfferUser.setDepartureDate(tourOfferUser.getDepartureDate());
        existingTourOfferUser.setNumberOfDays(tourOfferUser.getNumberOfDays());
        existingTourOfferUser.setNumberOfRooms(tourOfferUser.getNumberOfRooms());
        existingTourOfferUser.setTypeOfService(tourOfferUser.getTypeOfService());
        existingTourOfferUser.setNumberOfAdult(tourOfferUser.getNumberOfAdult());
        existingTourOfferUser.setNumberOfChildren(tourOfferUser.getNumberOfChildren());
        existingTourOfferUser.setTypeOfRooms(tourOfferUser.getTypeOfRooms());

        return existingTourOfferUser;
    }

    public void save(TourOfferUser tourOfferUser) {
        tourOfferUserRepository.save(tourOfferUser);
    }


    /**
     * Retrieves offers based on search criteria
     *
     * @param searchCriteria
     * @return
     */
    public List<TourOfferAdminDto> searchAvailableOffers(TourOfferUserDto searchCriteria) {
        //Retrive all data
        List<TourOfferAdmin> allOffers = tourOfferAdminService.findAll();

        //Filter by search criteria
        if (searchCriteria.getCountry() != null) {
            allOffers = allOffers.stream().filter(ofer -> ofer.getCity().getCountry().equals(searchCriteria.getCountry()))
                    .collect(Collectors.toList());
        }
        if (searchCriteria.getCity() != null) {
            allOffers = allOffers.stream().filter(ofer -> ofer.getCity().equals(searchCriteria.getCity()))
                    .collect(Collectors.toList());
        }


        //Collect and calculate price after search
        List<TourOfferAdminDto> result = allOffers.stream()
                .map(TourOfferAdmin::convertToDto)
                .collect(Collectors.toList());

        result.parallelStream().forEach(t -> calculateOfferPrice(searchCriteria, t));


        return result;
    }


    /**
     * Calculates price for an offer based on searched criteria
     *
     * @param tourOfferUserDto - searched criteria
     * @param tourOfferAdmin   - hotelOffer
     */
    private void calculateOfferPrice(TourOfferUserDto tourOfferUserDto, TourOfferAdminDto tourOfferAdmin) {
        CalculationParameters calculationParameters = CalculationParameters.builder()
                .numberOfDays(tourOfferUserDto.getNumberOfDays())
                .numberOfKids(tourOfferUserDto.getNumberOfChildren())
                .numberOfAdults(tourOfferUserDto.getNumberOfAdult())
                .price4Adult(tourOfferAdmin.getPriceForAnAdult())
                .price4Kid(tourOfferAdmin.getPriceForAChild())
                .build();
        tourOfferAdmin.setCalculatedPrice(priceCalculator.calculatePrice(calculationParameters));
    }



}





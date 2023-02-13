package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.andrei.dto.HotelDto;
import ro.sda.andrei.entities.Hotel;
import ro.sda.andrei.repository.HotelRepository;

import java.util.List;

@Service
public class HotelService {


    private HotelRepository hotelRepository;

    @Autowired
    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public Hotel addNewHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    public Hotel findById(Long id) {
        return hotelRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("hotel not found!"));
    }

    public void update(Long id, HotelDto hotelDto) {
        hotelRepository.findById(id)
                .map(existingHotel -> updateEntity(hotelDto, existingHotel))
                .map(updatedHotel -> hotelRepository.save(updatedHotel))
                .orElseThrow(() -> new RuntimeException("hotel not found"));
    }

    private Hotel updateEntity(HotelDto hotelDto, Hotel existingHotel) {
        existingHotel.setName(hotelDto.getName());
        existingHotel.setStarRating(hotelDto.getStarRating());
        existingHotel.setDescription(hotelDto.getDescription());
        existingHotel.setCity(hotelDto.getCity());

        return existingHotel;
    }

    public void updateNew(Hotel hotel) {

        String name = hotel.getName();
        hotelRepository.findByNameIgnoreCase(name)
                .filter(existingHotel -> existingHotel.getId().equals(hotel.getId()))
                .map(existingHotel -> hotelRepository.save(hotel))
                .orElseThrow(() -> {

                    throw new RuntimeException("hotel already exist");
                });
    }

    @Transactional
    public void delete(Long id) {
        hotelRepository.deleteById(id);
    }

    public void save(Hotel hotel) {
        hotelRepository.save(hotel);
    }


}
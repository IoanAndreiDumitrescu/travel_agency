package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sda.andrei.OutOfOffersException;
import ro.sda.andrei.entities.TourOfferAdmin;
import ro.sda.andrei.repository.TourOfferAdminRepository;
import ro.sda.andrei.repository.TourOfferCartRepository;

import java.math.BigDecimal;
import java.util.*;

@Service
public class TourOfferCartService {

    private TourOfferAdminRepository tourOfferAdminRepository;

    private TourOfferCartRepository tourOfferCartRepository;

    private Map<TourOfferAdmin, Double> offers = new HashMap<>();

    @Autowired
    public TourOfferCartService(TourOfferAdminRepository tourOfferAdminRepository, TourOfferCartRepository tourOfferCartRepository) {
        this.tourOfferAdminRepository = tourOfferAdminRepository;
        this.tourOfferCartRepository = tourOfferCartRepository;
    }

    //    If tourOfferUser is in the map just increment quantity by 1.
//    If tourOfferUser is not in the map with, add it with quantity 1

    public void addOffer(TourOfferAdmin tourOfferAdmin, double price) {
        if (offers.containsKey(tourOfferAdmin)) {
            offers.replace(tourOfferAdmin, offers.get(tourOfferAdmin) + price);
        } else {
            offers.put(tourOfferAdmin, price);
        }
    }

//    public void addOfferPeriod(TourOfferAdmin tourOfferAdmin, double price) {
//        if (offers.containsKey(tourOfferAdmin)) {
//            offers.replace(tourOfferAdmin, offers.get(tourOfferAdmin) + price);
//        } else {
//            offers.put(tourOfferAdmin, price);
//        }
//    }

    //    If tourOfferUser is in the map with quantity > 1, just decrement quantity by 1.
//    If tourOfferUser is in the map with quantity 1, remove it from map

    public void removeOffer(TourOfferAdmin tourOfferUser, double price) {
        if (offers.containsKey(tourOfferUser)) {
            if (offers.get(tourOfferUser) > price)
                offers.replace(tourOfferUser, offers.get(tourOfferUser) - price);
            else if (offers.get(tourOfferUser) == price) {
                offers.remove(tourOfferUser);
            }
        }
    }

    //  @return unmodifiable copy of the map

    public Map<TourOfferAdmin, Double> getOffersInCart() {
        return Collections.unmodifiableMap(offers);
    }

//    Checkout will rollback if there is not enough of some offers in stock
//    @throws OutOfOffersException

    public void checkout() throws OutOfOffersException {
        TourOfferAdmin tourOfferAdmin;
        for (Map.Entry<TourOfferAdmin, Double> entry : offers.entrySet()) {
//            Long tourOfferUserKey = entry.getKey().getId();
//            // Refresh quantity for every product before checking
//            tourOfferAdmin = tourOfferAdminRepository.findById(tourOfferUserKey).orElseThrow();
//            if (tourOfferAdmin.getStock() < entry.getValue())
//                throw new OutOfOffersException();
//            entry.getKey().setStock(tourOfferAdmin.getStock() - entry.getValue());
//            tourOfferAdminRepository.save(entry.getKey());
        }
        tourOfferAdminRepository.flush();
        offers.clear();
    }

    public double getTotal() {
        return offers.entrySet().stream()
                .map(entry -> BigDecimal.valueOf(entry.getValue()))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO).doubleValue();
    }

}
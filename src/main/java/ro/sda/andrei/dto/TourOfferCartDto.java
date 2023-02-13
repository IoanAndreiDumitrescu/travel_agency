package ro.sda.andrei.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ro.sda.andrei.entities.TourOfferCart;
import ro.sda.andrei.repository.TourOfferCartRepository;

public class TourOfferCartDto {

    private static final Logger log = LoggerFactory.getLogger(TourOfferCartDto.class);

    private Long id;


    private Double totalPrice;


    private TourOfferCartRepository tourOfferCartRepository;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }



    public TourOfferCart getCurrentCart(TourOfferCart tourOfferCart) {

        return tourOfferCartRepository.findById(id).
                filter(existingTourOfferCart -> existingTourOfferCart.getId().
                        equals(tourOfferCart.getId())).
                map(existingTourOfferCart -> tourOfferCartRepository.save(tourOfferCart)).
                orElseThrow(() -> {
                    log.error("Offer already exists!");
                    throw new RuntimeException("Offer already exists!");
                });
    }
}

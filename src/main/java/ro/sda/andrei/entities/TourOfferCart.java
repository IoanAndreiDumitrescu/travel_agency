package ro.sda.andrei.entities;

import ro.sda.andrei.entities.enums.TourOfferCartStatus;

import javax.persistence.*;




@Entity
@Table(name = "tour_offer_cart")
public class TourOfferCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private Double totalPrice;

//    @OneToOne
//    private User user;

    @Enumerated(EnumType.STRING)
    private TourOfferCartStatus tourOfferCartStatus;


    public TourOfferCart() {

    }

    public TourOfferCart(Double totalPrice, TourOfferCartStatus tourOfferCartStatus) {

        this.totalPrice = totalPrice;
        this.tourOfferCartStatus = tourOfferCartStatus;
    }

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

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }

    public TourOfferCartStatus getTourOfferCartStatus() {
        return tourOfferCartStatus;
    }

    public void setTourOfferCartStatus(TourOfferCartStatus tourOfferCartStatus) {
        this.tourOfferCartStatus = tourOfferCartStatus;
    }
}

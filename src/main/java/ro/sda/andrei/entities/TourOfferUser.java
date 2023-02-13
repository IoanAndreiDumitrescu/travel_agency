package ro.sda.andrei.entities;

import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.andrei.entities.enums.StarRating;
import ro.sda.andrei.entities.enums.TypeOfRooms;
import ro.sda.andrei.entities.enums.TravelOption;
import ro.sda.andrei.entities.enums.TypeOfService;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tour_offer_user")
public class TourOfferUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TravelOption travelOption;

    @ManyToOne
    private Country country;
    @ManyToOne
    private City city;
    @ManyToOne
    private Airport airport;
    @Enumerated(EnumType.STRING)
    private StarRating starRating;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    private Integer numberOfDays;
    private Integer numberOfRooms;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private Integer numberOfAdult;
    private Integer numberOfChildren;
    private Double price;
    private int stock;
    @Enumerated(EnumType.STRING)
    private TypeOfRooms typeOfRooms;



    public TourOfferUser() {
    }

    public TourOfferUser(TravelOption travelOption, Country country, City city, Airport airport,
             Date departureDate, Integer numberOfDays, Integer numberOfRooms,
                         TypeOfService typeOfService, Integer numberOfAdult, Integer numberOfChildren, Double price, int stock, TypeOfRooms typeOfRooms, StarRating starRating) {
        this.travelOption = travelOption;
        this.country = country;
        this.city = city;
        this.airport = airport;
        this.departureDate = departureDate;
        this.numberOfDays = numberOfDays;
        this.numberOfRooms = numberOfRooms;
        this.typeOfService = typeOfService;
        this.numberOfAdult = numberOfAdult;
        this.numberOfChildren = numberOfChildren;
        this.price = price;
        this.stock = stock;
        this.typeOfRooms = typeOfRooms;

    }



    public TypeOfRooms getTypeOfRooms() {
        return typeOfRooms;
    }

    public void setTypeOfRooms(TypeOfRooms typeOfRooms) {
        this.typeOfRooms = typeOfRooms;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TravelOption getTravelOption() {
        return travelOption;
    }

    public void setTravelOption(TravelOption travelOption) {
        this.travelOption = travelOption;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Date getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public Integer getNumberOfRooms() {
        return numberOfRooms;
    }

    public void setNumberOfRooms(Integer numberOfRooms) {
        this.numberOfRooms = numberOfRooms;
    }

    public TypeOfService getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(TypeOfService typeOfService) {
        this.typeOfService = typeOfService;
    }

    public Integer getNumberOfAdult() {
        return numberOfAdult;
    }

    public void setNumberOfAdult(Integer numberOfAdult) {
        this.numberOfAdult = numberOfAdult;
    }

    public Integer getNumberOfChildren() {
        return numberOfChildren;
    }

    public void setNumberOfChildren(Integer numberOfChildren) {
        this.numberOfChildren = numberOfChildren;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public StarRating getStarRating() {
        return starRating;
    }

    public void setStarRating(StarRating starRating) {
        this.starRating = starRating;
    }
}





package ro.sda.andrei.dto;

import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.andrei.entities.Airport;
import ro.sda.andrei.entities.City;
import ro.sda.andrei.entities.Country;
import ro.sda.andrei.entities.Hotel;
import ro.sda.andrei.entities.enums.StarRating;
import ro.sda.andrei.entities.enums.TravelOption;
import ro.sda.andrei.entities.enums.TypeOfRooms;
import ro.sda.andrei.entities.enums.TypeOfService;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

public class TourOfferUserDto {


    private Long id;
    private TravelOption travelOption;
    private Country country;
    private City city;
    @Enumerated(EnumType.STRING)
    private StarRating starRating;
    private Airport airport;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    private int numberOfDays;
    private int numberOfRooms;
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private int numberOfAdult;
    private int numberOfChildren;
    private double price;
    private int stock;
    @Enumerated(EnumType.STRING)
    private TypeOfRooms typeOfRooms;

    public TourOfferUserDto() {
    }

    public TourOfferUserDto(TravelOption travelOption, Country country, City city, Airport airport,
                            Date departureDate, Integer numberOfDays, Integer numberOfRooms,
                            TypeOfService typeOfService, Integer numberOfAdult, Integer numberOfChildren, Double price, int stock, Hotel hotel, StarRating starRating,
                            TypeOfRooms typeOfRooms) {
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
        this.hotel =hotel;
        this.typeOfRooms = typeOfRooms;

    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
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

    public TypeOfRooms getTypeOfRooms() {
        return typeOfRooms;
    }

    public void setTypeOfRooms(TypeOfRooms typeOfRooms) {
        this.typeOfRooms = typeOfRooms;
    }
}





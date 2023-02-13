package ro.sda.andrei.dto;

import ro.sda.andrei.entities.Airport;
import ro.sda.andrei.entities.Country;
import ro.sda.andrei.entities.Hotel;
import java.util.ArrayList;
import java.util.List;

public class CityDto {


    private Long id;

    private String name;

    private Country country;

    private List<Hotel> hotelList = new ArrayList<>();

    private Airport airport;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public List<Hotel> getHotelList() {
        return hotelList;
    }

    public void setHotelList(List<Hotel> hotelList) {
        this.hotelList = hotelList;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }
}

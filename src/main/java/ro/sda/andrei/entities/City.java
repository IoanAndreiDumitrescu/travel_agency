package ro.sda.andrei.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "city")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=7000,message = "Please use minimum 1 character and maximum 4000 for name")
    private String name;

    @ManyToOne
    private Country country;

    @OneToMany(mappedBy = "city",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Hotel> hotelList = new ArrayList<>();

    @OneToOne(mappedBy = "city")
    private Airport airport;



    public City() {
    }

    public City(String name, Country country, List<Hotel> hotelList, Airport airport) {
        this.name = name;
        this.country = country;
        this.hotelList = hotelList;
        this.airport = airport;
    }



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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}

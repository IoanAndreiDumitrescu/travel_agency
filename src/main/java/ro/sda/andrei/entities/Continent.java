package ro.sda.andrei.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "continent")
public class Continent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=100,message = "Please use minimum 1 character and maximum 100 for name")
    private String name;

    @OneToMany(mappedBy = "continent",
            cascade = CascadeType.ALL)
    private List<Country> countryList = new ArrayList<>();

    @OneToMany(mappedBy = "continent",
            cascade = CascadeType.ALL)
    private  List<TourOfferAdmin> tourOfferAdmin = new ArrayList<>();

    public Continent() {
    }

    public Continent(String name, List<Country> countryList, List<TourOfferAdmin> tourOfferAdmin){
        this.name = name;
        this.countryList = countryList;
        this.tourOfferAdmin = tourOfferAdmin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Country> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<Country> countryList) {
        this.countryList = countryList;
    }

    public List<TourOfferAdmin> getTourOffer() {
        return tourOfferAdmin;
    }

    public void setTourOffer(List<TourOfferAdmin> tourOfferAdmin) {
        this.tourOfferAdmin = tourOfferAdmin;
    }

    public List<TourOfferAdmin> getTourOfferAdmin() {
        return tourOfferAdmin;
    }

    public void setTourOfferAdmin(List<TourOfferAdmin> tourOfferAdmin) {
        this.tourOfferAdmin = tourOfferAdmin;
    }
}



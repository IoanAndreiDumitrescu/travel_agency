package ro.sda.andrei.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=100, message = "Please use minimum 50 character and maximum 4000 for name")
    private String name;

    @ManyToOne
    private Continent continent;

    @OneToMany(mappedBy = "country",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL, orphanRemoval = true)
    private List<City> cityList = new ArrayList<>();

    @OneToMany(mappedBy = "country",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private  List<TourOfferAdmin> tourOfferAdmin = new ArrayList<>();

    public Country() {
    }

    public Country(List<TourOfferAdmin> tourOfferAdmin) {
        this.tourOfferAdmin = tourOfferAdmin;
    }

    public Country(String name, Continent continent, List<City> cityList) {
        this.name = name;
        this.continent = continent;
        this.cityList = cityList;
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

    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }

    public List<TourOfferAdmin> getTourOffer() {
        return tourOfferAdmin;
    }

    public void setTourOffer(List<TourOfferAdmin> tourOfferAdmin) {
        this.tourOfferAdmin = tourOfferAdmin;
    }
}

package ro.sda.andrei.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import ro.sda.andrei.dto.TourOfferAdminDto;
import ro.sda.andrei.entities.enums.StarRating;
import ro.sda.andrei.entities.enums.TravelOption;
import ro.sda.andrei.entities.enums.TypeOfRooms;
import ro.sda.andrei.entities.enums.TypeOfService;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "tour_offer_admin")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TourOfferAdmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Continent continent;
    @ManyToOne
    private Country country;
    @ManyToOne
    private City city;
    @Enumerated(EnumType.STRING)
    private TravelOption travelOption;
    @Enumerated(EnumType.STRING)
    private TypeOfRooms typeOfRooms;
    @ManyToOne
    private Airport airport;
    @ManyToOne
    private Hotel hotel;
    @Enumerated(EnumType.STRING)
    private StarRating starRating;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date departureDate;
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dateOfReturn;
    private Integer numberOfDays;
    @Enumerated(EnumType.STRING)
    private TypeOfService typeOfService;
    private Double priceForAnAdult;
    private Double priceForAChild;
    private int stock;
    private Double price;
    private Integer numberOfAdult;
    private Integer numberOfChildren;






    @Transient
    public TourOfferAdminDto convertToDto(){
        return TourOfferAdminDto.builder()
                .id(id)
                .name(name)
                .continent(continent)
                .country(country)
                .city(city)
                .travelOption(travelOption)
                .airport(airport)
                .hotel(hotel)
                .starRating(starRating)
                .departureDate(departureDate)
                .dateOfReturn(dateOfReturn)
                .numberOfDays(numberOfDays)
                .typeOfService(typeOfService)
                .typeOfRooms(typeOfRooms)
                .priceForAnAdult(priceForAnAdult)
                .priceForAChild(priceForAChild)
                .calculatedPrice(0.0D).build();

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TourOfferAdmin that = (TourOfferAdmin) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}



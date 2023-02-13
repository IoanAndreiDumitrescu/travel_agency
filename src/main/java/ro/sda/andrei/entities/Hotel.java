package ro.sda.andrei.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.sda.andrei.dto.HotelDto;
import ro.sda.andrei.entities.enums.StarRating;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "hotel")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=1, max=7000,message = "Please use minimum 1 character and maximum 4000 for name")
    private String name;

    @Enumerated(EnumType.STRING)
    private StarRating starRating;

    @NotNull
    @Size(min=1, max=7000,message = "Please use minimum 1 character and maximum 4000 name")
    private String description;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL)
    private List<TourOfferAdmin> tourOfferAdmin = new ArrayList<>();




    @Transient
    public HotelDto convertToDto(){
        return HotelDto.builder()
                .name(name)
                .starRating(starRating)
                .description(description)
                .city(city).build();
    }


}

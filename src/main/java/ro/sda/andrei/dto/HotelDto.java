package ro.sda.andrei.dto;

import lombok.*;
import ro.sda.andrei.entities.City;
import ro.sda.andrei.entities.Hotel;
import ro.sda.andrei.entities.enums.StarRating;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HotelDto {

    private String name;
    private String description;
    private StarRating starRating;
    private City city;
    private Hotel hotel;


}

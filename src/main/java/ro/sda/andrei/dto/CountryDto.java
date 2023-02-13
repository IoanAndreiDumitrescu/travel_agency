package ro.sda.andrei.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ro.sda.andrei.entities.City;
import ro.sda.andrei.entities.Continent;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@Setter
@ToString
public class CountryDto {

    private Long id;

    private String name;

    private Continent continent;

    private List<City> cityList = new ArrayList<>();

}

package ro.sda.andrei.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import ro.sda.andrei.dto.OptionSelectDto;
import ro.sda.andrei.entities.City;
import ro.sda.andrei.service.CityService;
import ro.sda.andrei.service.ContinentService;
import ro.sda.andrei.service.CountryService;

@RestController
@RequestMapping("/countries")
public class StatesRestController {

    @Autowired
    private CountryService countryService;
    @Autowired
    private CityService cityService;
    @Autowired
    private ContinentService continentService;
    @GetMapping
    public List<OptionSelectDto> countries(@RequestParam(value = "q", required = false) String query) {
        List<City> cities = cityService.findAll();

        if (StringUtils.isEmpty(query)) {
            return cities.stream()
                    .limit(15)
                    .map(this::mapToCountryItem).sorted()
                    .collect(Collectors.toList());
        }

        return cities.stream()
                .filter(city -> city.getCountry().getId().equals(Long.valueOf(query)))
                .limit(15)
                .map(this::mapToCountryItem).sorted()
                .collect(Collectors.toList());

//        return countries.stream()
//                .filter(state -> state.getName()
//                        .toLowerCase()
//                        .contains(query.toLowerCase()))
//                .limit(15)
//                .map(this::mapToCountryItem).sorted()
//                .collect(Collectors.toList());
    }

    private OptionSelectDto mapToCountryItem(City city){
        return OptionSelectDto.builder().id(city.getId()).text(city.getName()).build();
    }
}


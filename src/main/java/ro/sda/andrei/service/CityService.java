package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.andrei.dto.CityDto;
import ro.sda.andrei.entities.City;
import ro.sda.andrei.entities.Country;
import ro.sda.andrei.repository.CityRepository;
import ro.sda.andrei.repository.CountryRepository;

import java.util.List;

@Service
public class CityService {

    private CityRepository cityRepository;
    private CountryRepository countryRepository;

    @Autowired
    public CityService(CityRepository cityRepository, CountryRepository countryRepository) {
        this.cityRepository = cityRepository;
        this.countryRepository = countryRepository;
    }

    public City addNewCity(City city) {
        return cityRepository.save(city);
    }


    public List<City> findAll() {
        return cityRepository.findAll();
    }


    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("city not found!"));
    }

    public void update(Long id, CityDto cityDto) {
        cityRepository.findById(id)
                .map(existingCity -> updateEntity(cityDto, existingCity))
                .map(updatedCity -> cityRepository.save(updatedCity))
                .orElseThrow(() -> new RuntimeException("city not found"));
    }

    private City updateEntity(CityDto cityDto, City existingCity) {
        existingCity.setName(cityDto.getName());
        existingCity.setCountry(cityDto.getCountry());
        existingCity.setAirport(cityDto.getAirport());

        return existingCity;
    }

    public void updateNew(City city) {

        String name = city.getName();
        cityRepository.findByNameIgnoreCase(name)
                .filter(existingCity -> existingCity.getId().equals(city.getId()))
                .map(existingCity -> cityRepository.save(city))
                .orElseThrow(() -> {

                    throw new RuntimeException("city already exist");
                });
    }

    @Transactional
    public void delete(Long id) {
        City city = cityRepository.getById(id);
        Country country = countryRepository.getById(city.getCountry().getId());
        country.getCityList().remove(city);
        countryRepository.save(country);
        cityRepository.deleteById(id);
    }

    public void save(City city) {
        cityRepository.save(city);
    }
}

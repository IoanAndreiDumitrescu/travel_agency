package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.andrei.dto.CountryDto;
import ro.sda.andrei.entities.Country;
import ro.sda.andrei.repository.CountryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private CountryRepository countryRepository;

    @Autowired
    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Country addNewCountry(Country country) {
        return countryRepository.save(country);
    }

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    public Country findById(Long id) {
        Optional<Country> countryOptional = countryRepository.findById(id);
        return countryOptional.orElseThrow(() -> new RuntimeException("Country not found"));
    }

    public void update(Long id, CountryDto countryDto) {
        countryRepository.findById(id)
                .map(existingCountry -> updateEntity(countryDto, existingCountry))
                .map(updatedCountry -> countryRepository.save(updatedCountry))
                .orElseThrow(() -> new RuntimeException("country not found"));
    }

    private Country updateEntity(CountryDto countryDto, Country existingCountry) {
        existingCountry.setName(countryDto.getName());
        existingCountry.setContinent(countryDto.getContinent());

        return existingCountry;

    }
    @Transactional
    public void save(Country country) {
        countryRepository.save(country);
    }

    public void delete(Long id) {
        countryRepository.deleteById(id);
    }
}

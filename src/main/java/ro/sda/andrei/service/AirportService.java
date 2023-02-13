package ro.sda.andrei.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.andrei.dto.AirportDto;
import ro.sda.andrei.entities.Airport;
import ro.sda.andrei.repository.AirportRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AirportService {

    private AirportRepository airportRepository;

    @Autowired
    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public Airport addNewAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    public List<Airport> findAll() {
        return airportRepository.findAll();
    }

    public Airport findById(Long id) {
        Optional<Airport> airportOptional = airportRepository.findById(id);
        return airportOptional.orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    public void update(Long id, AirportDto airportDto) {
        airportRepository.findById(id)
                .map(existingAirport -> updateEntity(airportDto, existingAirport))
                .map(updatedAirport -> airportRepository.save(updatedAirport))
                .orElseThrow(() -> new RuntimeException("Airport not found"));
    }

    private Airport updateEntity(AirportDto airportDto, Airport existingAirport) {
         existingAirport.setName(airportDto.getName());
         existingAirport.setCity(airportDto.getCity());

         return existingAirport;
    }

    public void updateNew(Airport airport) {

        String name = airport.getName();
        airportRepository.findByNameIgnoreCase(name)
                .filter(existingAirport -> existingAirport.getId().equals(airport.getId()))
                .map(existingAirport -> airportRepository.save(airport))
                .orElseThrow(() -> {

                    throw new RuntimeException("Airport already exist");
                });
    }

    @Transactional
    public void delete(Long id) {
        airportRepository.deleteById(id);
    }

    public void save(Airport airport) {
        airportRepository.save(airport);
    }
}

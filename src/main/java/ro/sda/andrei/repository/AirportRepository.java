package ro.sda.andrei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.andrei.entities.Airport;

import java.util.List;
import java.util.Optional;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {

    List<Airport> findByName(String name);

    Optional<Airport> findByNameIgnoreCase(String name);

}

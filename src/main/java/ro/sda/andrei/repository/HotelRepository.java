package ro.sda.andrei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.andrei.entities.Hotel;

import java.util.List;
import java.util.Optional;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

    List<Hotel> findByName(String name);
    Optional<Hotel> findByNameIgnoreCase(String name);


}

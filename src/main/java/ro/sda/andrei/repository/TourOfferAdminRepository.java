package ro.sda.andrei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.andrei.entities.TourOfferAdmin;

import java.util.List;
import java.util.Optional;

@Repository
public interface TourOfferAdminRepository extends JpaRepository<TourOfferAdmin, Long> {

    Optional<TourOfferAdmin> findById(Long id);


    Optional<TourOfferAdmin> findByNameIgnoreCase(String name);

    List<TourOfferAdmin> findByNameStartingWith(String name);
}

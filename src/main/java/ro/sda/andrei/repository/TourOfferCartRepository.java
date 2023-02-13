package ro.sda.andrei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.andrei.entities.TourOfferCart;

import java.util.Optional;


@Repository
public interface TourOfferCartRepository extends JpaRepository<TourOfferCart, Long> {

   Optional<TourOfferCart> findById(Long id);

}

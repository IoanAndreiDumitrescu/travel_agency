package ro.sda.andrei.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.sda.andrei.entities.TourOfferUser;

import java.util.Optional;

@Repository
public interface TourOfferUserRepository extends JpaRepository<TourOfferUser, Long> {

    Optional<TourOfferUser> findById(Long id);

}

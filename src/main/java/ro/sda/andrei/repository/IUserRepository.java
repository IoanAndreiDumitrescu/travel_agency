package ro.sda.andrei.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.andrei.model.User;

public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
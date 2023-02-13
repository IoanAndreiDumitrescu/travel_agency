package ro.sda.andrei.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ro.sda.andrei.model.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
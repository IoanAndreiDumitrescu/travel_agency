package ro.sda.andrei.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ro.sda.andrei.model.User;
import ro.sda.andrei.web.dto.UserRegistrationDto;

public interface IUserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
    User findByUsername(String username);
}
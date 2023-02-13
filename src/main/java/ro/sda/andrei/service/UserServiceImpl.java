package ro.sda.andrei.service;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ro.sda.andrei.model.Role;
import ro.sda.andrei.model.User;
import ro.sda.andrei.repository.IRoleRepository;
import ro.sda.andrei.repository.IUserRepository;
import ro.sda.andrei.web.dto.UserRegistrationDto;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    private IUserRepository userRepository;
    private IRoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;


    public UserServiceImpl(IUserRepository userRepository, IRoleRepository roleRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;

    }

    @Override
    public User save(UserRegistrationDto registrationDto) {

        //Creating admin role user
        User user = new User(
                registrationDto.getFirstName()
                ,registrationDto.getLastName()
                , registrationDto.getUserName()
                ,passwordEncoder.encode(registrationDto.getPassword())
                , Arrays.asList(roleRepository.findByName("USER")));

        return userRepository.save(user);
    }



    @Override
    public User findByUsername(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }



}

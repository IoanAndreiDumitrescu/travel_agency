package ro.sda.andrei.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ro.sda.andrei.service.IUserService;


@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Autowired
    private IUserService userService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests().
                antMatchers("/"
                        , "/cazare-Romania"
                        , "/city-break"
                        , "/promotii"
                        , "/contact"
                        , "/bootstrap/**"
                        , "/extra/**"
                        , "/webjars/**"
                        , "/plugins/**"
                        , "/assets/**"
                        , "/images/**"
                        , "/favicon.ico"
                        , "/dist/**"
                        , "/cazare-Romania"
                        , "/vacante/**"
                        , "/circuite/**"
                        , "/charter-exotic/**"
                        , "/craciun-2022/**"
                        , "/city-break/**"
                        , "/estival/**"
                        , "/exotice/**"
                        , "/revelion-2022/**"
                        , "/senior-voyage/**"
                        , "/ski/**"
                        , "/despre_noi"
                        , "/termeni_si_conditii"
                        , "/searchOffer"
                        , "/vacanta-placuta").permitAll().
                antMatchers(
                        "/hotel"
                        , "/continent"
                        , "/country"
                        , "/airport"
                        , "/city"
                        , "/tourOfferAdmin")
                .hasRole("ADMIN")
                .antMatchers(
                        "/register**"
                        , "/bootstrap/**"
                        , "/extra/**"
                        , "/webjars/**"
                        , "/plugins/**"
                        , "/assets/**"
                        , "/images/**"
                        , "/css/**"
                        , "/favicon.ico"
                        , "/dist/**"
                        , "/cazare-Romania"
                        , "/despre_noi"
                        , "/termeni_si_conditii"
                        , "/shoppingCart")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/")
                .defaultSuccessUrl("/")
                .permitAll()
                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .authorizeRequests();


    }

    public void configure(WebSecurity web) throws Exception {
        // web.ignoring().antMatchers("/resources/static/**").anyRequest();
    }


}
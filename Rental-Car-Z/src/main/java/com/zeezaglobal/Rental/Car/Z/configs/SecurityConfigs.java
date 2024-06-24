package com.zeezaglobal.Rental.Car.Z.configs;

import com.zeezaglobal.Rental.Car.Z.repos.UserRepository;
import com.zeezaglobal.Rental.Car.Z.services.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfigs {



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers("/rentals/users/add").permitAll()  // Public endpoint
                        .requestMatchers("/rentals/users/all").authenticated()  // Secured endpoint
                )
                .httpBasic(Customizer.withDefaults())  // Use httpBasic with Customizer
                .csrf(csrf -> csrf.disable());  // Disable CSRF protection

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

  /*  @Bean
    public UserDetailsService userDetailsService(UserRepository userRepository) {
        return new CustomUserDetailsService(userRepository);
    }*/

    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withUsername("hardcodedUser")
                .password(passwordEncoder().encode("hardcodedPassword"))
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}

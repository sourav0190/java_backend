package com.codingshuttle.youtube.hospitalManagement.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class Webconfig {
    private final  PasswordEncoder passwordEncoder;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public/**").permitAll()
//                        .requestMatchers("/admin/**").authenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                )
                .formLogin(Customizer.withDefaults());
        return http.build();


    }
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user1 = User.builder()
                .username("sourav")
                .password(passwordEncoder.encode("pass"))
                .roles("USER")
                .build();
        UserDetails user2 = User.builder()
                .username("thakur")
                .password(passwordEncoder.encode("pass"))
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user1,user2);
    }
}

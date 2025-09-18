package ru.netology.personsapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserDetailsConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        var uds = new InMemoryUserDetailsManager();

        uds.createUser(User.withUsername("userRead")
                .password("password")
                .roles("READ")
                .build());

        uds.createUser(User.withUsername("userWrite")
                .password("password")
                .roles("WRITE")
                .build());

        uds.createUser(User.withUsername("userDelete")
                .password("password")
                .roles("DELETE")
                .build());

        uds.createUser(User.withUsername("userReadWrite")
                .password("password")
                .roles("READ", "WRITE")
                .build());

        uds.createUser(User.withUsername("admin")
                .password("password")
                .roles("READ", "WRITE", "DELETE")
                .build());

        return uds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
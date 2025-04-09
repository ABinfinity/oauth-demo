package com.example.oauthdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.net.http.HttpRequest;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // To login using credentials -->
        // Allow access to the login page without authentication
//        http
//                .authorizeHttpRequests(authz -> {
//                    try {
//                        authz
//                                .requestMatchers("/login").permitAll()  // Allow login page
//                                .requestMatchers("/admin").hasRole("ADMIN")  // Only allow admin
//                                .anyRequest().authenticated()
//                                .and()
//                                .formLogin()
//                                .loginPage("/login")
//                                .failureUrl("/login?error=true")
//                                .permitAll();
//                    } catch (Exception e) {
//                        throw new RuntimeException(e);
//                    }
//                });


        // To login using 3rd Party (Google, github etc.)

        http
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .oauth2Login(Customizer.withDefaults());
                .oauth2Login(oauth -> oauth
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/user");
                        })
                );

        return http.build();
    }

// Login with credentials
//    @Bean
//    public UserDetailsService userDetailsService() {
//        // Create a sample user (username: user, password: password)
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("adminpass")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user, admin);
//    }
}

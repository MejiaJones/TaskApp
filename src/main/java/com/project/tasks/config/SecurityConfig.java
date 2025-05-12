package com.project.tasks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(authz -> authz
                        .requestMatchers(HttpMethod.POST, "/users/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.POST, "/task-lists/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/task-lists/**/tasks/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers(HttpMethod.GET, "/task-lists/**/tasks").authenticated()
                        .anyRequest().authenticated()
                )
                .httpBasic(); // o usa JWT si prefieres
        return http.build();
    }

}

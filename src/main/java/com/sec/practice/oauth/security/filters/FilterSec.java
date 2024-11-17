package com.sec.practice.oauth.security.filters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.stereotype.Component;

@EnableWebSecurity
@Component
public class FilterSec{

   @Autowired
   private AuthenticationProvider authenticationProvider;

   @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{

        http.csrf(CsrfConfigurer::disable);
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.authenticationProvider(authenticationProvider);
        http.authorizeHttpRequests(
                authRequest ->{
                    authRequest.requestMatchers("/h2-console/**").permitAll();

                    authRequest.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
                    authRequest.requestMatchers(HttpMethod.GET, "/auth/validate").permitAll();
                    authRequest.anyRequest().authenticated();
                }
        );

        return http.build();
    }
}
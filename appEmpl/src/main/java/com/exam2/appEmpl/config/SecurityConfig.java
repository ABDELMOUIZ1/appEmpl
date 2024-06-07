package com.exam2.appEmpl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "com.exam2.appEmpl")
public class SecurityConfig {

    @Autowired
    private MyUserDetailsService userDetailsService; // Ensure that MyUserDetailsService is properly configured

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login/**").permitAll()
                        // Define secured endpoints for DEV, TEST, DEVOPS roles
                        .requestMatchers("/api/devops/**").hasAnyAuthority("DEV", "TEST", "DEVOPS")
                        .anyRequest().authenticated()
                )
                .formLogin()
                .and()
                .httpBasic()  // Optionally use basic authentication for API endpoints if suitable
                .and()
                .csrf().disable();

        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}

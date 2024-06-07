package com.exam2.appEmpl.config;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {

    // Notez que vous devez utiliser votre propre logique pour charger les détails de l'utilisateur
    // Cette implémentation est un exemple basique
    @Override
    public UserDetails loadUserByUsername(String username) {
        return User.withUsername(username)
                .password("{noop}password") // Utilisez votre propre logique pour obtenir le mot de passe
                .roles("USER")
                .build();
    }
}


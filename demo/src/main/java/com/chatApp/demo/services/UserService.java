package com.chatApp.demo.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chatApp.demo.repo.UserJpaRepo;

@Service
public class UserService  implements UserDetailsService{
    
    private final UserJpaRepo userRepo;

    public UserService(UserJpaRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepo.findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}

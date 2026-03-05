package com.chatApp.demo.services;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chatApp.demo.entity.User;
import com.chatApp.demo.pojo.RegisterDTO;
import com.chatApp.demo.repo.UserJpaRepo;

@Service
public class RegisterUserService {
    
    private UserJpaRepo userRepo;
    private PasswordEncoder encoder;

    public RegisterUserService(UserJpaRepo userRepo, PasswordEncoder encoder) {

        this.userRepo = userRepo;
        this.encoder = encoder;
    }

    public User register(RegisterDTO request) {
     
        userRepo.findByUsername(request.getUsername())
            .ifPresent(u -> {throw new IllegalArgumentException("Username Already in use");});
        
        User user = new User();
        user.setId(null);
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRoles(List.of("ROLE_USER"));
        
        return userRepo.save(user);
    }
}

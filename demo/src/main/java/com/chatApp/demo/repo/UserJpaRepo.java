package com.chatApp.demo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chatApp.demo.entity.User;

public interface UserJpaRepo extends JpaRepository<User, Integer>{
    
    Optional<User> findByUsername(String username);
    boolean existsByUsername(String username);

    

}

package com.chatApp.demo.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.chatApp.demo.entity.User;
import com.chatApp.demo.pojo.LoginRequestDTO;
import com.chatApp.demo.pojo.LoginResponse;
import com.chatApp.demo.pojo.RegisterDTO;
import com.chatApp.demo.repo.UserJpaRepo;
import com.chatApp.demo.security.JwtUtil;
import com.chatApp.demo.services.RegisterUserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// @CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/reg")
public class RegisterApi {
    
    private UserJpaRepo userRepo;
    private RegisterUserService userService;
    private JwtUtil jwtUtil;
    private AuthenticationManager authManager;

    public RegisterApi(UserJpaRepo userRepo, RegisterUserService service, JwtUtil jwtUtil, AuthenticationManager authManager) {
        this.userRepo = userRepo;
        this.userService=service;
        this.jwtUtil=jwtUtil;
        this.authManager=authManager;
    }

    @GetMapping("/get")
    public List<User> getUser() {
        return userRepo.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequestDTO dto) {

        System.out.println("LOGIN CONTROLLER HIT");


        Authentication auth = authManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                dto.getUsername(),
                dto.getPassword()
            )
        );
        // authenticate is done by UserService automatically. thats why it needs to implemetn UserDetailsService and override that method it has. 

        SecurityContextHolder.getContext().setAuthentication(auth);

        User user = (User) auth.getPrincipal();
        String token = jwtUtil.generateToken(user);

        return ResponseEntity.ok(
            new LoginResponse(token, user.getUsername(), user.getRoles())
        );
    }


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        
        userService.register(dto);
        User user = userRepo.findByUsername(dto.getUsername()).orElse(null);
        String token = jwtUtil.generateToken(user);

        return ResponseEntity.ok(new LoginResponse(token, user.getUsername(), user.getRoles()));
    }   
}

// hello
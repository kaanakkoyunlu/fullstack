package com.chatApp.demo.pojo;
import java.util.List;

public record LoginResponse(
        String accessToken,
        String username,
        List<String> roles
) {}
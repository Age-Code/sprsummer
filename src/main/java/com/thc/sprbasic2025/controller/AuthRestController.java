package com.thc.sprbasic2025.controller;

import com.thc.sprbasic2025.util.TokenFactory;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthRestController{

    final TokenFactory tokenFactory;

    private final String prefix = "Bearer ";

    @PostMapping("")
    public ResponseEntity<Void> access(HttpServletRequest request){
        String returnValue = null;
        String refreshToken = request.getHeader("RefreshToken");

        if(refreshToken.startsWith(prefix)){
            refreshToken = refreshToken.substring(prefix.length());

            String accessToken = tokenFactory.generateAccessToken(refreshToken);
            returnValue = prefix + accessToken;
        }

        System.out.println("AuthRestController Authorization: " + returnValue);

        return ResponseEntity.status(HttpStatus.OK).header("Authorization", returnValue).build();
    }
}

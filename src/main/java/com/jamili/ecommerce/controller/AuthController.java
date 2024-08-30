package com.jamili.ecommerce.controller;

import com.jamili.ecommerce.config.exceptions.UserNotFoundException;
import com.jamili.ecommerce.dto.LoginRequestDTO;
import com.jamili.ecommerce.dto.RegisterRequestDTO;
import com.jamili.ecommerce.dto.ResponseDTO;
import com.jamili.ecommerce.models.User;
import com.jamili.ecommerce.repository.UserRepository;
import com.jamili.ecommerce.security.TokenService;
import com.jamili.ecommerce.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO body){
        ResponseDTO response = userService.login(body);

        if (response == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(response);
    }


    @PostMapping("/register")
    public ResponseEntity register(@Valid @RequestBody RegisterRequestDTO body){
        ResponseDTO responseDTO = userService.register(body);

        if (responseDTO == null) {return ResponseEntity.badRequest().build();}

        return ResponseEntity.ok(responseDTO);
    }
}
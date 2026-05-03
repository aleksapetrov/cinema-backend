package dev_practice.cinema_backend.controller;


import dev_practice.cinema_backend.dto.SignInRequest;
import dev_practice.cinema_backend.dto.SignInResponse;
import dev_practice.cinema_backend.security.JwtUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    @PostMapping
    public ResponseEntity<SignInResponse> signin(@Valid @RequestBody SignInRequest signInRequest){
        Authentication authentication;
        try {
            authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getUsername(),signInRequest.getPassword()));
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }
        UserDetails user = (UserDetails) authentication.getPrincipal();
        String jwt = jwtUtils.generateToken(user);
        return ResponseEntity.ok(new SignInResponse(user.getUsername(),jwt));
    }
}

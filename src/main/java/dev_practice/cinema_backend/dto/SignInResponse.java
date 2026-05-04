package dev_practice.cinema_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SignInResponse {

    private String username;
    private String jwt;
}

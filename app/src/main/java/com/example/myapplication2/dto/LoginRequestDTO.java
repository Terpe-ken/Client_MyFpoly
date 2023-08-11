package com.example.myapplication2.dto;

public class LoginRequestDTO {
    private String username;

    public LoginRequestDTO() {
    }

    public LoginRequestDTO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

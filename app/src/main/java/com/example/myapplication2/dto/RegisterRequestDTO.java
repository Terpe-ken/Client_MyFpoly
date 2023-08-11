package com.example.myapplication2.dto;

public class RegisterRequestDTO {
    private String username;
    private String name;
    private String avata;

    public RegisterRequestDTO() {
    }

    public RegisterRequestDTO(String username, String name, String avata) {
        this.username = username;
        this.name = name;
        this.avata = avata;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }
}

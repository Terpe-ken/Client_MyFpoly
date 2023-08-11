package com.example.myapplication2.dto;

public class LoginResponeseDTO {
    private boolean status;
    private int id;
    private String username;
    private String avata;

    public LoginResponeseDTO() {
    }

    public LoginResponeseDTO(boolean status, int id, String username, String avata) {
        this.status = status;
        this.id = id;
        this.username = username;
        this.avata = avata;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvata() {
        return avata;
    }

    public void setAvata(String avata) {
        this.avata = avata;
    }
}

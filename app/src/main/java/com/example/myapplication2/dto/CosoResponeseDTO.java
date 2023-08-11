package com.example.myapplication2.dto;

public class CosoResponeseDTO {
    private boolean status;

    public CosoResponeseDTO() {
    }

    public CosoResponeseDTO(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

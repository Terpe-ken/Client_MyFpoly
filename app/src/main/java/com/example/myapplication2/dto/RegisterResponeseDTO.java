package com.example.myapplication2.dto;

public class RegisterResponeseDTO {
    private boolean status;

    public RegisterResponeseDTO() {

    }

    public RegisterResponeseDTO(boolean status) {
        this.status = status;
    }


    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}

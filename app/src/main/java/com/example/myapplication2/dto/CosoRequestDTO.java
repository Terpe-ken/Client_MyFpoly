package com.example.myapplication2.dto;

public class CosoRequestDTO {
    private int iduser;
    private int idcoso;

    public CosoRequestDTO() {
    }

    public CosoRequestDTO(int iduser, int idcoso) {
        this.iduser = iduser;
        this.idcoso = idcoso;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdcoso() {
        return idcoso;
    }

    public void setIdcoso(int idcoso) {
        this.idcoso = idcoso;
    }
}

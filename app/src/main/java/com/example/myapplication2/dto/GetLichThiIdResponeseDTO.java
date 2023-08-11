package com.example.myapplication2.dto;

public class GetLichThiIdResponeseDTO {
    private boolean status;
    private int id;
    private String idcourse;
    private int ca;
    private String address;
    private String date;

    public GetLichThiIdResponeseDTO() {
    }

    public GetLichThiIdResponeseDTO(boolean status, int id, String idcourse, int ca, String address, String date) {
        this.status = status;
        this.id = id;
        this.idcourse = idcourse;
        this.ca = ca;
        this.address = address;
        this.date = date;
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

    public String getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(String idcourse) {
        this.idcourse = idcourse;
    }

    public int getCa() {
        return ca;
    }

    public void setCa(int ca) {
        this.ca = ca;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

package com.example.myapplication2.dto;

public class GetLichHocIdResponeseDTO {
    private boolean status;
    private int id;
    private String courseid;
    private int ca;
    private String address;
    private String date;

    public GetLichHocIdResponeseDTO() {
    }

    public GetLichHocIdResponeseDTO(boolean status, int id, String courseid, int ca, String address, String date) {
        this.status = status;
        this.id = id;
        this.courseid = courseid;
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

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
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

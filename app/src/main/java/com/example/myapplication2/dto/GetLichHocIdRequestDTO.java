package com.example.myapplication2.dto;

public class GetLichHocIdRequestDTO {
    private int id;

    public GetLichHocIdRequestDTO() {
    }

    public GetLichHocIdRequestDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

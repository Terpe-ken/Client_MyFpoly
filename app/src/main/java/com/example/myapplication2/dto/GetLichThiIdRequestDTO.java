package com.example.myapplication2.dto;

public class GetLichThiIdRequestDTO {
    private int id;

    public GetLichThiIdRequestDTO() {
    }

    public GetLichThiIdRequestDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

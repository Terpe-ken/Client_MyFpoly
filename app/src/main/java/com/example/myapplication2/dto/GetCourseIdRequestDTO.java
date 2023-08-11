package com.example.myapplication2.dto;

public class GetCourseIdRequestDTO {
    private int id;

    public GetCourseIdRequestDTO() {
    }

    public GetCourseIdRequestDTO(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

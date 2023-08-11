package com.example.myapplication2.dto;

public class GetCourseIdResponeseDTO {
    private boolean status;
    private int id;
    private String name;
    private String teacher;
    private String typecourseid;

    public GetCourseIdResponeseDTO() {
    }

    public GetCourseIdResponeseDTO(boolean status, int id, String name, String teacher, String typecourseid) {
        this.status = status;
        this.id = id;
        this.name = name;
        this.teacher = teacher;
        this.typecourseid = typecourseid;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTypecourseid() {
        return typecourseid;
    }

    public void setTypecourseid(String typecourseid) {
        this.typecourseid = typecourseid;
    }
}

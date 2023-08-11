package com.example.myapplication2.dto;

import java.util.List;

public class ListGetAllCourseResponeseDTO {
    private boolean status;
    private List<GetAllCourseResponeseDTO> allcourse;
    public class GetAllCourseResponeseDTO{
        private int id;
        private String name;
        private String teacher;
        private String typecourseid;

        public GetAllCourseResponeseDTO() {
        }

        public GetAllCourseResponeseDTO(int id, String name, String teacher, String typecourseid) {
            this.id = id;
            this.name = name;
            this.teacher = teacher;
            this.typecourseid = typecourseid;
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

    public ListGetAllCourseResponeseDTO() {
    }

    public ListGetAllCourseResponeseDTO(boolean status, List<GetAllCourseResponeseDTO> allcourse) {
        this.status = status;
        this.allcourse = allcourse;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GetAllCourseResponeseDTO> getAllcourse() {
        return allcourse;
    }

    public void setAllcourse(List<GetAllCourseResponeseDTO> allcourse) {
        this.allcourse = allcourse;
    }
}

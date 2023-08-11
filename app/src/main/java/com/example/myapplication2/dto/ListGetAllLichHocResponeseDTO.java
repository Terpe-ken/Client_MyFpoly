package com.example.myapplication2.dto;

import java.util.List;

public class ListGetAllLichHocResponeseDTO {
    private boolean status;
    private List<GetAllLichHocResponeseDTO> alllichhoc;
    public class GetAllLichHocResponeseDTO{
        private int id;
        private String courseid;
        private int ca;
        private String address;
        private String date;

        private  String teacher;

        public GetAllLichHocResponeseDTO(int id, String courseid, int ca, String address, String date, String teacher) {
            this.id = id;
            this.courseid = courseid;
            this.ca = ca;
            this.address = address;
            this.date = date;
            this.teacher = teacher;
        }

        public GetAllLichHocResponeseDTO() {
        }

        public int getId() {
            return id;
        }
        public String getTeacher(){return teacher;}
        public void setTeacher(String teacher){this.teacher = teacher;}

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

    public ListGetAllLichHocResponeseDTO() {
    }

    public ListGetAllLichHocResponeseDTO(boolean status, List<GetAllLichHocResponeseDTO> alllichhoc) {
        this.status = status;
        this.alllichhoc = alllichhoc;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GetAllLichHocResponeseDTO> getAlllichhoc() {
        return alllichhoc;
    }

    public void setAlllichhoc(List<GetAllLichHocResponeseDTO> alllichhoc) {
        this.alllichhoc = alllichhoc;
    }
}

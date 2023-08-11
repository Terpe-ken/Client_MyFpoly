package com.example.myapplication2.dto;

import java.util.List;

public class ListGetAllLichThiResponeseDTO {
    private boolean status;
    private List<GetAllLichThiResponeseDTO> alllichthi;
    public class GetAllLichThiResponeseDTO{
        private int id;
        private String courseid;
        private int ca;
        private String address;
        private String date;
        private String teacher;

        public GetAllLichThiResponeseDTO() {
        }


        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public GetAllLichThiResponeseDTO(int id, String courseid, int ca, String address, String date, String teacher) {
            this.id = id;
            this.courseid = courseid;
            this.ca = ca;
            this.address = address;
            this.date = date;
            this.teacher = teacher;
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

    public ListGetAllLichThiResponeseDTO() {
    }

    public ListGetAllLichThiResponeseDTO(boolean status, List<GetAllLichThiResponeseDTO> alllichthi) {
        this.status = status;
        this.alllichthi = alllichthi;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GetAllLichThiResponeseDTO> getAlllichthi() {
        return alllichthi;
    }

    public void setAlllichthi(List<GetAllLichThiResponeseDTO> alllichthi) {
        this.alllichthi = alllichthi;
    }
}

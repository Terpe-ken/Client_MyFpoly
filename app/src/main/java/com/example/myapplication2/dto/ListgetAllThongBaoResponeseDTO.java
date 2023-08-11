package com.example.myapplication2.dto;

import java.util.List;

public class ListgetAllThongBaoResponeseDTO {
    private boolean status;
    private List<getAllThongBaoResponeseDTO>allthongbao;
    public class getAllThongBaoResponeseDTO{
        private int id;
        private String title;
        private String content;
        private String date;
        private int iduser;

        public getAllThongBaoResponeseDTO() {
        }

        public getAllThongBaoResponeseDTO(int id, String title, String content, String date, int iduser) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.date = date;
            this.iduser = iduser;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public int getIduser() {
            return iduser;
        }

        public void setIduser(int iduser) {
            this.iduser = iduser;
        }
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<getAllThongBaoResponeseDTO> getAllthongbao() {
        return allthongbao;
    }

    public void setAllthongbao(List<getAllThongBaoResponeseDTO> allthongbao) {
        this.allthongbao = allthongbao;
    }
}

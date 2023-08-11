package com.example.myapplication2.dto;

import java.util.List;

public class GetNewsKeywordResponeseDTO {
    private boolean status;
    private List<GetAllNewsResponeseDTO> allthongbao;
    public class GetAllNewsResponeseDTO{
        private int id;
        private String title;
        private String content;
        private String date;
        private String resource;

        public GetAllNewsResponeseDTO() {
        }

        public GetAllNewsResponeseDTO(int id, String title, String content, String date, String resource) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.date = date;
            this.resource = resource;
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

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }
    }

    public GetNewsKeywordResponeseDTO() {
    }

    public GetNewsKeywordResponeseDTO(boolean status, List<GetAllNewsResponeseDTO> allthongbao) {
        this.status = status;
        this.allthongbao = allthongbao;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GetAllNewsResponeseDTO> allthongbao() {
        return allthongbao;
    }

    public void setAllnews(List<GetAllNewsResponeseDTO> allthongbao) {
        this.allthongbao = allthongbao;
    }
}

package com.example.myapplication2.dto;

import java.util.List;

public class ListGetAllNewsResponeseDTO {
    private boolean status;
    private List<GetAllNewsResponeseDTO> allnews;
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

    public ListGetAllNewsResponeseDTO() {
    }

    public ListGetAllNewsResponeseDTO(boolean status, List<GetAllNewsResponeseDTO> allnews) {
        this.status = status;
        this.allnews = allnews;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<GetAllNewsResponeseDTO> getAllnews() {
        return allnews;
    }

    public void setAllnews(List<GetAllNewsResponeseDTO> allnews) {
        this.allnews = allnews;
    }
}

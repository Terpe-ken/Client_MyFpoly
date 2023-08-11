package com.example.myapplication2.dto;

import java.util.List;

public class ListgetAllCosoResponeseDTO {
    private boolean status;
    List<getAllCosoResponeseDTO> allcoso;
    public class getAllCosoResponeseDTO{
        private int id;
        private String name;

        public getAllCosoResponeseDTO() {
        }

        public getAllCosoResponeseDTO(int id, String name) {
            this.id = id;
            this.name = name;
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
    }

    public ListgetAllCosoResponeseDTO() {
    }

    public ListgetAllCosoResponeseDTO(boolean status, List<getAllCosoResponeseDTO> allcoso) {
        this.status = status;
        this.allcoso = allcoso;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<getAllCosoResponeseDTO> getAllcoso() {
        return allcoso;
    }

    public void setAllcoso(List<getAllCosoResponeseDTO> allcoso) {
        this.allcoso = allcoso;
    }
}

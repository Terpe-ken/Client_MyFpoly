package com.example.myapplication2.dto;

public class GetNewsKeywordRequestDTO {
    private String keyword;

    public GetNewsKeywordRequestDTO() {
    }

    public GetNewsKeywordRequestDTO(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}

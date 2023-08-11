package com.example.myapplication2.model;

public class News {
    private  String title, resource, date;

    public News() {
    }

    public News(String title, String resource, String date) {
        this.title = title;
        this.resource = resource;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

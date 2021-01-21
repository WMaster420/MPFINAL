package com.example.mpfinalproject.models;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String Name;
    private String Email;
    private int grades;

    public Post() {

    }

    public Post(String name, String email, int grades) {
        Name = name;
        Email = email;
        this.grades = grades;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getGrades() {
        return grades;
    }

    public void setGrades(int grades) {
        this.grades = grades;
    }
}

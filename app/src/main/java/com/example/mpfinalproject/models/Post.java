package com.example.mpfinalproject.models;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String Name;
    private String Email;
    private int password;

    public Post() {

    }

    public Post(String name, String email, int password) {
        Name = name;
        Email = email;
        this.password = password;
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

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}

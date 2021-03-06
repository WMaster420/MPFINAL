package com.example.mpfinalproject.api_interfaces;

import com.example.mpfinalproject.models.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @GET("/data")
    Call<List<Post>> getPosts();




    @POST("/register")

    Call<Post> createPost(@Body Post post);
}

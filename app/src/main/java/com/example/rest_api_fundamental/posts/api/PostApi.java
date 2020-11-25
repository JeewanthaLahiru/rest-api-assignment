package com.example.rest_api_fundamental.posts.api;

import com.example.rest_api_fundamental.posts.model.Post;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostApi {

    @GET("/posts/1")
    Call<Post> getPost();
}

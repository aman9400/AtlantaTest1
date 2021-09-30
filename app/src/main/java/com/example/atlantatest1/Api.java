package com.example.atlantatest1;

import com.example.atlantatest1.bean.Example;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://jsonplaceholder.typicode.com/";
    @GET("users")
    Call<List<Example>> getUserData();
}

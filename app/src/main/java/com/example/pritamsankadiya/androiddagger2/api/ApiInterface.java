package com.example.pritamsankadiya.androiddagger2.api;

import com.example.pritamsankadiya.androiddagger2.model.RequestModel;
import com.example.pritamsankadiya.androiddagger2.model.ResponseModel;
import com.example.pritamsankadiya.androiddagger2.model.Songs;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @Headers("Content-Type: application/json")
    @POST("/api/users/login")
    Call<ResponseModel> login(@Body RequestModel requestModel);

    @GET("/v2/5ca8555e520000ee2497b765")
    Call<Songs> allSongs();

    @GET("/v2/5ca89970520000582697b7db")
    Call<Songs> getAllImages();
}

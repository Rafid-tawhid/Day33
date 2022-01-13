package com.example.day33.network;

import com.example.day33.models.PhotoModel;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotoServiceApi {
    @GET("photos")
    Call<List<PhotoModel>> getAllPhotos();
}

package com.example.day33.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitServicee {
    public static PhotoServiceApi getService(){
        final Retrofit retrofit  = new Retrofit.Builder().baseUrl("http://jsonplaceholder.typicode.com/").
                addConverterFactory(GsonConverterFactory.create()).build();
        return retrofit.create(PhotoServiceApi.class);


}
        }

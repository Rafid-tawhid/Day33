package com.example.day33.repository;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.day33.models.PhotoModel;
import com.example.day33.network.RetrofitServicee;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotoDownloadRepository {

   public LiveData<List<PhotoModel>> getAllPhotos(){
        MutableLiveData<List<PhotoModel>> photoLiveData=new MutableLiveData<>();
        RetrofitServicee.getService().getAllPhotos().enqueue(new Callback<List<PhotoModel>>() {
            @Override
            public void onResponse(Call<List<PhotoModel>> call, Response<List<PhotoModel>> response) {
                if(response.code() == 200){
                    final List<PhotoModel> photoModels =  response.body();
                    photoLiveData.postValue(photoModels);
                }
            }

            @Override
            public void onFailure(Call<List<PhotoModel>> call, Throwable t) {

                Log.d("ee",t.getLocalizedMessage());

            }
        });

        return photoLiveData;
    }
}

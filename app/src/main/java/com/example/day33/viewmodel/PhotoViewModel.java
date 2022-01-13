package com.example.day33.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.day33.models.PhotoModel;
import com.example.day33.repository.PhotoDownloadRepository;

import java.util.List;

public class PhotoViewModel extends ViewModel {
    private PhotoDownloadRepository repository;
    public PhotoViewModel(){
        repository=new PhotoDownloadRepository();
    }
    public LiveData<List<PhotoModel>> getPhotos(){
       return repository.getAllPhotos();
    }

}

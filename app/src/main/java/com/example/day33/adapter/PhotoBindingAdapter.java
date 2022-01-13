package com.example.day33.adapter;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.example.day33.R;
import com.squareup.picasso.Picasso;


public class PhotoBindingAdapter {
    @BindingAdapter(value = "app:setPhoto")
    public static void setPhoto(ImageView imageView,String url){
        Picasso.get().load(url).placeholder(R.drawable.ic_launcher_background).into(imageView);
    }
}

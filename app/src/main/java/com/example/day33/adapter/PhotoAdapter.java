package com.example.day33.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.day33.databinding.PhotoRowBinding;
import com.example.day33.models.PhotoModel;

public class PhotoAdapter extends ListAdapter<PhotoModel, PhotoAdapter.PhotoViewHolder> {

public PhotoAdapter(){
    super(new PhotoDiff());
}

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        PhotoRowBinding binding=PhotoRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);

        return new PhotoViewHolder(binding);

    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
    final PhotoModel model=getItem(position);
    holder.bind(model);

    }

    static class PhotoDiff extends DiffUtil.ItemCallback<PhotoModel>{

      @Override
      public boolean areItemsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
          return oldItem.getId()==newItem.getId();
      }


      @Override
      public boolean areContentsTheSame(@NonNull PhotoModel oldItem, @NonNull PhotoModel newItem) {
          return oldItem.getId().equals(newItem.getId());
      }
  }


  class PhotoViewHolder extends RecyclerView.ViewHolder{
      PhotoRowBinding binding;
      public PhotoViewHolder(PhotoRowBinding binding){
          super(binding.getRoot());
          this.binding=binding;
      }
      public void bind(PhotoModel model){
          binding.setModel(model);
      }
  }
}

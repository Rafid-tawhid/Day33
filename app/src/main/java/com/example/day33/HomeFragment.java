package com.example.day33;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day33.adapter.PhotoAdapter;
import com.example.day33.databinding.FragmentHomeBinding;
import com.example.day33.models.PhotoModel;
import com.example.day33.network.RetrofitServicee;
import com.example.day33.viewmodel.PhotoViewModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private PhotoViewModel viewModel;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(inflater,container,false);
        viewModel=new ViewModelProvider(requireActivity()).get(PhotoViewModel.class);
        final PhotoAdapter adapter=new PhotoAdapter();

        binding.rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rv.setAdapter(adapter);

        viewModel.getPhotos().observe(getViewLifecycleOwner(), new Observer<List<PhotoModel>>() {
            @Override
            public void onChanged(List<PhotoModel> photoModels) {
             adapter.submitList(photoModels);

            }
        });

        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}
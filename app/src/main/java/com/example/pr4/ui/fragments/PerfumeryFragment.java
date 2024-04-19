package com.example.pr4.ui.fragments;

import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pr4.R;
import com.example.pr4.data.data_source.Data;
import com.example.pr4.data.repository.Repository;
import com.example.pr4.databinding.FragmentPerfumeryBinding;
import com.example.pr4.ui.adapters.PerfumeryAdapter;
import com.example.pr4.ui.adapters.RecyclerAdapter;
import com.example.pr4.ui.vm.MainViewModel;


public class PerfumeryFragment extends Fragment {
    FragmentPerfumeryBinding binding;
    private MainViewModel viewViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentPerfumeryBinding.inflate(inflater);

        binding.listPerfumery.setLayoutManager(new LinearLayoutManager(requireContext()));
        PerfumeryAdapter adapter = new PerfumeryAdapter();
        binding.listPerfumery.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(v ->
                viewViewModel.addPerfumery(binding.editTextPerfumeryName.getText().toString())
        );

        viewViewModel.getAllPerfumery().observe(getViewLifecycleOwner(), perfumery ->
                adapter.setPerfumeryEntities(perfumery));
        return binding.getRoot();
    }
}
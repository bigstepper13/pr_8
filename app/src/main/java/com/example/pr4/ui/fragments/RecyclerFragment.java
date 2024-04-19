package com.example.pr4.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pr4.R;
import com.example.pr4.ui.adapters.RecyclerAdapter;
import com.example.pr4.ui.vm.RecyclerViewModel;


public class RecyclerFragment extends Fragment {
    private RecyclerViewModel viewModel;
    private RecyclerView recyclerView;
    private TextView recycler;

    public RecyclerFragment() {super(R.layout.fragment_recycler); }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(RecyclerViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = getActivity().findViewById(R.id.recyclerView);
        recycler = getActivity().findViewById(R.id.recycler);
        String data = getArguments().getString("key");
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerAdapter adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);
        if (data == "men perfumery") {
            viewModel.getMenData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getMen().observe(getViewLifecycleOwner(), text->
                    recycler.setText(text));
        } else if (data == "women perfumery") {
            viewModel.getWomenData().observe(getViewLifecycleOwner(), list ->
                    adapter.updateList(list));
            viewModel.getWomen().observe(getViewLifecycleOwner(), text->
                    recycler.setText(text));
        }
    }
}


package com.example.pr4.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.pr4.R;
import com.example.pr4.ui.vm.MainViewModel;

public class MainFragment extends Fragment {
    private MainViewModel viewModel;
    private Button buttonCheckMenPerfumery;
    private Button buttonCheckWomenPerfumery;

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        buttonCheckMenPerfumery = (Button) getActivity().findViewById(R.id.button_check_men_perfumery);
        buttonCheckWomenPerfumery = (Button) getActivity().findViewById(R.id.button_women_perfumery);
        viewModel.getButtonNavigateToMen().observe(getViewLifecycleOwner(), text ->
                buttonCheckMenPerfumery.setText(text));
        viewModel.getButtonNavigateToWomen().observe(getViewLifecycleOwner(), text ->
                buttonCheckWomenPerfumery.setText(text));
        buttonCheckMenPerfumery.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "men perfumery");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
        buttonCheckWomenPerfumery.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "women perfumery");
            Navigation.findNavController(v).navigate(R.id.action_mainFragment_to_recyclerFragment, bundle);
        });
    }
}

package com.example.pr4.ui.fragments;

import android.os.Bundle;
import android.util.Log;
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
import com.example.pr4.data.SharedPreferenceUtils;
import com.example.pr4.ui.vm.MainViewModel;
import com.example.pr4.data.FileUtils;
import com.example.pr4.databinding.FragmentMainBinding;

public class MainFragment extends Fragment {
    FragmentMainBinding binding;
    private MainViewModel viewModel;
    private Button buttonCheckMenPerfumery;
    private Button buttonCheckWomenPerfumery;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FileUtils.writeToFile(requireContext(), "dataFile.txt", "startFragment");

        binding = FragmentMainBinding.inflate(inflater, container, false);

        boolean result = FileUtils.writeToExternalStorage("example.txt", "текст");
        if (result) {
            Log.i("write", "Файл успешно создан и данные записаны");
        } else {
            Log.i("write", "Ошибка при создании файла или записи данных");
        }

        SharedPreferenceUtils.saveData(requireContext(), "data");

        binding = FragmentMainBinding.inflate(inflater, container, false);

        viewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return binding.getRoot();
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

        binding.navigateToPerfumery.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_perfumeryFragment));
    }
}



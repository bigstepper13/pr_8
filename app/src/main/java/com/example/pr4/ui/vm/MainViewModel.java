package com.example.pr4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pr4.data.model.PerfumeryEntity;
import com.example.pr4.data.repository.Repository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private LiveData<String> buttonNavigateToMen;
    private LiveData<String> buttonNavigateToWomen;

    Repository Repository;

    public LiveData<List<PerfumeryEntity>> getAllPerfumery() {
        return Repository.getAllPerfumery();
    }

    public void addPerfumery(String name) {
        Repository.addPerfumery(new PerfumeryEntity(name));
    }

    public MainViewModel(@NonNull Application application) {
        super(application);

        Repository = new Repository(application);
    }

    public LiveData<String> getButtonNavigateToMen() {
        return buttonNavigateToMen;
    }
    public LiveData<String> getButtonNavigateToWomen() {
        return buttonNavigateToWomen;
    }
}


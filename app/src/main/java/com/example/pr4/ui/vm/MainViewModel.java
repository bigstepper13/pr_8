package com.example.pr4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pr4.repository.Repository;

public class MainViewModel extends AndroidViewModel {
    private LiveData<String> buttonNavigateToMen;
    private LiveData<String> buttonNavigateToWomen;

    public MainViewModel(@NonNull Application application) {
        super(application);
        Repository repository = new Repository();
        buttonNavigateToMen = repository.getNavigateButtonMen();
        buttonNavigateToWomen = repository.getNavigateButtonWomen();

    }

    public LiveData<String> getButtonNavigateToMen() {
        return buttonNavigateToMen;
    }
    public LiveData<String> getButtonNavigateToWomen() {
        return buttonNavigateToWomen;
    }
}
package com.example.pr4.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.pr4.data.AppDatabase;
import com.example.pr4.data.data_source.Data;
import com.example.pr4.data.model.ModelItem;
import com.example.pr4.data.model.PerfumeryEntity;

import java.util.List;

public class Repository {

    private AppDatabase appDatabase;

    public Repository(Application application) {
        appDatabase = AppDatabase.getDataBase(application);
    }
    public LiveData<List<PerfumeryEntity>> getAllPerfumery() {
        return appDatabase.perfumeryDao().getAllItems();
    }

    public void addPerfumery(PerfumeryEntity perfumery) {
        AppDatabase.databaseWriterExecutor.execute(() -> {
            appDatabase.perfumeryDao().insert(perfumery);
        });
    }

    public LiveData<List<ModelItem>> getMenData() { return Data.buildMenData(); }
    public LiveData<List<ModelItem>> getWomenData() { return Data.buildWomenData(); }
    public LiveData<String> getNavigateButtonMen() { return Data.getNavigateToMen(); }
    public LiveData<String> getNavigateButtonWomen() { return Data.getNavigateToWomen(); }
    public LiveData<String> getMen() { return Data.getMen(); }
    public LiveData<String> getWomen() { return Data.getWomen(); }
}

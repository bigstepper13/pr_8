package com.example.pr4.repository;

import androidx.lifecycle.LiveData;

import com.example.pr4.data_source.Data;
import com.example.pr4.model.ModelItem;

import java.util.List;

public class Repository {

    public LiveData<List<ModelItem>> getMenData() { return Data.buildMenData(); }
    public LiveData<List<ModelItem>> getWomenData() { return Data.buildWomenData(); }
    public LiveData<String> getNavigateButtonMen() { return Data.getNavigateToMen(); }
    public LiveData<String> getNavigateButtonWomen() { return Data.getNavigateToWomen(); }
    public LiveData<String> getMen() { return Data.getMen(); }
    public LiveData<String> getWomen() { return Data.getWomen(); }
}
package com.example.pr4.data.data_source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pr4.R;
import com.example.pr4.data.model.ModelItem;

import java.util.ArrayList;
import java.util.List;

public class Data {

    public static LiveData<List<ModelItem>> buildMenData() {
        MutableLiveData<List<ModelItem>> menData = new MutableLiveData<>();
        ArrayList<ModelItem> men = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            men.add(new ModelItem("Men's perfume № " + (i + 1), R.drawable.men));
        }
        menData.setValue(men);
        return menData;
    }

    public static LiveData<List<ModelItem>> buildWomenData() {
        MutableLiveData<List<ModelItem>> womenData = new MutableLiveData<>();
        ArrayList<ModelItem> women = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            women.add(new ModelItem("Women's perfume № " + (i + 1), R.drawable.women));
        }
        womenData.setValue(women);
        return womenData;
    }

    public static LiveData<String> getNavigateToMen() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к мужским ароматам");
        return data;
    }

    public static LiveData<String> getNavigateToWomen() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к женским ароматам");
        return data;
    }

    public static LiveData<String> getMen() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Мужские ароматы");
        return data;
    }

    public static LiveData<String> getWomen() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Женские ароматы");
        return data;
    }
}
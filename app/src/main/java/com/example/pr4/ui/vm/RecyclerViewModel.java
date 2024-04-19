package com.example.pr4.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pr4.data.model.ModelItem;
import com.example.pr4.data.repository.Repository;

import java.util.List;

public class RecyclerViewModel extends AndroidViewModel {
    private LiveData<List<ModelItem>> menData;
    private LiveData<List<ModelItem>> womenData;
    private LiveData<String> men;
    private LiveData<String> women;
    public RecyclerViewModel(@NonNull Application application) {
        super(application);
        Repository repository = new Repository(application);
        menData = repository.getMenData();
        womenData = repository.getWomenData();
        men = repository.getMen();
        women = repository.getWomen();
    }

    public LiveData<List<ModelItem>> getMenData() {
        return menData;
    }

    public LiveData<String> getMen() {
        return men;
    }

    public LiveData<List<ModelItem>> getWomenData() {
        return womenData;
    }

    public LiveData<String> getWomen() {
        return women;
    }
}


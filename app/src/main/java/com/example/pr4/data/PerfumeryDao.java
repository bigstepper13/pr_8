package com.example.pr4.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pr4.data.model.PerfumeryEntity;

import java.util.List;

@Dao
public interface PerfumeryDao {
    @Query("SELECT * FROM perfumeryentity")
    LiveData<List<PerfumeryEntity>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(PerfumeryEntity entity);
}

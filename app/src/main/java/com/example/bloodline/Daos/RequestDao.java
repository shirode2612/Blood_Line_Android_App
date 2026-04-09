package com.example.bloodline.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bloodline.DataModels.RequestModel;

import java.util.List;



@Dao
public interface RequestDao
{
    @Query("SELECT * FROM RequestModel")
    List<RequestModel> getAllRequest();

    @Insert
    void insertRequest(RequestModel req);

    @Update
    void updateRequest(RequestModel req);

    @Delete
    void deleteRequest(RequestModel req);
}





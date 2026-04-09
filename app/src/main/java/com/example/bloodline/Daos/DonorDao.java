package com.example.bloodline.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bloodline.DataModels.DonorModel;


import java.util.List;



@Dao
public interface DonorDao
{
    @Query("SELECT * FROM DonorModel")
    List<DonorModel> getAllDonor();

    @Insert
    void insertDonort(DonorModel don);

    @Update
    void updateDonor(DonorModel don);

    @Delete
    void deleteDonor(DonorModel don);

    @Query("SELECT * FROM DonorModel WHERE D_bloodgroup=:bgroup")
    List<DonorModel> getDonorsByBG(String bgroup);

}


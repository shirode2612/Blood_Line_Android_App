package com.example.bloodline.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.DataModels.UserModel;

import java.util.List;



@Dao
public interface BankDao
{
    @Query("SELECT * FROM BloodBankModel")
    List<BloodBankModel> getAllBank();

    @Insert
    void insertBank(BloodBankModel bankModel);

    @Update
    void updateBank(BloodBankModel bankModel);

    @Delete
    void deleteBank( BloodBankModel bankModel);

    @Query("SELECT * FROM BloodBankModel WHERE bloodGroup=:bg")
    BloodBankModel getStatusByBloodGroup(String bg);

}

package com.example.bloodline.Utilities;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.bloodline.Daos.BankDao;
import com.example.bloodline.Daos.DonorDao;
import com.example.bloodline.Daos.RequestDao;
import com.example.bloodline.Daos.UserDao;
import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.DataModels.UserModel;

@Database(version = 1, entities = {RequestModel.class, DonorModel.class, BloodBankModel.class, UserModel.class},exportSchema = false)
public abstract class AppDatabase extends RoomDatabase
{
    public abstract RequestDao requestDao();
    public abstract DonorDao donorDao();
    public abstract BankDao bankDao();
    public abstract UserDao userDao();
}

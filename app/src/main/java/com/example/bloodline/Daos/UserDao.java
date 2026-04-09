package com.example.bloodline.Daos;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;


import com.example.bloodline.DataModels.UserModel;

import java.util.List;



@Dao
public interface UserDao
{
    @Query("SELECT * FROM UserModel")
    List<UserModel> getAllUser();

    @Insert
    long insertUser(UserModel userModel);

    @Update
    void updateUser(UserModel userModel);

    @Delete
    void deleteUser(UserModel userModel);

    @Query("SELECT * FROM UserModel WHERE  U_contact=:mbl and U_password=:pass")
    UserModel getUserWithMblNoAndpass(String mbl,String pass);
}


package com.example.bloodline.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class UserModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int U_id;

    @ColumnInfo(name = "U_email")
    private String U_email;

    @ColumnInfo(name = "U_password")
    private String U_password;

    @ColumnInfo(name = "U_contact")
    private String U_contact;

    @ColumnInfo(name = "isDonor")
    private Boolean isDonor;


    public int getU_id()
    {
        return U_id;
    }

    public void setU_id(int u_id) {
        U_id = u_id;
    }

    public String getU_email() {
        return U_email;
    }

    public void setU_email(String u_email) {
        U_email = u_email;
    }

    public String getU_password() {
        return U_password;
    }

    public void setU_password(String u_password) {
        U_password = u_password;
    }

    public String getU_contact() {
        return U_contact;
    }

    public void setU_contact(String u_contact) {
        U_contact = u_contact;
    }

    public Boolean getDonor() {
        return isDonor;
    }

    public void setDonor(Boolean donor) {
        isDonor = donor;
    }
}


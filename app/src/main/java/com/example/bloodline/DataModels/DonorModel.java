package com.example.bloodline.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class DonorModel implements Serializable

{    @PrimaryKey(autoGenerate = true)
     private int D_id;

     @ColumnInfo(name = "D_bloodgroup")
     private String D_bloodgoup;

     @ColumnInfo(name = "D_name")
      private String D_name;

     @ColumnInfo (name = "D_address")
      private String D_address;

     @ColumnInfo (name = "D_mobno")
     private String D_mobno;

    @ColumnInfo (name = "D_age")
    private String D_age;

    @ColumnInfo (name = "D_city")
      private String D_city;

     @ColumnInfo(name = "isDonor")
     private boolean isDonor;

     @ColumnInfo(name="D_image")
     private byte[] D_image;

    @ColumnInfo (name = "D_email")
    private String D_email;



    public DonorModel() {
    }

    public DonorModel(int d_id, String d_bloodgoup, String d_name, String d_address, String d_mobno, String d_age, String d_city, boolean isDonor, byte[] d_image, String d_email) {
        D_id = d_id;
        D_bloodgoup = d_bloodgoup;
        D_name = d_name;
        D_address = d_address;
        D_mobno = d_mobno;
        D_age = d_age;
        D_city = d_city;
        this.isDonor = isDonor;
        D_image = d_image;
        D_email = d_email;
    }

    public String getD_name() {
        return D_name;
    }

    public void setD_name(String d_name) {
        D_name = d_name;
    }

    public String getD_address() {
        return D_address;
    }

    public void setD_address(String d_address) {
        D_address = d_address;
    }

    public String getD_mobno() {
        return D_mobno;
    }

    public void setD_mobno(String d_mobno) {
        D_mobno = d_mobno;
    }

    public String getD_city() {
        return D_city;
    }

    public void setD_city(String d_city)
    {
        D_city = d_city;
    }

    public int getD_id() {
        return D_id;
    }

    public void setD_id(int d_id) {
        D_id = d_id;
    }

    public String getD_bloodgoup() {
        return D_bloodgoup;
    }

    public void setD_bloodgoup(String d_bloodgoup) {
        D_bloodgoup = d_bloodgoup;
    }

    public boolean isDonor() {
        return isDonor;
    }

    public void setDonor(boolean donor) {
        isDonor = donor;
    }

    public String getD_email() {
        return D_email;
    }

    public void setD_email(String d_email) {
        D_email = d_email;
    }

    public byte[] getD_image() {
        return D_image;
    }

    public void setD_image(byte[] d_image) {
        D_image = d_image;
    }

    public String getD_age() {
        return D_age;
    }

    public void setD_age(String d_age) {
        D_age = d_age;
    }
}

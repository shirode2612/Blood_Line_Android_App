package com.example.bloodline.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
@Entity
public class BloodBankModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "images")
    private int  images;

    @ColumnInfo(name = "packages")
      private int packages;

    @ColumnInfo(name = "bloodGroup")
    private String bloodGroup;

    public BloodBankModel(int images, int packages)
    {
        this.images = images;
        this.packages = packages;
    }

    public int getImages()
    {
        return images;
    }

    public void setImages(int images)
    {
        this.images = images;
    }

    public int getPackages()
    {
        return packages;
    }

    public void setPackages(int packages)
    {
        this.packages = packages;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public BloodBankModel()
    {
    }

    public BloodBankModel(int images, int packages, String bloodGroup) {
        this.images = images;
        this.packages = packages;
        this.bloodGroup = bloodGroup;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}


package com.example.bloodline.DataModels;

import androidx.room.ColumnInfo;

public class BloodInfoModel
{
    private int  images;

    private String info;

    public BloodInfoModel(int images, String info)
    {
        this.images = images;
        this.info = info;
    }

    public int getImages()
    {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

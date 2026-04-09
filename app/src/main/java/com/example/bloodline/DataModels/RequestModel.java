package com.example.bloodline.DataModels;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity
public class RequestModel implements Serializable
{
    @PrimaryKey(autoGenerate = true)
    private int reqId;

    @ColumnInfo(name = "R_name")
    private String R_name;

    @ColumnInfo(name = "R_city")
    private String R_city;


    @ColumnInfo (name = "R_age")
    private String R_age;


    @ColumnInfo(name = "R_blood")
     private String R_blood;

    @ColumnInfo(name = "R_bag")
     private String R_bag;

    @ColumnInfo(name = "R_mobile")
     private String R_mobile;

    @ColumnInfo(name ="R_date")
     private String R_date;

    @ColumnInfo (name = "R_time")
    private String R_time;

    @ColumnInfo (name = "R_hospital")
     private String R_hospital;

    @ColumnInfo (name = "R_need")
    private String R_need;


    public RequestModel(int reqId, String r_name, String r_city, String r_age, String r_blood, String r_bag, String r_mobile, String r_date, String r_time, String r_hospital, String r_need) {
        this.reqId = reqId;
        R_name = r_name;
        R_city = r_city;
        R_age = r_age;
        R_blood = r_blood;
        R_bag = r_bag;
        R_mobile = r_mobile;
        R_date = r_date;
        R_time = r_time;
        R_hospital = r_hospital;
        R_need = r_need;
    }

    public RequestModel() {
    }

    public int getReqId() {
        return reqId;
    }

    public void setReqId(int reqId) {
        this.reqId = reqId;
    }

    public String getR_name() {
        return R_name;
    }

    public void setR_name(String r_name) {
        R_name = r_name;
    }

    public String getR_city() {
        return R_city;
    }

    public void setR_city(String r_city) {
        R_city = r_city;
    }

    public String getR_blood() {
        return R_blood;
    }

    public void setR_blood(String r_blood) {
        R_blood = r_blood;
    }

    public String getR_bag() {
        return R_bag;
    }

    public void setR_bag(String r_bag) {
        R_bag = r_bag;
    }

    public String getR_mobile() {
        return R_mobile;
    }

    public void setR_mobile(String r_mobile) {
        R_mobile = r_mobile;
    }

    public String getR_date() {
        return R_date;
    }

    public void setR_date(String r_date) {
        R_date = r_date;
    }

    public String getR_time() {
        return R_time;
    }

    public void setR_time(String r_time) {
        R_time = r_time;
    }

    public String getR_hospital() {
        return R_hospital;
    }

    public void setR_hospital(String r_hospital) {
        R_hospital = r_hospital;
    }

    public String getR_need() {
        return R_need;
    }

    public void setR_need(String r_need) {
        R_need = r_need;
    }

    public String getR_age() {
        return R_age;
    }

    public void setR_age(String r_age) {
        R_age = r_age;
    }
}
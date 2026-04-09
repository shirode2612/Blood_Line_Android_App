package com.example.bloodline.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.DonorlistFragmentAdapter;
import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.ArrayList;
import java.util.List;


public class DonorListActivity extends AppCompatActivity
{
    RecyclerView rvBloodGroup;
    List<DonorModel> donerList=new ArrayList<>();
    String strBg="";
    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.donorlistlayoutrecyclerview);

        strBg=getIntent().getStringExtra("bg");

        donerList= DataBaseClient.getInstance(getApplicationContext())
                .getDatabase()
                .donorDao()
                .getDonorsByBG(strBg);

        rvBloodGroup=findViewById(R.id.rvBloodGroup);


        /*donerList.add(new DonorModel("Rakesh Roshan","Devidas Colony","8087046130","Jalgaon"));
        donerList.add(new DonorModel("karan Sharma","Ramanand nagar","2578941360","Nashik"));
        donerList.add(new DonorModel("Riya patil","Mohan Nagar","9856321470","Amalner"));
        donerList.add(new DonorModel("Param Chopda","Omkar Nagar","9532147805","Pune"));
        donerList.add(new DonorModel("Radha sharma","Lakshmi Nagar","985321470","Bhusawal"));
        donerList.add(new DonorModel("Shilpa pande","Rachana Colony","985321470","Dhule"));
        donerList.add(new DonorModel("Rajeev Agrawal","Pande Chowk","985321470","Jalgaon"));
        donerList.add(new DonorModel("Pooja yevale","Radhakisan Wadi","985321470","Indor"));
        donerList.add(new DonorModel("Ramesh patil","Piprala Road","985321470","Amaravati"));
        donerList.add(new DonorModel("Tina kolhe","Gurudev Colony","985321470","Sangali"));
*/

        DonorlistFragmentAdapter donorlistFragmentAdapter = new DonorlistFragmentAdapter(donerList,this);
        rvBloodGroup.setLayoutManager(new LinearLayoutManager(this,LinearLayout.VERTICAL,false));
        rvBloodGroup.setAdapter(donorlistFragmentAdapter);
        donorlistFragmentAdapter.notifyDataSetChanged();




    }

}

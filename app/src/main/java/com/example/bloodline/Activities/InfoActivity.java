package com.example.bloodline.Activities;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.BloodInfoAdapter;
import com.example.bloodline.DataModels.BloodInfoModel;
import com.example.bloodline.R;

import java.util.ArrayList;
import java.util.List;

public class InfoActivity extends AppCompatActivity
{

    List<BloodInfoModel> infolist=new ArrayList<>();
    RecyclerView rv_BGroup;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info_recyclerview_layout);

        rv_BGroup=findViewById(R.id.rv_BGroup);

        infolist.add(new BloodInfoModel(R.drawable.a_positive,"Blood A+ can donate to A+ and AB+."));
        infolist.add(new BloodInfoModel(R.drawable.a_negative,"Blood A- can donate to A+,A-,AB+ and AB-."));
        infolist.add(new BloodInfoModel(R.drawable.b_posotive," Blood B+ can donate to B+ and AB+."));
        infolist.add(new BloodInfoModel(R.drawable.b_negative,"Blood B- can donate to B+,B-,AB+ and AB-. "));
        infolist.add(new BloodInfoModel(R.drawable.ab_positive,"Blood AB+ can donate to AB+."));
        infolist.add(new BloodInfoModel(R.drawable.ab_negative,"Blood AB- can donate to AB+ and And AB-."));
        infolist.add(new BloodInfoModel(R.drawable.o_positive,"Blood O+ can donate to A+,B+,AB+ and O+. "));
        infolist.add(new BloodInfoModel(R.drawable.o_negative,"Blood O- can donate to A+,A-,B+,B-,AB+,AB-,O+ and O-."));


        BloodInfoAdapter bloodInfoAdapter = new BloodInfoAdapter(infolist,this);
        rv_BGroup.setLayoutManager(new LinearLayoutManager(this, LinearLayout.VERTICAL,false));
        rv_BGroup.setAdapter(bloodInfoAdapter);
        bloodInfoAdapter.notifyDataSetChanged();


    }
}

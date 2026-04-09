package com.example.bloodline.Fragment;


import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.AdminBankAdapter;
import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.ArrayList;
import java.util.List;



public class AdminBankStatusFragment extends Fragment  {
    List<BloodBankModel> banklist=new ArrayList();
    private RecyclerView rv_bloodbank;
    private Context ctx;
    String[] BloodList;



    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        ctx = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.admin_bank_recycler_layout,container,false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rv_bloodbank = view.findViewById(R.id.rv_bloodbank);


        banklist= DataBaseClient.getInstance(getContext()).getDatabase()
                .bankDao().getAllBank();



      /*  banklist.add(new BloodBankModel(R.drawable.a_positive,34));
        banklist.add(new BloodBankModel(R.drawable.a_negative,27));
        banklist.add(new BloodBankModel(R.drawable.b_posotive,44));
        banklist.add(new BloodBankModel(R.drawable.b_negative,17));
        banklist.add(new BloodBankModel(R.drawable.ab_positive,55));
        banklist.add(new BloodBankModel(R.drawable.ab_negative,21));
        banklist.add(new BloodBankModel(R.drawable.o_positive,35));
        banklist.add(new BloodBankModel(R.drawable.o_negative,12));

       */

        AdminBankAdapter adminBankAdapter = new AdminBankAdapter(banklist,ctx);
        rv_bloodbank.setLayoutManager(new LinearLayoutManager(ctx,LinearLayout.VERTICAL,false));
        rv_bloodbank.setAdapter(adminBankAdapter);
        adminBankAdapter.notifyDataSetChanged();


    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }



}

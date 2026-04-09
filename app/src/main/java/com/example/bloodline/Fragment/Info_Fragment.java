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

import com.example.bloodline.Adapter.BloodInfoAdapter;

import com.example.bloodline.DataModels.BloodInfoModel;

import com.example.bloodline.R;

import java.util.ArrayList;
import java.util.List;

public class Info_Fragment extends Fragment
{
    List<BloodInfoModel> infolist=new ArrayList<>();
    RecyclerView rv_BGroup;
    Context ctx;


    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        ctx=context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.info_recyclerview_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        rv_BGroup=view.findViewById(R.id.rv_BGroup);



        BloodInfoAdapter bloodInfoAdapter = new BloodInfoAdapter(infolist,ctx);
        rv_BGroup.setLayoutManager(new LinearLayoutManager(ctx,LinearLayout.VERTICAL,false));
        rv_BGroup.setAdapter(bloodInfoAdapter);
        bloodInfoAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}

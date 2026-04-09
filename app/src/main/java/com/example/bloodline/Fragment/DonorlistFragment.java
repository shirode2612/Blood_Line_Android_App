package com.example.bloodline.Fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Adapter.BloodGroupAdapter;
import com.example.bloodline.R;

import java.util.ArrayList;
import java.util.List;

public class DonorlistFragment extends Fragment
{
    List<Integer> bgList = new ArrayList();

    private RecyclerView rvBloodGroup;
    private Context ctx;

    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        ctx=context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.donorlistlayoutrecyclerview,container,false);
    }

    @SuppressLint("WrongConstant")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        rvBloodGroup = view.findViewById(R.id.rvBloodGroup);

        bgList.add(R.drawable.a_positive);
        bgList.add(R.drawable.a_negative);
        bgList.add(R.drawable.b_posotive);
        bgList.add(R.drawable.b_negative);
        bgList.add(R.drawable.ab_positive);
        bgList.add(R.drawable.ab_negative);
        bgList.add(R.drawable.o_positive);
        bgList.add(R.drawable.o_negative);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2,LinearLayoutManager.VERTICAL,false);
        rvBloodGroup.setLayoutManager(gridLayoutManager);

        BloodGroupAdapter bloodGroupAdapter=new BloodGroupAdapter(bgList,ctx);
        rvBloodGroup.setLayoutManager(gridLayoutManager);
        rvBloodGroup.setAdapter(bloodGroupAdapter);
        bloodGroupAdapter.notifyDataSetChanged();

    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }
}

package com.example.bloodline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.bloodline.DataModels.BloodInfoModel;

import com.example.bloodline.R;

import java.util.List;

public class BloodInfoAdapter extends RecyclerView.Adapter<BloodInfoAdapter.ViewHolder>
{
    List<BloodInfoModel> infolist;
    Context context;

    public BloodInfoAdapter(List<BloodInfoModel> infolist, Context context)
    {
        this.infolist = infolist;
        this.context = context;
    }

    @NonNull
    @Override
    public BloodInfoAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new BloodInfoAdapter.ViewHolder(LayoutInflater.from(context).inflate(R.layout.blood_information_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull BloodInfoAdapter.ViewHolder holder, int position)
    {
        final BloodInfoModel bloodInfoModel = infolist.get(position);

        holder.txtinfo.setText(bloodInfoModel.getInfo());
        holder.img_1.setImageResource(bloodInfoModel.getImages());





    }

    @Override
    public int getItemCount() {
        return infolist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtinfo;
        ImageView img_1;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtinfo=itemView.findViewById(R.id.txtinfo);
            img_1=itemView.findViewById(R.id.img_1);


        }
    }
}

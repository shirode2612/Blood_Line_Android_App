package com.example.bloodline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.Activities.DonorListActivity;
import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.Fragment.DonorlistFragment;
import com.example.bloodline.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BloodGroupAdapter extends RecyclerView.Adapter<BloodGroupAdapter.MyViewHolder>
{
    List<Integer> bgList;
    Context context;

    public BloodGroupAdapter(List<Integer> bgList,Context context)
    {
        this.bgList = bgList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.bloodgroupitemlayout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        holder.profile_image.setImageResource(bgList.get(position));
        final Intent intent = new Intent(context, DonorListActivity.class);
        switch (position)
        {
            case 0:
                intent.putExtra("bg","A+");
                break;
            case 1:
                intent.putExtra("bg","A-");
                break;
            case 2:
                intent.putExtra("bg","B+");
                break;
            case 3:
                intent.putExtra("bg","B-");
                break;
            case 4:
                intent.putExtra("bg","AB+");
                break;
            case 5:
                intent.putExtra("bg","AB-");
                break;
            case 6:
                intent.putExtra("bg","O+");
                break;
            case 7:
                intent.putExtra("bg","O-");
                break;
        }


        holder.profile_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                context.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount()
    {
        return bgList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
          //TextView txt_bg;
        CircleImageView profile_image;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            profile_image=itemView.findViewById(R.id.profile_image);
        }
    }
}

package com.example.bloodline.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class BloodBankAdapter extends RecyclerView.Adapter<BloodBankAdapter.ViewHolder>
{
    List<BloodBankModel> banklist;
    Context context;

    public BloodBankAdapter(List<BloodBankModel> banklist, Context context)
    {
        this.banklist=banklist;
        this.context = context;

    }


    @NonNull
    @Override
    public BloodBankAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.bloodbankstatuslayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull BloodBankAdapter.ViewHolder holder, int position)
    {

         BloodBankModel bloodBankModel= banklist.get(position);

        switch (bloodBankModel.getBloodGroup()){
            case "A+":
                holder.profile_image.setImageResource(R.drawable.a_positive);
                break;
            case "A-":
                holder.profile_image.setImageResource(R.drawable.a_negative);
                break;
            case "B+":
                holder.profile_image.setImageResource(R.drawable.b_posotive);
                break;

            case "B-":
                holder.profile_image.setImageResource(R.drawable.b_negative);
                break;

            case "AB+":
                holder.profile_image.setImageResource(R.drawable.ab_positive);
                break;

            case "AB-":
                holder.profile_image.setImageResource(R.drawable.ab_negative);
                break;

            case "O+":
                holder.profile_image.setImageResource(R.drawable.o_positive);
                break;
            case "O-":
                holder.profile_image.setImageResource(R.drawable.o_negative);
                break;

        }

        holder.txtno.setText(String.valueOf(bloodBankModel.getPackages()));






    }

    @Override
    public int getItemCount()
    {
        return banklist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtbloodg,txtpackage,txtno;
        CircleImageView profile_image;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtbloodg=itemView.findViewById(R.id.txtbloodg);
            txtpackage=itemView.findViewById(R.id.txtpackage);
            txtno=itemView.findViewById(R.id.txtno);
            profile_image=itemView.findViewById(R.id.profile_image);
        }
    }
}

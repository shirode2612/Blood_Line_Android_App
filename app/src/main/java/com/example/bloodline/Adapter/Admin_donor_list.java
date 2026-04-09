package com.example.bloodline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.R;


import java.util.List;

public class Admin_donor_list  extends RecyclerView.Adapter<Admin_donor_list.MyViewHolder>
{
    List<DonorModel> donorlist;
    Context context;

    public Admin_donor_list(List<DonorModel> donorlist, Context context)
    {
        this.donorlist = donorlist;
        this.context = context;
    }

    @NonNull
    @Override
    public Admin_donor_list.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new Admin_donor_list.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.admin_donor_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull Admin_donor_list.MyViewHolder holder, int position)
    {
        final DonorModel donorModel = donorlist.get(position);

        switch (donorModel.getD_bloodgoup())
        {
            case "A+":
                holder.img.setImageResource(R.drawable.a_positive);
                break;
            case "A-":
                holder.img.setImageResource(R.drawable.a_negative);
                break;
            case "B+":
                holder.img.setImageResource(R.drawable.b_posotive);
                break;

            case "B-":
                holder.img.setImageResource(R.drawable.b_negative);
                break;

            case "AB+":
                holder.img.setImageResource(R.drawable.ab_positive);
                break;

            case "AB-":
                holder.img.setImageResource(R.drawable.ab_negative);
                break;

            case "O+":
                holder.img.setImageResource(R.drawable.o_positive);
                break;
            case "O-":
                holder.img.setImageResource(R.drawable.o_negative);
                break;

        }


        holder.txtname.setText(donorModel.getD_name());
       // holder.txtemail.setText(donorModel.getD_email());
        // holder.txtbloodgroup.setText(donorModel.getD_bloodgroup());
        holder.txtmobno.setText(donorModel.getD_mobno());
        holder.txtdage.setText(donorModel.getD_age());
        holder.txtaddress.setText(donorModel.getD_address());
        holder.txtcity.setText(donorModel.getD_city());

        holder.txtmobno.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+donorModel.getD_mobno()));
                context.startActivity(callIntent);

            }
        });
    }

    @Override
    public int getItemCount()
    {
        return donorlist.size();
    }


    public void setFilterList(List<DonorModel>flist)
    {
        donorlist = flist;
        notifyDataSetChanged();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname,txtmobno,txtaddress,txtcity,txtemail,txtbloodgroup,txtdage;
        ImageView img;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
            img=itemView.findViewById(R.id.img);
            // txtid=itemView.findViewById(R.id.txtid);
            // txtbloodgroup=itemView.findViewById(R.id.txtbloodgroup);
            txtmobno=itemView.findViewById(R.id.txtmobno);
            txtaddress=itemView.findViewById(R.id.txtaddress);
            txtcity=itemView.findViewById(R.id.txtcity);
            txtemail=itemView.findViewById(R.id.txtemail);
            txtdage=itemView.findViewById(R.id.txtdage);


        }
    }
}

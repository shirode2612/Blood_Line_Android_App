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
import com.example.bloodline.DataModels.UserModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.UserMethods;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DonorlistFragmentAdapter extends RecyclerView.Adapter<DonorlistFragmentAdapter.ViewHolder>
{
    List<DonorModel> donorlist;
    Context context;

    public DonorlistFragmentAdapter(List<DonorModel> donorlist, Context context)
    {
        this.donorlist = donorlist;
        this.context = context;
    }


    @NonNull
    @Override
    public DonorlistFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.donorlistitemlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DonorlistFragmentAdapter.ViewHolder holder, int position)
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
        holder.img.setImageBitmap(UserMethods.imgConvertFromByteArrayToBitmap(donorModel.getD_image()));
        holder.txtname.setText(donorModel.getD_name());
        holder.txtemail.setText(donorModel.getD_email());
        holder.txtdage.setText(donorModel.getD_age());
       // holder.txtbloodgroup.setText(donorModel.getD_bloodgroup());
        holder.txtmobno.setText(donorModel.getD_mobno());
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

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtname,txtmobno,txtaddress,txtcity,txtemail,txtdage;
        CircleImageView img;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtname=itemView.findViewById(R.id.txtname);
            txtdage=itemView.findViewById(R.id.txtdage);
            img=itemView.findViewById(R.id.img);
           // txtid=itemView.findViewById(R.id.txtid);
           // txtbloodgroup=itemView.findViewById(R.id.txtbloodgroup);
            txtmobno=itemView.findViewById(R.id.txtmobno);
            txtaddress=itemView.findViewById(R.id.txtaddress);
            txtcity=itemView.findViewById(R.id.txtcity);
            txtemail=itemView.findViewById(R.id.txtemail);


        }
    }

}

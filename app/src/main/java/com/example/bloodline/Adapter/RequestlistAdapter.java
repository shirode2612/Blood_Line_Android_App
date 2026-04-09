package com.example.bloodline.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.R;

import java.util.List;

public class RequestlistAdapter extends RecyclerView.Adapter<RequestlistAdapter.ViewHolder>
{
    List<RequestModel> requestlist;
    Context context;

    public RequestlistAdapter(List<RequestModel> requestlist, Context context)
    {
        this.requestlist = requestlist;
        this.context = context;
    }


    @NonNull
    @Override
    public RequestlistAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.requestfeedlayout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull RequestlistAdapter.ViewHolder holder, int position)
    {
        final RequestModel requestModel=requestlist.get(position);
        holder.txtfname.setText(requestModel.getR_name());
        holder.txtcity.setText(requestModel.getR_city());
        holder.txtblood.setText(requestModel.getR_blood());
        holder.txtbags.setText(requestModel.getR_bag());
        holder.txtmobile.setText(requestModel.getR_mobile());
        holder.txtdate.setText(requestModel.getR_date());
        holder.txttime.setText(requestModel.getR_time());
        holder.txthospital.setText(requestModel.getR_hospital());
        holder.txtneed.setText(requestModel.getR_need());
        holder.txtrqage.setText(requestModel.getR_age());



        holder.txtmobile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+requestModel.getR_mobile()));
                context.startActivity(callIntent);

            }
        });



    }

    @Override
    public int getItemCount()
    {
        return requestlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtfname,txtcity,txtblood,txtbags,txtmobile,txtdate,txttime,txthospital,txtneed,txtrqage;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            txtfname=itemView.findViewById(R.id.txtfname);
            txtcity=itemView.findViewById(R.id.txtcity);
            txtblood=itemView.findViewById(R.id.txtblood);
            txtbags=itemView.findViewById(R.id.txtbags);
            txtmobile=itemView.findViewById(R.id.txtmobile);
            txtdate=itemView.findViewById(R.id.txtdate);
            txttime=itemView.findViewById(R.id.txttime);
            txthospital=itemView.findViewById(R.id.txthospital);
            txtneed=itemView.findViewById(R.id.txtneed);
            txtrqage=itemView.findViewById(R.id.txtrqage);
        }
    }
}

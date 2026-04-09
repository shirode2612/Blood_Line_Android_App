package com.example.bloodline.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdminBankAdapter extends RecyclerView.Adapter<AdminBankAdapter.MyViewHolder>
{
    List<BloodBankModel> banklist;
    Context context;

    public AdminBankAdapter(List<BloodBankModel> banklist, Context context)
    {
        this.banklist = banklist;
        this.context = context;
    }

    @NonNull
    @Override
    public AdminBankAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new AdminBankAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.admin_blood_bank_layout,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull AdminBankAdapter.MyViewHolder holder, int position)
    {
        final BloodBankModel bloodBankModel= banklist.get(position);

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


        holder.profile_image.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                View view=LayoutInflater.from(context).inflate(R.layout.packeges_layout,null);
                final EditText edtPackage=view.findViewById(R.id.edtpackage);
                Button button=view.findViewById(R.id.btn_up);
                Button button1=view.findViewById(R.id.btn_remove);

                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setView(view);
                final AlertDialog alertDialog=builder.create();
                alertDialog.show();

                button.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int newBags= bloodBankModel.getPackages()+Integer.parseInt(edtPackage.getText().toString());
                        bloodBankModel.setPackages(newBags);

                        DataBaseClient.getInstance(context)
                                .getDatabase().bankDao().updateBank(bloodBankModel);
                        notifyDataSetChanged();
                        alertDialog.dismiss();
                    }
                });

                button1.setOnClickListener(new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        int newBags= bloodBankModel.getPackages()-Integer.parseInt(edtPackage.getText().toString());
                        bloodBankModel.setPackages(newBags);

                        DataBaseClient.getInstance(context)
                                .getDatabase().bankDao().updateBank(bloodBankModel);
                        notifyDataSetChanged();
                        alertDialog.dismiss();
                    }
                });
            }
        });


    }

    @Override
    public int getItemCount()
    {
        return banklist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView txtbloodg,txtpackage,txtno;
        CircleImageView profile_image;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);

            txtbloodg=itemView.findViewById(R.id.txtbloodg);
            txtpackage=itemView.findViewById(R.id.txtpackage);
            txtno=itemView.findViewById(R.id.txtno);
            profile_image=itemView.findViewById(R.id.profile_image);
        }
    }
}

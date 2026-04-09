package com.example.bloodline.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;
import com.example.bloodline.Utilities.SharedPreferencesManager;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class RequestFormFragment extends Fragment implements View.OnClickListener
{
    EditText edthospital,edtmobile,edtfname,edtcity,edtreq_age;
    TextView txtblood,txtbags,txtneed,txtdate,txttime;
    String[]  BloodList, BagsList,ReasonList;
    Context ctx;
    Button btnrequest;
    RequestModel requestModel;


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
        return inflater.inflate(R.layout.requestformlayout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        edtcity=view.findViewById(R.id.edtcity);
        edtreq_age=view.findViewById(R.id.edtreq_age);
        txtblood=view.findViewById(R.id.txtblood);
        txtblood.setOnClickListener(this);
        txtbags=view.findViewById(R.id.txtbags);
        txtbags.setOnClickListener(this);
        txtneed=view.findViewById(R.id.txtneed);
        txtneed.setOnClickListener(this);


        btnrequest=view.findViewById(R.id.btnrequest);



        BloodList=getResources().getStringArray(R.array.Blood_Items);
        BagsList=getResources().getStringArray(R.array.Bags_Item);
        ReasonList=getResources().getStringArray(R.array.Reason_Item);

        edtfname=view.findViewById(R.id.edtfname);
        edtmobile=view.findViewById(R.id.edtmobile);
        edthospital=view.findViewById(R.id.edthospital);


        txtdate=view.findViewById(R.id.txtdate);
        txttime=view.findViewById(R.id.txttime);


        if (SharedPreferencesManager.getisDonor(ctx)==false)
        {
            edtmobile.setText(SharedPreferencesManager.getUserMobile(ctx));
        }

        txtdate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {

                DatePickerDialog datePickerDialog = new DatePickerDialog(ctx, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        String date = String.valueOf(dayOfMonth) + "/" + String.valueOf(month + 1) + "/" + String.valueOf(year);
                        txtdate.setText(date);
                    }
                }, Calendar.getInstance().get(Calendar.YEAR),
                        Calendar.getInstance().get(Calendar.MONTH),
                        Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        txttime.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                TimePickerDialog timePickerDialog = new TimePickerDialog(ctx,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute)
                    {
                        String time=String.valueOf(hourOfDay)+"/"+String.valueOf(minute);
                        txttime.setText(time);

                    }
                },Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                        Calendar.getInstance().get(Calendar.MINUTE),false);
                timePickerDialog.show();
            }
        });

        btnrequest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (v.getId()==btnrequest.getId())
                {
                    RequestModel requestModel =new RequestModel();
                    requestModel.setR_name(edtfname.getText().toString());
                    requestModel.setR_age(edtreq_age.getText().toString());
                    requestModel.setR_city(edtcity.getText().toString());
                    requestModel.setR_blood(txtblood.getText().toString());
                    requestModel.setR_bag(txtbags.getText().toString());
                    requestModel.setR_mobile(edtmobile.getText().toString());
                    requestModel.setR_date(txtdate.getText().toString());
                    requestModel.setR_time(txttime.getText().toString());
                    requestModel.setR_hospital(edthospital.getText().toString());
                    requestModel.setR_need(txtneed.getText().toString());

                    saveRequest(requestModel);

                    Toast.makeText(ctx, "Request Successful", Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            }
        });

    }

    private  void clearControls(){

        edtfname.setText("");
        edtreq_age.setText("");
        edtmobile.setText("");
        edtcity.setText("");
        edthospital.setText("");
        txtdate.setText("");
        txttime.setText("");
        txtneed.setText("");
        txtblood.setText("Select Blood Group");
        txtbags.setText("Select Bags");
    }

    private void saveRequest(RequestModel requestModel)
    {
        DataBaseClient.getInstance(getContext())
                .getDatabase().requestDao().insertRequest(requestModel);


    }
    private void getAllRequest()
    {
        List<RequestModel> requestModels = DataBaseClient.getInstance(getContext()).getDatabase()
                .requestDao().getAllRequest();

        Toast.makeText(ctx, String.valueOf(requestModels.size()), Toast.LENGTH_SHORT).show();

    }




    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    @Override
    public void onClick(View v)
    {

        if (txtblood.getId()== v.getId()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Select Blood Group");
            builder.setSingleChoiceItems(BloodList, -1, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int i) {
                    txtblood.setText(BloodList[i]);
                    dialog.dismiss();
                }
            });
            AlertDialog alertDialog = builder.create();
            builder.show();
        }
        if (txtbags.getId()== v.getId())
        {
                    AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                    builder.setTitle("Select Bags");
                    builder.setSingleChoiceItems(BagsList, -1, new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int i)
                        {
                            txtbags.setText(BagsList[i]);
                            dialog.dismiss();
                        }
                    });
                    builder.create().show();
        }
        if (txtneed.getId()== v.getId())
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Select Reason");
            builder.setSingleChoiceItems(ReasonList, -1, new DialogInterface.OnClickListener()
            {
                @Override
                public void onClick(DialogInterface dialog, int i)
                {
                    txtneed.setText(ReasonList[i]);
                    dialog.dismiss();
                }
            });
            builder.create().show();
        }

    }
}

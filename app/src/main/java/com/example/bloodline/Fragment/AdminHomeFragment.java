package com.example.bloodline.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bloodline.DataModels.BloodBankModel;
import com.example.bloodline.DataModels.UserModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;

import java.util.List;


public class AdminHomeFragment extends Fragment implements View.OnClickListener {
    TextView txtblood;
    EditText edtbags;
    Button btnadd;
    String[] BloodList;
    Context ctx;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        ctx = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.admin_package_leyout, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        txtblood = view.findViewById(R.id.txtblood);
        txtblood.setOnClickListener(this);
        edtbags = view.findViewById(R.id.edtbags);
        btnadd = view.findViewById(R.id.btnadd);
        BloodList = getResources().getStringArray(R.array.Blood_Items);

        btnadd.setOnClickListener(new View.OnClickListener()
        {
            private UserModel userModel;

            @Override
            public void onClick(View v)
            {
                if (v.getId()==btnadd.getId())
                {
                    BloodBankModel bloodBankModel = new BloodBankModel();
                    bloodBankModel.setBloodGroup(txtblood.getText().toString());
                    bloodBankModel.setPackages(Integer.parseInt(edtbags.getText().toString()));

                    BloodBankModel bbm=DataBaseClient.getInstance(getContext())
                            .getDatabase().bankDao().getStatusByBloodGroup(bloodBankModel.getBloodGroup());

                    if (bbm == null)
                    {
                        DataBaseClient.getInstance(getContext())
                                .getDatabase().bankDao().insertBank(bloodBankModel);

                        Toast.makeText(ctx, "Successfully Added", Toast.LENGTH_SHORT).show();
                        clearControls();

                    }
                    else {

                        Toast.makeText(ctx, "You have Already Added", Toast.LENGTH_SHORT).show();
                    }
                     clearControls();

                }

            }
        });
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }

    private void getAllBank()
    {
        List<BloodBankModel> bloodBankModels = DataBaseClient.getInstance(getContext()).getDatabase()
                .bankDao().getAllBank();

        Toast.makeText(ctx, String.valueOf(bloodBankModels.size()), Toast.LENGTH_SHORT).show();

    }

    private  void clearControls()
    {

        txtblood.setText("");
        edtbags.setText("");

    }




    @Override
    public void onClick(View v)
    {
        if (txtblood.getId() == v.getId()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
            builder.setTitle("Select Blood Group");
            builder.setSingleChoiceItems(BloodList, -1,
                    new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int i)
                        {
                            txtblood.setText(BloodList[i]);
                            dialog.dismiss();
                        }
                    });
            builder.create().show();
        }
    }
}

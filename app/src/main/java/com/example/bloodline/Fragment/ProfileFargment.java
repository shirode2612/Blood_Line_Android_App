package com.example.bloodline.Fragment;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.DonorModel;
import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;
import com.example.bloodline.Utilities.SharedPreferencesManager;
import com.example.bloodline.Utilities.UserMethods;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ProfileFargment extends Fragment implements View.OnClickListener {
    private BitmapFactory.Options options;
    private static final int PROF_REQUEST = 55;
    TextView txtprofile, txtblood;
    CircleImageView profile_image;
    EditText edtname, edtmobno, edtcity, edtaddress, edtemailid,edtage;
    CheckBox cbcheck;
    Button btnedit;
    String[] BloodList;
    Context ctx;
    Bitmap dpro;

    List<Integer> bgList = new ArrayList();
    private RecyclerView rvBloodGroup;



    @Override
    public void onAttach(@NonNull Context context)
    {
        super.onAttach(context);
        ctx = context;

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profilelayout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txtprofile = view.findViewById(R.id.txtprofile);
        edtname = view.findViewById(R.id.edtname);
        edtemailid = view.findViewById(R.id.edtemailid);
        edtage=view.findViewById(R.id.edtage);
        edtcity = view.findViewById(R.id.edtcity);
        edtaddress = view.findViewById(R.id.edtaddress);
        txtblood = view.findViewById(R.id.txtblood);
        profile_image=view.findViewById(R.id.profile_image);
        BloodList = getResources().getStringArray(R.array.Blood_Items);
        edtmobno = view.findViewById(R.id.edtmobno);
        cbcheck = view.findViewById(R.id.cbcheck);

        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE},10);

        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent pickPhoto = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(pickPhoto,PROF_REQUEST);
            }
        });

        if (SharedPreferencesManager.getisDonor(ctx)==true)
        {
            edtemailid.setText(SharedPreferencesManager.getEmail(ctx));
            edtmobno.setText(SharedPreferencesManager.getUserMobile(ctx));

        }

        edtmobno.setText(SharedPreferencesManager.getUserMobile(ctx));
        edtemailid.setText(SharedPreferencesManager.getEmail(ctx));

        btnedit = view.findViewById(R.id.btnedit);
        btnedit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (v.getId()==btnedit.getId())
                {
                    DonorModel donorModel = new DonorModel();
                    donorModel.setD_name(edtname.getText().toString());
                    donorModel.setD_mobno(edtmobno.getText().toString());
                    donorModel.setD_age(edtage.getText().toString());
                    donorModel.setD_email(edtemailid.getText().toString());
                    donorModel.setD_address(edtaddress.getText().toString());
                    donorModel.setD_city(edtcity.getText().toString());
                    donorModel.setD_bloodgoup(txtblood.getText().toString());
                    donorModel.setD_image(UserMethods.imgConvertFromBitmapToByteArray(dpro));

                    savedonor(donorModel);

                    Toast.makeText(ctx, "SAVE SUCCESSFUL", Toast.LENGTH_SHORT).show();
                    clearControls();

                }
            }
        });
        txtblood.setOnClickListener(this);
    }

    private  void clearControls()
    {

        edtname.setText("");
        edtmobno.setText("");
        edtage.setText("");
        edtcity.setText("");
        edtaddress.setText("");
        edtemailid.setText("");
        txtblood.setText("Select Blood Group");

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
        if (requestCode==PROF_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Uri selectedImage = data.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};

            if (selectedImage != null)
            {
                Cursor cursor = ctx.getContentResolver().query(selectedImage,filePathColumn,null,null,null);

                if (cursor != null)
                {
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                    String picturePath = cursor.getString(columnIndex);
                    options = new BitmapFactory.Options();
                    options.inSampleSize=2;
                    dpro = BitmapFactory.decodeFile(picturePath,options);
                    profile_image.setImageBitmap(dpro);
                    cursor.close();
                }
            }
        }
    }

    @Override
    public void onDetach()
    {
        super.onDetach();
    }


    private void savedonor(DonorModel donorModel)
    {
        DataBaseClient.getInstance(getContext())
                .getDatabase().donorDao().insertDonort(donorModel);


    }
    private void getAllDonor()
    {
        List<DonorModel> donorModels = DataBaseClient
                .getInstance(getContext()).getDatabase()
                .donorDao().getAllDonor();

        Toast.makeText(ctx, String.valueOf(donorModels.size()), Toast.LENGTH_SHORT).show();

    }
    @Override
    public void onClick(View v)
    {
        if (txtblood.getId() == v.getId())
        {
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
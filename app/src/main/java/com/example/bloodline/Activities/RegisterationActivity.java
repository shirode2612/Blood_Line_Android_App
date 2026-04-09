package com.example.bloodline.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bloodline.DataModels.RequestModel;
import com.example.bloodline.DataModels.UserModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;
import com.example.bloodline.Utilities.SharedPreferencesManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class RegisterationActivity extends AppCompatActivity {
    TextInputEditText edtemail, edtpassword, edtcontact;
    CheckBox cbcheck;
    TextView txtlogIn;
    CircleImageView profile_image;
    Button btnregister;
    static final float BLUR_RADIUS = 25F;
      CoordinatorLayout regback;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.registerationlayout);

        regback=findViewById(R.id.regback);

        edtpassword = findViewById(R.id.edtpassword);
        edtemail = findViewById(R.id.edtemail);
        edtcontact = findViewById(R.id.edtcontact);
        btnregister = findViewById(R.id.btnregister);
        txtlogIn = findViewById(R.id.txtlogin);

        Bitmap backIma = BitmapFactory.decodeResource(getResources(), R.drawable.image31);

        Bitmap blurBitmap = blur(backIma);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(blurBitmap);

        regback.setBackground(bitmapDrawable);



        cbcheck = findViewById(R.id.cbcheck);


        btnregister.setOnClickListener(new View.OnClickListener() 
        {
            @Override
            public void onClick(View v) 
            {
                if (v.getId() == btnregister.getId())
                {
                    if(!TextUtils.isEmpty(edtemail.getText().toString())
                    && !TextUtils.isEmpty(edtcontact.getText().toString()) 
                                && !TextUtils.isEmpty(edtpassword.getText().toString()))
                    {
                        UserModel userModel = new UserModel();
                        userModel.setU_email(edtemail.getText().toString());
                        userModel.setU_contact(edtcontact.getText().toString());
                        userModel.setU_password(edtpassword.getText().toString());
                        if (cbcheck.isChecked()==true)
                        {
                            userModel.setDonor(true);
                        }else {
                            userModel.setDonor(false);
                        }
                        saveUser(userModel);

                        Intent intent = new Intent(RegisterationActivity.this, LoginActivity.class);
                        startActivity(intent);    

                        SharedPreferencesManager.setUserMobile(RegisterationActivity.this,edtcontact.getText().toString());
                        SharedPreferencesManager.setEmail(RegisterationActivity.this,edtemail.getText().toString());


                    }
                    else {
                        Toast.makeText(RegisterationActivity.this, "Enter All Fields", Toast.LENGTH_SHORT).show();
                    }
                    
                }
            }
        });
        txtlogIn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) 
            {
                Intent intent = new Intent(RegisterationActivity.this, LoginActivity.class);
                startActivity(intent);

            }
        });
        

    }

    private void saveUser(UserModel userModel)
    {
        long id=DataBaseClient.getInstance(getApplicationContext())
                .getDatabase().userDao().insertUser(userModel);

        SharedPreferencesManager.setUserId(RegisterationActivity.this,id);
        SharedPreferencesManager.setEmail(RegisterationActivity.this,edtemail.getText().toString());
        SharedPreferencesManager.setUserMobile(RegisterationActivity.this,edtcontact.getText().toString());

        Toast.makeText(RegisterationActivity.this, "Registeration Successfully", Toast.LENGTH_SHORT).show();

    }
    private void getAllUser()
    {
        List<UserModel> userModels = DataBaseClient.getInstance(getApplicationContext()).getDatabase()
                .userDao().getAllUser();

        Toast.makeText(this, String.valueOf(userModels.size()), Toast.LENGTH_SHORT).show();

    }


    public Bitmap blur(Bitmap image) {
        if (null == image) return null;

        Bitmap outputBitmap = Bitmap.createBitmap(image);

        final RenderScript renderScript = RenderScript.create(this);

        Allocation tmpIn = Allocation.createFromBitmap(renderScript, image);

        Allocation tmpOut = Allocation.createFromBitmap(renderScript, outputBitmap);


        ScriptIntrinsicBlur theIntrinsic = ScriptIntrinsicBlur.create(renderScript, Element.U8_4(renderScript));

        theIntrinsic.setRadius(BLUR_RADIUS);

        theIntrinsic.setInput(tmpIn);

        theIntrinsic.forEach(tmpOut);

        tmpOut.copyTo(outputBitmap);

        return outputBitmap;
    }

}


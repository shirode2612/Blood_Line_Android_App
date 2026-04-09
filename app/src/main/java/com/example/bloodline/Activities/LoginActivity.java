package com.example.bloodline.Activities;

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
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import com.example.bloodline.DataModels.UserModel;
import com.example.bloodline.R;
import com.example.bloodline.Utilities.DataBaseClient;
import com.example.bloodline.Utilities.SharedPreferencesManager;
import com.example.bloodline.Utilities.UserMethods;
import com.google.android.material.textfield.TextInputEditText;

import java.util.concurrent.ThreadPoolExecutor;

public class LoginActivity extends AppCompatActivity
{
    TextInputEditText edtmbl,edtupassword;
    Button btnlogin,btnregister;
    static final float BLUR_RADIUS = 25F;
    CoordinatorLayout logback;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlayout);

        edtmbl=findViewById(R.id.edtmbl);
        edtupassword=findViewById(R.id.edtupassword);
        btnlogin=findViewById(R.id.btnlogin);
        logback=findViewById(R.id.logback);

        Bitmap backIma = BitmapFactory.decodeResource(getResources(), R.drawable.image31);

        Bitmap blurBitmap = blur(backIma);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(blurBitmap);

        logback.setBackground(bitmapDrawable);



        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if (v.getId()==btnlogin.getId())
                {
                    if (!TextUtils.isEmpty(edtmbl.getText().toString()) && !TextUtils.isEmpty(edtupassword.getText().toString()))
                    {
                        if (edtmbl.getText().toString().equals("admin") && edtupassword.getText().toString().equals("admin"))
                        {
                            Intent intent = new Intent(LoginActivity.this,AdminDrawerActivity.class);
                            startActivity(intent);
                        }else {
                                String mbl = edtmbl.getText().toString();
                                String pass = edtupassword.getText().toString();

                                UserModel userModel= DataBaseClient.getInstance(getApplicationContext())
                                        .getDatabase()
                                        .userDao()
                                        .getUserWithMblNoAndpass(mbl,pass);

                                if (userModel.getU_contact().equals(mbl) && userModel.getU_password().equals(pass))
                                {
                                    SharedPreferencesManager.setUserMobile(LoginActivity.this,userModel.getU_contact());
                                    SharedPreferencesManager.setEmail(LoginActivity.this,userModel.getU_email());
                                    SharedPreferencesManager.setisDonor(LoginActivity.this,userModel.getDonor());

                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(LoginActivity.this,UserHomeActivity.class);
                                    startActivity(intent);
                                }else {
                                    Toast.makeText(LoginActivity.this, "Login Fail...Enter Correct Data", Toast.LENGTH_SHORT).show();
                                }
                        }

                    }else {
                        Toast.makeText(LoginActivity.this, "Enter data", Toast.LENGTH_SHORT).show();
                    }
                }


            }
        });

    }

    public Bitmap blur(Bitmap image)
    {
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

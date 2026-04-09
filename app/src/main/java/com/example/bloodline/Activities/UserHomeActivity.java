package com.example.bloodline.Activities;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.bloodline.Fragment.BloodBankStatusFragment;
import com.example.bloodline.Fragment.DonorlistFragment;
import com.example.bloodline.Fragment.ProfileFargment;
import com.example.bloodline.Fragment.RequestFormFragment;
import com.example.bloodline.Fragment.RequestfeedFragment;
import com.example.bloodline.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserHomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    FrameLayout fragmentcontainer;
    BottomNavigationView navView;
    Context ctx;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userhomelayout);

        ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},10);

        fragmentcontainer=findViewById(R.id.fragmentcontainer);
        navView=findViewById(R.id.navView);

        navView.setOnNavigationItemSelectedListener(this);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fragmentcontainer,new RequestFormFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
    {

        if (menuItem.getItemId()==R.id.mnRequestform)


        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentcontainer,new RequestFormFragment());
            fragmentTransaction.commit();
        }
        if (menuItem.getItemId()==R.id.mndonor)


        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentcontainer,new DonorlistFragment());
            fragmentTransaction.commit();
        }
        if (menuItem.getItemId()==R.id.mnrequest)


        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentcontainer,new RequestfeedFragment());
            fragmentTransaction.commit();
        }

        if (menuItem.getItemId()==R.id.mnprofile)


        {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentcontainer,new ProfileFargment());
            fragmentTransaction.commit();
        }
        if (menuItem.getItemId()==R.id.mnbank)


        {
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.replace(R.id.fragmentcontainer,new BloodBankStatusFragment());
            fragmentTransaction.commit();
        }


        return true;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.deatailsmenu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        if (item.getItemId()==R.id.mninfo)
        {
            Intent intent=new Intent(UserHomeActivity.this,InfoActivity.class);
            startActivity(intent);

        }

        return true;
    }
}

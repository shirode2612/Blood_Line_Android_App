package com.example.bloodline.Activities;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.bloodline.Fragment.AdminBankStatusFragment;
import com.example.bloodline.Fragment.AdminDonorFragment;
import com.example.bloodline.Fragment.AdminHomeFragment;
import com.example.bloodline.Fragment.AdminProfileFragment;
import com.example.bloodline.Fragment.AdminRequestFragment;
import com.example.bloodline.R;
import com.google.android.material.navigation.NavigationView;

public class AdminDrawerActivity extends AppCompatActivity
{

    private NavigationView navigationView;
    private DrawerLayout drawer;
    Toolbar toolbar;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView =(NavigationView) findViewById(R.id.nav_view);
        fragmentManager=getSupportFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.nav_frame_container,new AdminProfileFragment())
        .commit();


        setUpNavigationView();
    }
    private void setUpNavigationView()
    {
      navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
      {
          @Override
          public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
          {
              Fragment selectedFrag = null;
              switch (menuItem.getItemId())
              {
                  case R.id.nav_home:
                      getSupportActionBar().setTitle("HOME");
                        selectedFrag=new AdminHomeFragment();
                      break;

                  case R.id.nav_profile:
                      getSupportActionBar().setTitle("PROFILE");
                      selectedFrag=new AdminProfileFragment();
                      break;

                  case R.id.nav_donorlist:
                      getSupportActionBar().setTitle("DONOR LIST");
                      selectedFrag=new AdminDonorFragment();
                      break;

                  case R.id.nav_requestlist:
                      getSupportActionBar().setTitle("REQUEST");
                      selectedFrag=new AdminRequestFragment();
                      break;

                  case R.id.nav_bankstatus:
                      getSupportActionBar().setTitle("STATUS");
                      selectedFrag=new AdminBankStatusFragment();
                      break;
              }
              getSupportFragmentManager()
                      .beginTransaction()
                      .replace(R.id.nav_frame_container,selectedFrag)
                    .commit();

              drawer.closeDrawers();
              return true;
          }
      });

        ActionBarDrawerToggle actionBarDrawerToggle=
                new ActionBarDrawerToggle(this,drawer,toolbar,R.string.closeDrawer,R.string.openDrawer)
                {
                    @Override
                    public void onDrawerOpened(View drawerView) {
                        super.onDrawerOpened(drawerView);
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        super.onDrawerClosed(drawerView);
                    }
                };

        drawer.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed()
    {
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawers();
            return;
        }
        super.onBackPressed();
    }
}

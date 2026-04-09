package com.example.bloodline.Utilities;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

public class MyApplication extends Application
{
   private static MyApplication MyApplicationInstance;
    private SharedPreferences SharedPreferences;

    public static synchronized MyApplication getInstance()
    {
        if (MyApplicationInstance==null)
        {
            MyApplicationInstance=new MyApplication();
        }
        return MyApplicationInstance;

    }
    public SharedPreferences getSharedPreferences(Context context)
    {
        SharedPreferences=context.getSharedPreferences(SharedPreferenceskeyConstants.PREF_NAME,0);

        return SharedPreferences;
    }


    @Override
    public void onCreate()
    {
        super.onCreate();
    }
}

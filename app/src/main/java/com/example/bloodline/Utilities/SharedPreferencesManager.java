package com.example.bloodline.Utilities;

import android.content.Context;

import com.example.bloodline.Activities.LoginActivity;

public final class SharedPreferencesManager
{
    public static boolean setUserId(Context context,long userid)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putLong(SharedPreferenceskeyConstants.USER_ID,userid).commit();
    }
    public static long getUserID(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getInt(SharedPreferenceskeyConstants.USER_ID,0);
    }
    public static boolean setUserName(Context context,String userName)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putString(SharedPreferenceskeyConstants.USER_NAME,userName).commit();

    }
    public static String getUserName(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceskeyConstants.USER_NAME,"");

    }
    public static boolean setUserType(Context context,String userType)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putString(SharedPreferenceskeyConstants.USER_TYPE,userType)
                .commit();

    }
    public static String getUserType(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceskeyConstants.USER_TYPE,"");

    }
    public static boolean setEmail(Context context,String useremail)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putString(SharedPreferenceskeyConstants.USER_EMAIL,useremail)
                .commit();

    }
    public static String getEmail(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceskeyConstants.USER_EMAIL,"");

    }
    public static boolean setUserMobile(Context context,String mobno)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putString(SharedPreferenceskeyConstants.USER_MOBNO,mobno)
                .commit();

    }

    public static String getUserMobile(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getString(SharedPreferenceskeyConstants.USER_MOBNO, "");

    }

    public static boolean setisDonor(Context context, boolean isDonor)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .edit().putBoolean(SharedPreferenceskeyConstants.IS_DONOR,isDonor)
                .commit();
    }

    public static boolean getisDonor(Context context)
    {
        return MyApplication.getInstance().getSharedPreferences(context)
                .getBoolean(SharedPreferenceskeyConstants.IS_DONOR, false);
    }
}

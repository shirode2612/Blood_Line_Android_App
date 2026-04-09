package com.example.bloodline.Utilities;

import android.content.Context;

import androidx.room.Room;

public class DataBaseClient
{

    private Context context;
    private static DataBaseClient mInstance;

    private AppDatabase database;

    public   DataBaseClient(Context context)
    {
        this.context = context;
        database = Room.databaseBuilder(context, AppDatabase.class,"MYDB")
                .allowMainThreadQueries().build();
    }
    public static synchronized DataBaseClient getInstance(Context context)
    {
        if (mInstance==null)
        {
            mInstance=new DataBaseClient(context);
        }
        return mInstance;
    }
    public AppDatabase getDatabase()
    {
        return database;
    }

}

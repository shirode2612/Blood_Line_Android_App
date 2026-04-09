package com.example.bloodline.Utilities;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.util.regex.Pattern;

public class UserMethods
{
    public static byte[] imgConvertFromBitmapToByteArray(Bitmap bitmap)
    {
        ByteArrayOutputStream blob = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,0,blob);
        return blob.toByteArray();
    }
    public static Bitmap imgConvertFromByteArrayToBitmap(byte[] image)
    {
        return BitmapFactory.decodeByteArray(image,0,image.length);
    }


    public static boolean isValidMobile(String mbl)
    {
        return Pattern.compile("[6-9][0-9]{10}").matcher(mbl).matches();
    }
}

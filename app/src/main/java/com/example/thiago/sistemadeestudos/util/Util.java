package com.example.thiago.sistemadeestudos.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by Thiago on 10/12/2016.
 */

public class Util {

    public static void showMessage(Context context, String msg, String button){
        AlertDialog.Builder alert = new  AlertDialog.Builder(context);
        alert.setMessage(msg);
        alert.setNeutralButton(button, null);
        alert.show();
    }

    public static void toastMessage(Context context, String msg){
        Toast.makeText(context, msg , Toast.LENGTH_SHORT).show();
    }
}

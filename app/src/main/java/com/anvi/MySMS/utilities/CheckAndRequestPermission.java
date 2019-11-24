package com.anvi.nearme.utilities;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rashid on 12/26/2016.
 */

public class CheckAndRequestPermission {
    public static final int REQUEST_ID_MULTIPLE_PERMISSIONS = 1;
    //////////////////////  PERMISSION WINDOW ---BEGIN     ///////////////////////////////////
    public   boolean checkAndRequestPermissions(Activity activity) {

        int sms_permission = ContextCompat.checkSelfPermission(activity, Manifest.permission.RECEIVE_SMS);


        List<String> listPermissionsNeeded = new ArrayList<>();

        if (sms_permission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.RECEIVE_SMS);
        }


        if (!listPermissionsNeeded.isEmpty())
        {
            ActivityCompat.requestPermissions(activity,listPermissionsNeeded.toArray
                    (new String[listPermissionsNeeded.size()]),REQUEST_ID_MULTIPLE_PERMISSIONS);
            return false;
        }
        return true;
    }
    //////////////////////  PERMISSION WINDOW ---END     ///////////////////////////////////
}

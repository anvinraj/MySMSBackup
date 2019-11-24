package com.anvi.nearme.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by user 1 on 10-06-2016.
 */
public class NetworkCheckingClass {
    Context context;
    public NetworkCheckingClass(Context con) {
        this.context=con;

    }

    public boolean ckeckinternet() {

        ConnectivityManager conMgr = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = conMgr.getActiveNetworkInfo();
        if (i == null)
            return false;
        if (!i.isConnected())
            return false;
        if (!i.isAvailable())
            return false;
        return true;

    }
}

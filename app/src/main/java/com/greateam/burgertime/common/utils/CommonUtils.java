package com.greateam.burgertime.common.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.InputStream;

public class CommonUtils {

    public static final String WIFE_STATE = "WIFE";
    public static final String MOBILE_STATE = "MOBILE";
    public static final String NONE_STATE = "NONE";

    // 인터넷
    public static String getWhatKindOfNetwork(Context context){
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null) {
            if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                return WIFE_STATE;
            } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                return MOBILE_STATE;
            }
        }
        return NONE_STATE;
    }

    // 애셋
    public static String getAssetFile(String path) {

        String text = "";

//        AssetManager am = getResources().getAssets();
//        InputStream is = null;
//        byte buf[] = new byte[1024];
//        try {
//            is = am.open(path);
//            if (is.read(buf) > 0) {
//                text = new String(buf);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (is != null) {
//            try {
//                is.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }

        return text;
    }

}

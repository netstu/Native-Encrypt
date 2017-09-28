package com.mainli;


import android.content.Context;
import android.util.Base64;
import android.util.Log;

/**
 * Created by dfqin on 2017/4/7.
 */

public class SecureUtil {

    public static String encode(String data) {
        return new String(Base64.encode(encryptData(BaseApplication.getInstance(), data.getBytes()), Base64.DEFAULT));
    }

    public static String decode(String data) {
        return new String(decryptData(BaseApplication.getInstance(), Base64.decode(data, Base64.DEFAULT)));
    }

    public static String getSign(String data) {
        return getSign(BaseApplication.getInstance(), data);
    }

    public static String getDeviceId() {
        return "deviceId";
    }

    public static String getAppVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static String getChannel() {
        return "mainli";
    }

    public static void showToast(String tips) {
        Log.i("Mainli", "tips: " + tips);
    }

    native private static byte[] encryptData(Context context, byte[] data);

    native private static byte[] decryptData(Context context, byte[] data);

    native private static String getSign(Context context, String data);

    static {
        System.loadLibrary("secure-lib");
    }
}

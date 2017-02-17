package com.example.linsawako.crazytranslation.base.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by linsawako on 2017/2/16.
 */

public class BaseApplication extends Application {

    private static String cacheDir;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        /**
         * 如果存在SD卡则将缓存写入SD卡,否则写入手机内存
         */
        if (getApplicationContext().getExternalCacheDir() != null && ExistSDCard()) {
            cacheDir = getApplicationContext().getExternalCacheDir().toString();
        } else {
            cacheDir = getApplicationContext().getCacheDir().toString();
        }
    }

    private boolean ExistSDCard() {
        return android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);
    }


    public static Context getAppContext() {
        return context;
    }

    public static String getAppCacheDir() {
        return cacheDir;
    }

}

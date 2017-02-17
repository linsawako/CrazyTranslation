package com.example.linsawako.crazytranslation.base.rxbase;

import android.util.Log;
import android.widget.BaseAdapter;
import android.widget.Toast;

import com.example.linsawako.crazytranslation.base.common.BaseApplication;

import rx.Subscriber;

import static android.content.ContentValues.TAG;

/**
 * Created by linsawako on 2017/2/16.
 */

public abstract class RxSubscriber<T> extends Subscriber<T> {

    private static final String TAG = "RxSubscriber";
    
    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {
        Log.d(TAG, "onError: ");
        Toast.makeText(BaseApplication.getAppContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onError: " + e.getMessage());
    }
}

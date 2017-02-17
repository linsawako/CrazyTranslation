package com.example.linsawako.crazytranslation.base.mvpbase;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.test.LoaderTestCase;
import android.util.Log;
import android.view.Window;

import butterknife.ButterKnife;

import static android.content.ContentValues.TAG;

/**
 * Created by linsawako on 2017/2/13.
 */

public abstract class BaseActivity<V, T extends BasePresenter<V>> extends Activity {

    protected T mPresenter;
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);

        mPresenter = createPresenter();
        mPresenter.attachView((V)this);

        Log.d(TAG, "onCreate: ");

        initView();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detechView();
        }
    }

    protected abstract T createPresenter();

    protected abstract void initView();

    protected abstract int getLayoutId();
}

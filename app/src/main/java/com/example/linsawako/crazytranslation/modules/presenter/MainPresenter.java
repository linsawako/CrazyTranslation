package com.example.linsawako.crazytranslation.modules.presenter;

import android.util.Log;

import com.example.linsawako.crazytranslation.base.mvpbase.BasePresenter;
import com.example.linsawako.crazytranslation.base.rxbase.RxSubscriber;
import com.example.linsawako.crazytranslation.bean.Word;
import com.example.linsawako.crazytranslation.modules.activity.MainActivity;
import com.example.linsawako.crazytranslation.modules.contract.TranslateContract;
import com.example.linsawako.crazytranslation.modules.model.MainModel;

/**
 * Created by linsawako on 2017/2/16.
 */

public class MainPresenter extends BasePresenter<MainActivity> implements TranslateContract.Presenter {

    MainModel model = new MainModel();
    private static final String TAG = "MainPresenter";

    @Override
    public void getExplain(String word) {
        model.getExplain(word).subscribe(new RxSubscriber<Word>() {
            @Override
            public void onNext(Word word) {
                Log.d(TAG, "onNext: ");
                mViewRefer.get().showExplain(word);
            }
        });
    }
}

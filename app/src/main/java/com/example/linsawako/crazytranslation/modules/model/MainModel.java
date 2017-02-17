package com.example.linsawako.crazytranslation.modules.model;

import android.util.Log;

import com.example.linsawako.crazytranslation.api.RetrofitSingleton;
import com.example.linsawako.crazytranslation.base.common.Config;
import com.example.linsawako.crazytranslation.base.rxbase.RxScheduler;
import com.example.linsawako.crazytranslation.bean.Word;
import com.example.linsawako.crazytranslation.modules.contract.TranslateContract;

import java.sql.ParameterMetaData;
import java.util.Map;

import rx.Observable;

/**
 * Created by linsawako on 2017/2/16.
 */

public class MainModel implements TranslateContract.Model {

    private static final String TAG = "MainModel";
    
    @Override
    public Observable<Word> getExplain(String word) {
        Log.d(TAG, "getExplain: ");
        Map<String, String> params = Config.getParams();
        params.put("q", word);

        return RetrofitSingleton.getDefault()
                .translate(params)
                .compose(RxScheduler.rxSchedulerHelper());
    }
}

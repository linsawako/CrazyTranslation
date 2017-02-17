package com.example.linsawako.crazytranslation.modules.contract;

import android.view.View;

import com.example.linsawako.crazytranslation.base.mvpbase.BaseActivity;
import com.example.linsawako.crazytranslation.base.mvpbase.BasePresenter;
import com.example.linsawako.crazytranslation.bean.Word;

import rx.Observable;

/**
 * Created by linsawako on 2017/2/16.
 */

public interface TranslateContract {

    interface Presenter {
        void getExplain(String word);
    }


    interface View {
        void showExplain(Word word);
    }

    interface Model {
        Observable<Word> getExplain(String word);
    }
}

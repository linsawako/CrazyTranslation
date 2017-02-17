package com.example.linsawako.crazytranslation.base.rxbase;

import android.media.DeniedByServerException;
import android.util.Log;

import com.example.linsawako.crazytranslation.R;
import com.example.linsawako.crazytranslation.bean.Word;

import java.util.Map;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

import static android.content.ContentValues.TAG;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * Created by linsawako on 2017/2/16.
 */

public class RxScheduler {

    private static final String TAG = "RxScheduler";

    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {
        return tObservable -> tObservable.subscribeOn(Schedulers.io())
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static Observable.Transformer<Word, Word> handleResult() {
        return new Observable.Transformer<Word, Word>() {
            @Override
            public Observable<Word> call(Observable<Word> wordObservable) {
                return wordObservable.map(new Func1<Word, Word>() {
                    @Override
                    public Word call(Word word) {
                        Log.d(TAG, "call: ");
                        if (word.getErrorCode() == 0){
                            if (word.getQuery().equals(word.getTranslation().get(0))){
                                throw new RuntimeException("didn't find this word");
                            }
                        }else{
                            throw new RuntimeException("other error");
                        }
                        return word;
                    }
                });
            }
        };
    }

   /* public static <T> Observable<T> createData(T data) {
        return Observable.create(new Observable.OnSubscribe<T>() {
            @Override
            public void call(Subscriber<? super T> subscriber) {
                try {
                    subscriber.onNext(data);
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }*/

    /**
     * 可自定义线程
     */
    public static <T> Observable.Transformer<T, T> rxSchedulerHelper(Scheduler scheduler) {
        return tObservable -> tObservable.subscribeOn(scheduler)
                .unsubscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread());
    }

}

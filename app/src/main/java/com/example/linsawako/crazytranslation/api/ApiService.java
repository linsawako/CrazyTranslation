package com.example.linsawako.crazytranslation.api;

import com.example.linsawako.crazytranslation.bean.Word;

import java.util.Map;

import retrofit2.http.GET;
import retrofit2.http.QueryMap;
import rx.Observable;

/**
 * Created by linsawako on 2017/2/16.
 */

public interface ApiService {

    @GET("/openapi.do")
    Observable<Word> translate(@QueryMap Map<String, String> params);

}

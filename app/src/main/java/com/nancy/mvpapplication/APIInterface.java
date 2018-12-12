package com.nancy.mvpapplication;

import com.nancy.mvpapplication.Pojo.CryptoData;
import com.nancy.mvpapplication.Pojo.StarWars;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface {

    @GET("ticker/?")
    Observable<List<CryptoData>> getData(@Query("limit") String limit);

    @GET("people/?")
    Observable<StarWars> getPeople(@Query("format") String format);
}

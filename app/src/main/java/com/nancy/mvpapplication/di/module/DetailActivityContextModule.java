package com.nancy.mvpapplication.di.module;

import android.content.Context;

import com.nancy.mvpapplication.DetailActivity;
import com.nancy.mvpapplication.MainActivity;
import com.nancy.mvpapplication.di.qualifier.ActivityContext;
import com.nancy.mvpapplication.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;



@Module
public class DetailActivityContextModule {
    private DetailActivity detailActivity;

    public Context context;

    public DetailActivityContextModule(DetailActivity detailActivity) {
        this.detailActivity = detailActivity;
        context = detailActivity;
    }

    @Provides
    @ActivityScope
    public DetailActivity providesDetailActivity() {
        return detailActivity;
    }

    @Provides
    @ActivityScope
    @ActivityContext
    public Context provideContext() {
        return context;
    }

}

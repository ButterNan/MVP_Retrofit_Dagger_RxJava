package com.nancy.mvpapplication.di.module;

import com.nancy.mvpapplication.di.scope.ActivityScope;
import com.nancy.mvpapplication.mvp.DetailActivityContract;
import com.nancy.mvpapplication.mvp.MainActivityContract;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailActivityMvpModule {
    private final DetailActivityContract.View mView;


    public DetailActivityMvpModule(DetailActivityContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @ActivityScope
    DetailActivityContract.View provideView() {
        return mView;
    }
}

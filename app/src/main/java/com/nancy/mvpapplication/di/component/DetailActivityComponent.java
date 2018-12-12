package com.nancy.mvpapplication.di.component;

import android.content.Context;

import com.nancy.mvpapplication.DetailActivity;
import com.nancy.mvpapplication.di.module.AdapterModule;
import com.nancy.mvpapplication.di.module.DetailActivityContextModule;
import com.nancy.mvpapplication.di.module.DetailActivityMvpModule;
import com.nancy.mvpapplication.di.module.MainActivityMvpModule;
import com.nancy.mvpapplication.di.qualifier.ActivityContext;
import com.nancy.mvpapplication.di.scope.ActivityScope;

import dagger.Component;
import dagger.Provides;

@ActivityScope
@Component(modules = {DetailActivityMvpModule.class, DetailActivityContextModule.class}, dependencies = ApplicationComponent.class)
public interface DetailActivityComponent {


    @ActivityContext
    Context getContext();


    void inject(DetailActivity detailActivity);
}
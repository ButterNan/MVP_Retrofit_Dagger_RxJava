package com.nancy.mvpapplication.di.component;


import android.content.Context;


import com.nancy.mvpapplication.MainActivity;
import com.nancy.mvpapplication.di.module.AdapterModule;
import com.nancy.mvpapplication.di.module.MainActivityMvpModule;
import com.nancy.mvpapplication.di.qualifier.ActivityContext;
import com.nancy.mvpapplication.di.scope.ActivityScope;

import dagger.Component;


@ActivityScope
@Component(modules = {AdapterModule.class, MainActivityMvpModule.class}, dependencies = ApplicationComponent.class)
public interface MainActivityComponent {

    @ActivityContext
    Context getContext();

    void injectMainActivity(MainActivity mainActivity);
}



package com.nancy.mvpapplication.di.component;




import android.content.Context;


import com.nancy.mvpapplication.APIInterface;
import com.nancy.mvpapplication.MyApplication;
import com.nancy.mvpapplication.di.module.ContextModule;
import com.nancy.mvpapplication.di.module.RetrofitModule;
import com.nancy.mvpapplication.di.qualifier.ApplicationContext;
import com.nancy.mvpapplication.di.scope.ApplicationScope;

import dagger.Component;

@ApplicationScope
@Component(modules = {ContextModule.class, RetrofitModule.class})
public interface ApplicationComponent {

    APIInterface getApiInterface();

    @ApplicationContext
    Context getContext();

    void injectApplication(MyApplication myApplication);
}


package com.nancy.mvpapplication.di.module;



import android.content.Context;

import com.nancy.mvpapplication.di.qualifier.ApplicationContext;
import com.nancy.mvpapplication.di.scope.ApplicationScope;

import dagger.Module;
import dagger.Provides;

    @Module
    public class ContextModule {
        private Context context;

        public ContextModule(Context context) {
            this.context = context;
        }

        @Provides
        @ApplicationScope
        @ApplicationContext
        public Context provideContext() {
            return context;
        }
    }



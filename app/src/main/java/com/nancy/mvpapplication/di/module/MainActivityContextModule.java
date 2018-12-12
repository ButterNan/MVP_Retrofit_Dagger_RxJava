package com.nancy.mvpapplication.di.module;


        import android.content.Context;


        import com.nancy.mvpapplication.MainActivity;
        import com.nancy.mvpapplication.di.qualifier.ActivityContext;
        import com.nancy.mvpapplication.di.scope.ActivityScope;

        import dagger.Module;
        import dagger.Provides;

        @Module
        public class MainActivityContextModule {
        private MainActivity mainActivity;

        public Context context;

        public MainActivityContextModule(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        context = mainActivity;
        }

        @Provides
        @ActivityScope
        public MainActivity providesMainActivity() {
        return mainActivity;
        }

        @Provides
        @ActivityScope
        @ActivityContext
        public Context provideContext() {
        return context;
        }

        }

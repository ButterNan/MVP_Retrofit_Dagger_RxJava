package com.nancy.mvpapplication.di.module;





        import com.nancy.mvpapplication.di.scope.ActivityScope;
        import com.nancy.mvpapplication.mvp.MainActivityContract;

        import dagger.Module;
        import dagger.Provides;

        @Module
        public class MainActivityMvpModule {
        private final MainActivityContract.View mView;


        public MainActivityMvpModule(MainActivityContract.View mView) {
        this.mView = mView;
        }

        @Provides
        @ActivityScope
        MainActivityContract.View provideView() {
        return mView;
        }


        }

package com.nancy.mvpapplication.di.module;





        import com.nancy.mvpapplication.MainActivity;
        import com.nancy.mvpapplication.RecyclerViewAdapter;
        import com.nancy.mvpapplication.di.scope.ActivityScope;

        import dagger.Module;
        import dagger.Provides;

        @Module(includes = {MainActivityContextModule.class})
        public class AdapterModule {

        @Provides
        @ActivityScope
        public RecyclerViewAdapter getCoinList(RecyclerViewAdapter.ClickListener clickListener) {
        return new RecyclerViewAdapter(clickListener);
        }

        @Provides
        @ActivityScope
        public RecyclerViewAdapter.ClickListener getClickListener(MainActivity mainActivity) {
        return mainActivity;
        }
        }

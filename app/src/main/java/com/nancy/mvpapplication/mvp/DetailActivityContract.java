package com.nancy.mvpapplication.mvp;

import com.nancy.mvpapplication.Pojo.StarWars;

import java.util.List;

public interface DetailActivityContract {

    interface View {
        void showData(String data);
        void showError(String message);
        void showComplete();
    }

    interface Presenter {
        void loadData(String name);
    }
}

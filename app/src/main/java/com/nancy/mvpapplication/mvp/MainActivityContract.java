package com.nancy.mvpapplication.mvp;

import com.nancy.mvpapplication.Pojo.CryptoData;
import com.nancy.mvpapplication.Pojo.StarWars;

import java.util.List;

public interface MainActivityContract {


        interface View {
            void showData(List<StarWars.People> data);
            void showError(String message);
            void showComplete();
            void showProgress();
            void hideProgress();
        }

        interface Presenter {
            void loadData();
        }
    }



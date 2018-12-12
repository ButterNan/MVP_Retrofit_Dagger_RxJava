package com.nancy.mvpapplication.mvp;

import android.widget.Toast;

import com.nancy.mvpapplication.APIInterface;

import javax.inject.Inject;

public class PresenterDetailImpl implements DetailActivityContract.Presenter{

    APIInterface apiInterface;
    DetailActivityContract.View mView;

    @Inject
    public PresenterDetailImpl(APIInterface apiInterface, DetailActivityContract.View mView) {
        this.apiInterface = apiInterface;
        this.mView = mView;
    }

    @Override
    public void loadData(String name) {
        mView.showData(name);
        //Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }
}

package com.nancy.mvpapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.nancy.mvpapplication.Pojo.StarWars;
import com.nancy.mvpapplication.di.component.ApplicationComponent;


import com.nancy.mvpapplication.di.component.DaggerDetailActivityComponent;
import com.nancy.mvpapplication.di.component.DetailActivityComponent;
import com.nancy.mvpapplication.di.module.DetailActivityContextModule;
import com.nancy.mvpapplication.di.module.DetailActivityMvpModule;
import com.nancy.mvpapplication.di.module.MainActivityContextModule;
import com.nancy.mvpapplication.di.module.MainActivityMvpModule;
import com.nancy.mvpapplication.di.qualifier.ApplicationContext;
import com.nancy.mvpapplication.mvp.DetailActivityContract;
import com.nancy.mvpapplication.mvp.PresenterDetailImpl;

import java.util.List;

import javax.inject.Inject;

public class DetailActivity extends AppCompatActivity implements DetailActivityContract.View {

    private TextView textView;

    DetailActivityComponent detailActivityComponent;

    @Inject
    public APIInterface apiInterface;

    @Inject
    @ApplicationContext
    public Context mContext;

    @Inject
    PresenterDetailImpl presenterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = findViewById(R.id.textView);



        ApplicationComponent applicationComponent = MyApplication.get(this).getApplicationComponent();
        detailActivityComponent = DaggerDetailActivityComponent.builder()
                .detailActivityContextModule(new DetailActivityContextModule(this))
                .detailActivityMvpModule(new DetailActivityMvpModule(this))
                .applicationComponent(applicationComponent)
                .build();
//.detailActivityContextModule(new DetailActivityContextModule(this))

        detailActivityComponent.inject(this);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        presenterDetail.loadData(name);

    }

    @Override
    public void showData(String name) {

        textView.setText(name);
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(String message) {

    }

    @Override
    public void showComplete() {

    }
}

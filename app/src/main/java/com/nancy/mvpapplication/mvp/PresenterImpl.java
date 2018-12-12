package com.nancy.mvpapplication.mvp;

import com.nancy.mvpapplication.APIInterface;
import com.nancy.mvpapplication.Pojo.CryptoData;
import com.nancy.mvpapplication.Pojo.StarWars;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PresenterImpl implements MainActivityContract.Presenter {





        APIInterface apiInterface;
        MainActivityContract.View mView;

        @Inject
        public PresenterImpl(APIInterface apiInterface, MainActivityContract.View mView) {
            this.apiInterface = apiInterface;
            this.mView = mView;
        }

        @Override
        public void loadData() {

            mView.showProgress();

//            apiInterface.getData("10").subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(new Observer<List<CryptoData>>() {
//                        @Override
//                        public void onCompleted() {
//                            mView.showComplete();
//                            mView.hideProgress();
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            mView.showError("Error occurred");
//                            mView.hideProgress();
//                        }
//
//                        @Override
//                        public void onNext(List<CryptoData> data) {
//                            mView.showData(data);
//                        }
//                    });

            Observable<StarWars> peopleResponse = apiInterface.getPeople("json")
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread());

            peopleResponse.subscribeWith(new Observer<StarWars>() {
                @Override
                public void onSubscribe(Disposable d) {

                }

                @Override
                public void onNext(StarWars starWars) {
                    mView.showData(starWars.results);
                    //populateRecyclerView(starWars.results);
                }

                @Override
                public void onError(Throwable e) {
                    mView.showError("Error occurred");
                            mView.hideProgress();
                }

                @Override
                public void onComplete() {
                    mView.showComplete();
                          mView.hideProgress();
                }
            });



//            apiInterface.getData("10")
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribeWith(new Observer<List<CryptoData>>(){
//
//                        @Override
//                        public void onSubscribe(Disposable d) {
//
//                        }
//
//                        @Override
//                        public void onNext(List<CryptoData> cryptoData) {
//                            mView.showData(cryptoData);
//                        }
//
//                        @Override
//                        public void onError(Throwable e) {
//                            mView.showError("Error occurred");
//                            mView.hideProgress();
//                        }
//
//                        @Override
//                        public void onComplete() {
//                            mView.showComplete();
//                           mView.hideProgress();
//                        }
//                    });

//            peopleResponse.subscribeWith(new Observer<List<CryptoData>>() {
//                @Override
//                public void onSubscribe(Disposable d) {
//
//                }
//
//                @Override
//                public void onNext(List<CryptoData> starWars) {
//                    //populateRecyclerView(starWars.results);
//                    mView.showData(starWars);
//                }
//
//                @Override
//                public void onError(Throwable e) {
//                    mView.showError("Error occurred");
//                            mView.hideProgress();
//                }
//
//                @Override
//                public void onComplete() {
//                    mView.showComplete();
//                           mView.hideProgress();
//
//                }
//            });
        }
    }



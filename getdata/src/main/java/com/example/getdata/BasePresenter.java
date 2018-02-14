package com.example.getdata;

/**
 * Created by micha on 2/13/2018.
 */

public interface BasePresenter<Q extends BaseView> {
    void attachView(Q view);
    void detachView();
}

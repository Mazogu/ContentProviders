package com.example.micha.contentdata;

/**
 * Created by micha on 2/12/2018.
 */

public interface BasePresenter<V extends BaseView> {
    public void attachView(V view);
    public void detachView();
}

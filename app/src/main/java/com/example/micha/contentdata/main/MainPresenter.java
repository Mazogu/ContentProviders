package com.example.micha.contentdata.main;

import android.content.Context;

import com.example.micha.contentdata.model.Person;
import com.example.micha.contentdata.utils.ContentBridge;

/**
 * Created by micha on 2/12/2018.
 */

public class MainPresenter implements MainContract.MPresenter {

    MainContract.MView view;

    @Override
    public void attachView(MainContract.MView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void addPerson(Person person) {
        ContentBridge contentBridge = new ContentBridge((Context) view);
        contentBridge.insert(person);
    }
}

package com.example.micha.contentdata.list;

import android.content.Context;

import com.example.micha.contentdata.model.Person;
import com.example.micha.contentdata.utils.ContentBridge;

import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public class ListPresenter implements ListContract.LPresenter{

    ListContract.LView view;
    ContentBridge bridge;


    @Override
    public void attachView(ListContract.LView view) {
        this.view = view;
        bridge = new ContentBridge((Context) view);
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public List<Person> getPeople() {
        return bridge.getPeople();
    }
}

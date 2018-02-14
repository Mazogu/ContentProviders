package com.example.getdata.get;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import com.example.getdata.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public class GetPresenter implements GetContract.GPresenter {

    GetContract.GView view;

    @Override
    public void attachView(GetContract.GView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }


    @Override
    public List<Person> getPeople() {
        List<Person> list = new ArrayList<>();
        Uri uri = Uri.parse("content://com.example.micha.contentdata.utils.PeopleContentProvider");
        ContentResolver resolver = ((Activity) view).getContentResolver();
        Cursor cursor = resolver.query(uri,null,null,null,null);
        if(cursor.moveToFirst()){
            do{
                Person person = new Person(cursor.getString(0), cursor.getString(1), cursor.getString(2), cursor.getString(3),
                        cursor.getString(4));
                list.add(person);
            }while (cursor.moveToNext());
        }
        else{
            view.showError("Query is empty");
        }
        return list;
    }
}

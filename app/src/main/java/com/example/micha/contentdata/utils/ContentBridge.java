package com.example.micha.contentdata.utils;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.example.micha.contentdata.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by micha on 2/13/2018.
 */

public class ContentBridge {

    public static final String PROVIDER_URI = "com.example.micha.contentdata.utils.PeopleContentProvider";
    private PeopleContentProvider provider;

    public ContentBridge(Context context){
        provider = new PeopleContentProvider(context);
    }

    public void insert(Person person){
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Person.NAME,person.getName());
        values.put(DatabaseContract.Person.MIDDLE_NAME,person.getMiddle());
        values.put(DatabaseContract.Person.EMAIL,person.getMiddle());
        values.put(DatabaseContract.Person.PHONE_NO,person.getPhone());
        values.put(DatabaseContract.Person.COMPANY,person.getCompany());
        Uri uri = new Uri.Builder().appendPath("com.example.micha.contentdata.utils.PeopleContentProvider").build();
        provider.insert(uri,values);
    }

    public List<Person> getPeople(){
        List<Person> people = new ArrayList<>();
        Cursor cursor = provider.query(Uri.parse(PROVIDER_URI), null, null,null, null);
        if(cursor.moveToFirst()){
            do {
                Person person = new Person(cursor.getString(0), cursor.getString(1), cursor.getString(2),
                        cursor.getString(3), cursor.getString(4));
                people.add(person);
            } while (cursor.moveToNext());
        }
        return people;
    }
}

package com.example.micha.contentdata.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.micha.contentdata.model.Person;

/**
 * Created by micha on 2/12/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final int VERSION = 1;
    public static final String DATABASE_NAME = "Person Database";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DatabaseContract.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public long insert(ContentValues values){
        SQLiteDatabase db = getWritableDatabase();
        long row = db.insertWithOnConflict(DatabaseContract.Person.TABLE_NAME, null, values,SQLiteDatabase.CONFLICT_IGNORE);
        db.close();
        return row;
    }

    public Cursor query(String table,String[] projection,String selection,String[] args){
        SQLiteDatabase db = getReadableDatabase();
        return db.query(table,projection,selection,args,null,null, DatabaseContract.Person.NAME+" ASC");
    }


}

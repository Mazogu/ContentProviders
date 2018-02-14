package com.example.micha.contentdata.utils;

import android.provider.BaseColumns;

/**
 * Created by micha on 2/12/2018.
 */

public class DatabaseContract {

    public static final String CREATE_TABLE = "CREATE TABLE "+
            Person.TABLE_NAME+"("+Person.NAME + " TEXT PRIMARY KEY, "
            +Person.MIDDLE_NAME + " TEXT, "
            +Person.EMAIL + " TEXT, "
            +Person.PHONE_NO + " TEXT, "
            +Person.COMPANY + " TEXT)";

    public static class Person implements BaseColumns{
        public static final String TABLE_NAME = "Person";
        public static final String NAME = "Name";
        public static final String MIDDLE_NAME = "Middle_Name";
        public static final String EMAIL = "Email";
        public static final String PHONE_NO = "Phone";
        public static final String COMPANY = "Company";
    }
}

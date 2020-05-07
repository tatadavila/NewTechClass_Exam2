package com.edu.uac.co.newtech_exam2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RegistersDb extends SQLiteOpenHelper {

    private static final int BD_VERSION = 1;

    public RegistersDb(Context context) {
        super(context, DbDef.BD_NAME, null, BD_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DbDef.CREATE_TESTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onCreate(db);
    }
}

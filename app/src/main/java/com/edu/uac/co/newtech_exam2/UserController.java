package com.edu.uac.co.newtech_exam2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserController {

    private RegistersDb db;

    public UserController(Context context) {
        this.db = new RegistersDb(context);
    }

    public void registerUser(User u) {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put(DbDef.ID_COL, u.id);
            values.put(DbDef.NAME_COL, u.name);
            values.put(DbDef.ADDRESS_COL, u.stratum);
            values.put(DbDef.ATTENT_PLACE_COL, u.wage);
            values.put(DbDef.DATE_COL, u.educationLevel);

            database.insert(DbDef.TABLE_NAME, null, values);

        } catch (Exception e) {
            System.out.println("Isertion Error");
        }
    }

    public boolean findUser(String uId) {
        SQLiteDatabase database = db.getReadableDatabase();
        String[] args = {uId};

        Cursor c = database.query(DbDef.TABLE_NAME, null, "ID=?", args, null, null, null);

        if (c.getCount() > 0) {
            database.close();
            return true;
        } else {
            database.close();
            return false;
        }
    }

    public void updateUser(User u) {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues values = new ContentValues();
            String[] args = {u.id};

            values.put(DbDef.ID_COL, u.id);
            values.put(DbDef.NAME_COL, u.name);
            values.put(DbDef.ADDRESS_COL, u.stratum);
            values.put(DbDef.ATTENT_PLACE_COL, u.wage);
            values.put(DbDef.DATE_COL, u.educationLevel);

            database.update(DbDef.TABLE_NAME, values, "ID=?", args);
            database.close();

        } catch (Exception e) {
            System.out.println("Update Error");
        }
    }

    public void deleteUser (User u){
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            String[] args = {u.id};
            database.delete(DbDef.TABLE_NAME, "ID=?", args);

        } catch(Exception e) {
            System.out.println("Deleting Error");
        }
    }

    public Cursor allUsers() {
        try {
            SQLiteDatabase database = db.getWritableDatabase();
            Cursor c = database.rawQuery("select ID as _id , NAME, ADDRESS, ATTENTION_PLACE, POSITIVE_TEST_DATE from TESTS", null);
            return c;
        } catch (final Exception e) {
            System.out.println("Query Error");
            return null;
        }
    }
}

package com.example.slotallotment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBhHelper extends SQLiteOpenHelper {
    public DBhHelper(Context context) {
        super(context, "slot.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table slfac(slot TEXT , facname TEXT, subject TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists slfac");

    }
    public boolean insertdata(String slot, String facname, String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("slot",slot);
        contentValues.put("facname",facname);
        contentValues.put("subject",subject);
        long result = DB.insert("slfac", null,contentValues);
        if(result ==-1){
            return false;
        }
        return true;
    }
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from slfac",null);
        return cursor;
    }
    public void clear(){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from slfac");
    }

}

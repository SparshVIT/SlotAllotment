package com.example.slotallotment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Dbint extends SQLiteOpenHelper {
    public Dbint(Context context) {
        super(context, "int.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table interimfac(ClassNo TEXT primary key,slot TEXT , facname TEXT, subject TEXT) ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists interimfac");
    }
    public boolean insertdata(String ClassNo,String slot, String facname, String subject){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Classno",ClassNo);
        contentValues.put("slot",slot);
        contentValues.put("facname",facname);
        contentValues.put("subject",subject);
        long result = DB.insert("interimfac", null,contentValues);
        if(result ==-1){
            return false;
        }
        return true;
    }
    public Cursor getdata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from interimfac order by subject, slot, Classno ASC",null);
        return cursor;
    }
    public Cursor getsorteddata(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from interimfac order by facname ASC",null);
        return cursor;
    }
    public void clear(){
        SQLiteDatabase DB = this.getWritableDatabase();
        DB.execSQL("delete from interimfac");
    }
    public void updateData(String classno){
        SQLiteDatabase DB =this.getWritableDatabase();

        DB.delete("interimfac","Classno=?",new String[]{classno});


    }
}

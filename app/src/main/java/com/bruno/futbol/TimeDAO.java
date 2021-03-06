package com.bruno.futbol;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class TimeDAO {

    public static void inserirTime(Context contexto , Time time){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome",time.getNome());

        db.insert("time",null,valores);
    }



    public static void editartime(Context contexto , Time time){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        ContentValues valores = new ContentValues();

        valores.put("nome",time.getNome());

        db.update("time",valores,"id="+time.getId(),null);

    }

    public static void excluirTime(Context contexto, int idtime){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        db.delete("time","id="+idtime,null);

    }

    public static List<Time> getTime(Context contexto){

        List<Time> listaTimes = new ArrayList<>();

        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM time ORDER BY nome",null);

        if(cursor.getCount()>0){
            cursor.moveToFirst();

            do {
                Time time = new Time();
                time.setId(cursor.getInt(0));
                time.setNome(cursor.getString(1));
                listaTimes.add(time);
            }while(cursor.moveToNext());
        }
        return listaTimes;
    }

    public static Time getTimeByID(Context contexto , int idtime){
        Banco banco = new Banco(contexto);
        SQLiteDatabase db = banco.getWritableDatabase();

        Cursor cursor = db.rawQuery( "SELECT * FROM time WHERE id = " + idtime ,null);

        if(cursor.getCount()>0){

            cursor.moveToFirst();

            Time time = new Time();

            time.setId(cursor.getInt(0));
            time.setNome(cursor.getString(1));

            return time;
        }else{

            return null;
        }

    }

}

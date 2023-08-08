package com.example.laka.albumcollection.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import android.content.Context;
import android.util.Log;



public class SQLiteBase extends SQLiteOpenHelper {

    protected static Context ctx;

    public SQLiteBase(Context context) {
        super(context, "album collection", null, 6);
        this.ctx = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE artists (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)");

        sqLiteDatabase.execSQL("CREATE TABLE songs (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "position INTEGER," +
                "title TEXT," +
                "album_id INTEGER," +
                "FOREIGN KEY (album_id) REFERENCES albums(id))");

        sqLiteDatabase.execSQL("CREATE TABLE albums (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "artist_id INTEGER," +
                "FOREIGN KEY (artist_id) REFERENCES artists(id))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w("PDMLog", "Upgrading database from version " + i
                + " to " + i1 + ", which will destroy all old data");

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS artists");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS songs");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS albums");

        onCreate(sqLiteDatabase);
    }
}

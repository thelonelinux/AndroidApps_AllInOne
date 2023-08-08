package com.example.laka.albumcollection.dao;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.laka.albumcollection.models.Artist;
import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Song;

public class SQLiteAlbumDatabase extends SQLiteBase{

    public SQLiteAlbumDatabase(Context context) {
        super(context);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w("PDMLog", "Upgrading database from version " + oldVersion
                + " to " + newVersion + ", which will destroy all old data");

        db.execSQL("DROP TABLE IF EXISTS albums");
        onCreate(db);
    }

    // ========== CRUD Operations

    public void create(Album album) {
        ContentValues values = new ContentValues();
        values.put("title", album.getTitle());
        values.put("artist_id", album.getArtist().getID());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("albums", null, values);

        db.close();
    }

    public Album find(int id) {
        Album result = null;
        SQLiteArtistDatabase dbArtist = new SQLiteArtistDatabase(this.ctx);
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("albums", new String[] { "id", "title", "artist_id" }, "id=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Artist artist = dbArtist.find(cursor.getInt(2));
            result = new Album(cursor.getInt(0),
                    cursor.getString(1),
                    artist);
        }

        db.close();

        return result;
    }

    public void delete(Album album) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteSongDatabase dbSongs = new SQLiteSongDatabase(this.ctx);


        for (Song song : dbSongs.all(album))
            dbSongs.delete(song);

        db.delete("albums", "id = ?",
                new String[] { String.valueOf(album.getID()) });
        db.close();
    }

    public void update(Album album) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", album.getTitle());
        values.put("artist_id", album.getArtist().getID());

        db.update("albums", values, "id = ?",
                new String[] { String.valueOf(album.getID()) });

        db.close();
    }



    public int count() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM albums", null);

        cursor.moveToFirst();
        int count = cursor.getInt(0);

        db.close();

        return count;
    }

    public List<Album> all(Artist artist) {
        List<Album> result = new ArrayList<Album>();
        SQLiteArtistDatabase dbArtist = new SQLiteArtistDatabase(this.ctx);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = {String.valueOf(artist.getID())};
        Cursor cursor = db.query("albums", new String[] { "id", "title", "artist_id"}, "artist_id=?",
                new String[] { String.valueOf(artist.getID()) }, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                result.add(new Album(cursor.getInt(0),
                        cursor.getString(1),
                        artist));
            } while (cursor.moveToNext());
        }

        db.close();

        return result;
    }

    public boolean albumHasSongs(int albumID) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("songs", new String[] { "id"}, "album_id = ?",
                new String[] { String.valueOf(albumID) }, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        return false;
    }


}
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



public class SQLiteSongDatabase extends SQLiteBase{

    public SQLiteSongDatabase(Context context) {
        super(context);
    }


    public void create(Song song) {
        ContentValues values = new ContentValues();
        values.put("title", song.getTitle());
        values.put("position", song.getPosition());
        values.put("album_id", song.getAlbum().getID());
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("songs", null, values);
        db.close();
    }

    public Song find(int id) {
        Song result = null;
        SQLiteAlbumDatabase dbAlbum = new SQLiteAlbumDatabase(this.ctx);
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("songs", new String[] { "id", "title", "position", "album_id" }, "id=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            Album album = dbAlbum.find(cursor.getInt(3));
            result = new Song(cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2),
                    album);
        }

        db.close();

        return result;
    }

    public void delete(Song song) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("songs", "id = ?",
                new String[] { String.valueOf(song.getID()) });
        db.close();
    }

    public void update(Song song) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("title", song.getTitle());
        values.put("position", song.getPosition());
        values.put("album_id", song.getAlbum().getID());

        db.update("songs", values, "id = ?",
                new String[] { String.valueOf(song.getID()) });

        db.close();
    }

    public List<Song> all(Album album) {
        List<Song> result = new ArrayList<Song>();
        SQLiteAlbumDatabase dbAlbum = new SQLiteAlbumDatabase(this.ctx);
        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = {String.valueOf(album.getID())};
        Cursor cursor = db.query("songs", new String[] { "id", "title", "position", "album_id"}, "album_id=?",
                new String[] { String.valueOf(album.getID()) }, null, null, "position");
        if (cursor.moveToFirst()) {
            do {
                result.add(new Song(cursor.getInt(0),
                        cursor.getString(1),
                        cursor.getInt(2),
                        album));
            } while (cursor.moveToNext());
        }
        db.close();
        return result;
    }

}

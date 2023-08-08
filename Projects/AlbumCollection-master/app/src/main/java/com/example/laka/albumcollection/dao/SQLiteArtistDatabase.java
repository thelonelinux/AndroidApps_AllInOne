package com.example.laka.albumcollection.dao;



import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.laka.albumcollection.models.Album;
import com.example.laka.albumcollection.models.Artist;
import com.example.laka.albumcollection.models.Song;

public class SQLiteArtistDatabase extends SQLiteBase {

    public SQLiteArtistDatabase(Context context) {
        super(context);
    }

    public void create(Artist artist) {
        ContentValues values = new ContentValues();
        values.put("name", artist.getName());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert("artists", null, values);

        db.close();
    }

    public Artist find(int id) {
        Artist result = null;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("artists", new String[] { "id", "name"}, "id=?",
                new String[] { String.valueOf(id) }, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            result = new Artist(cursor.getInt(0),
                    cursor.getString(1)
            );
        }

        db.close();

        return result;
    }

    public void delete(Artist artist) {
        SQLiteDatabase db = this.getWritableDatabase();
        SQLiteAlbumDatabase dbAlbums = new SQLiteAlbumDatabase(this.ctx);
        SQLiteSongDatabase dbSongs = new SQLiteSongDatabase(this.ctx);

        for (Album album : dbAlbums.all(artist))
        {
            for (Song song : dbSongs.all(album))
                dbSongs.delete(song);
            dbAlbums.delete(album);
        }

        db.delete("artists", "id = ?",
                new String[] { String.valueOf(artist.getID()) });

        db.close();
    }

    public void update(Artist artist) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", artist.getName());

        db.update("artists", values, "id = ?",
                new String[] { String.valueOf(artist.getID()) });

        db.close();
    }

    public int count() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT COUNT(*) FROM artists", null);

        cursor.moveToFirst();

        int count = cursor.getInt(0);

        db.close();

        return count;
    }

    public List<Artist> all() {
        List<Artist> result = new ArrayList<Artist>();
        SQLiteArtistDatabase dbArtist = new SQLiteArtistDatabase(this.ctx);

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT  * FROM artists ORDER BY name", null);

        if (cursor.moveToFirst()) {
            do {
                result.add(new Artist(cursor.getInt(0),
                        cursor.getString(1))
                );
            } while (cursor.moveToNext());
        }

        db.close();

        return result;
    }

    public boolean artistHasAlbums(int artistID) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query("albums", new String[] { "id"}, "artist_id = ?",
                new String[] { String.valueOf(artistID) }, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            return true;
        }
        return false;
    }

}
package com.example.laka.albumcollection.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.laka.albumcollection.models.Artist;
import com.example.laka.albumcollection.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;



public class ArtistAdapter extends BaseAdapter {
    private LayoutInflater inflater;
    private ArrayList<Artist> artists;
    private Context ctx;
    private String imgURL = "";

    public ArtistAdapter(ArrayList<Artist> artists, LayoutInflater inflater, Context ctx){
        this.inflater = inflater;
        this.artists = artists;
        this.ctx = ctx;
    }


    public void add(Artist artist){
        artists.add(artist);
    }

    public void remove(int index){
        artists.remove(index);
    }

    private void setArtistAvatar(final View v, String name) throws MalformedURLException {

        RequestQueue queue = Volley.newRequestQueue(ctx);
        String urlString = ("http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist=" +
                name+
                "&api_key=e058d941c20d4a6563a5380315da4e25&format=json"
        );

        URL url = new URL(urlString);

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url.toString(), new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONObject artistJSON = response.getJSONObject("artist");
                            findLarge(artistJSON.getJSONArray("image"));
                            new DownloadImageTask((ImageView)v.findViewById(R.id.artistArt))
                                    .execute(imgURL);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.v("Debug: ", "Response: " + error.getMessage());
                    }
                });
        queue.add(jsObjRequest);
    }

    private void findLarge(JSONArray images) throws JSONException {
        JSONObject jsonHash = images.getJSONObject(images.length()-2);
        imgURL = jsonHash.getString("#text");
    }

    @Override
    public int getCount() {
        return artists.size();
    }

    @Override
    public Object getItem(int i) {
        return artists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return artists.get(i).getID();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Artist artist = artists.get(i);

        View v = inflater.inflate(R.layout.adapter_artist_layout, null);

        try {
            setArtistAvatar(v, artist.getName());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        ((TextView)v.findViewById(R.id.artistNameText)).setText(artist.toString());


        return v;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}

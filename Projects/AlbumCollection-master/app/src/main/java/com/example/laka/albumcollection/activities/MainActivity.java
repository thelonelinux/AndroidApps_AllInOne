package com.example.laka.albumcollection.activities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.laka.albumcollection.R;
import com.example.laka.albumcollection.adapters.ArtistAdapter;
import com.example.laka.albumcollection.dao.SQLiteArtistDatabase;
import com.example.laka.albumcollection.models.Artist;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button newArtistbtn;
    private SQLiteArtistDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    protected void changeActivity(Context context, Class nameClass) {
        Intent intent = new Intent(context, nameClass);
        startActivity(intent);
    }

    protected void gotoMain()
    {
        changeActivity(getBaseContext(), MainActivity.class);
    }

    protected boolean isFieldEmpty(EditText text) {
        return text.getText().toString().trim().equals("");
    }

    protected void showToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    protected void showNotification(String message) {

        int idNotificacao = 1;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this);
        mBuilder.setSmallIcon(android.R.drawable.ic_menu_add);
        mBuilder.setContentTitle("Album Collection");

        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, resultIntent, 0);
        mBuilder.setContentIntent(resultPendingIntent );
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder.setContentText(message);
        mNotificationManager.notify(idNotificacao, mBuilder.build());

    }

    protected void showEmptyFieldToast() {
        showToast("One or more fields are empty.");
    }


    private void newArtistListener()
    {
        newArtistbtn = (Button) findViewById(R.id.newArtistMain);


        newArtistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeActivity(getBaseContext(), NewArtistActivity.class);
            }
        });
    }

    // Artists operation //

    private void setDB() {
        db = new SQLiteArtistDatabase(getApplicationContext());
    }

    private void setListView() {

        ListView lv = (ListView) findViewById(R.id.artistList);
        final ListAdapter artistAdapter = new ArtistAdapter(
                (ArrayList<Artist>) db.all(), getLayoutInflater(), this.getApplicationContext());
        lv.setAdapter(artistAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                sendID(artistAdapter, position);
            }
        });
    }

    private void sendID(ListAdapter artistAdapter, int position) {
        Bundle params = new Bundle();
        params.putLong("id", artistAdapter.getItemId(position));
        Intent intent = new Intent(getBaseContext(), AlbumsActivity.class);
        intent.putExtras(params);
        startActivity(intent);
    }

    // INIT //
    private void init()
    {
        setDB();
        newArtistListener();
        setListView();
    }

}

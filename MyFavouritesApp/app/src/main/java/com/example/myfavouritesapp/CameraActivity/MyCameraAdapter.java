package com.example.myfavouritesapp.CameraActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavouritesapp.R;

import java.io.File;
import java.util.ArrayList;


public class MyCameraAdapter extends RecyclerView.Adapter<MyCameraViewHolder> {

    Context c;
    ArrayList<ImagePojo> imagePojos;

    public MyCameraAdapter(Context c, ArrayList<ImagePojo> imagePojos) {
        this.c = c;
        this.imagePojos = imagePojos;
    }

    @Override
    public MyCameraViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.camera_list_item,parent,false);
        return new MyCameraViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyCameraViewHolder holder, int position)  {

        ImagePojo s= imagePojos.get(position);

        Bitmap bitmap;

        holder.nameTxt.setText(s.getName());

        Uri currentUri=s.getUri();
        String string=currentUri.toString();
        File root = android.os.Environment.getExternalStorageDirectory();


        bitmap = BitmapFactory.decodeFile(root.getAbsolutePath() + "/CustomImage/"+s.getName());

        holder.img.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return imagePojos.size();
    }
}

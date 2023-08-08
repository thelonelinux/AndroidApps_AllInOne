package com.example.myfavouritesapp.VideoActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavouritesapp.CameraActivity.ImagePojo;
import com.example.myfavouritesapp.VideoActivity.MyVideoViewHolder;
import com.example.myfavouritesapp.R;

import java.io.File;
import java.util.ArrayList;

public class MyVideoAdapter extends RecyclerView.Adapter<MyVideoViewHolder> {

    Context c;
    ArrayList<VideoPojo> videoPojos;

    public MyVideoAdapter(Context c, ArrayList<VideoPojo> videoPojos) {
        this.c = c;
        this.videoPojos = videoPojos;
    }

    @Override
    public MyVideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.video_list_item,parent,false);
        return new MyVideoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyVideoViewHolder holder, int position)  {

        VideoPojo s= videoPojos.get(position);

        Bitmap bitmap;

        holder.nameTxt.setText(s.getName());

        Uri currentUri=s.getUri();
        String string=currentUri.toString();
        File root = android.os.Environment.getExternalStorageDirectory();


        bitmap = BitmapFactory.decodeFile(root.getAbsolutePath() + "/Movies/camera2VideoImage/"+s.getName());

        Bitmap bitmap1=ThumbnailUtils.createVideoThumbnail(root.getAbsolutePath() + "/Movies/camera2VideoImage/"+s.getName(),1);

        holder.img.setImageBitmap(bitmap1);

    }

    @Override
    public int getItemCount() {
        return videoPojos.size();
    }

    public Bitmap createThumbnailFromPath(String filePath, int type){
        return ThumbnailUtils.createVideoThumbnail(filePath, type);
    }

}



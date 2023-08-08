package com.example.myfavouritesapp.PaintActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myfavouritesapp.PaintActivity.PaintPojo;
import com.example.myfavouritesapp.PaintActivity.MyPaintViewHolder;
import com.example.myfavouritesapp.R;

import java.io.File;
import java.util.ArrayList;


public class MyPaintAdapter extends RecyclerView.Adapter<MyPaintViewHolder> {

    Context c;
    ArrayList<PaintPojo> paintPojos;

    public MyPaintAdapter(Context c, ArrayList<PaintPojo> paintPojos) {
        this.c = c;
        this.paintPojos = paintPojos;
    }

    @Override
    public MyPaintViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(c).inflate(R.layout.paint_list_item,parent,false);
        return new MyPaintViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyPaintViewHolder holder, int position)  {

        PaintPojo s= paintPojos.get(position);

        Bitmap bitmap;

        holder.nameTxt.setText(s.getName());

        Uri currentUri=s.getUri();
        String string=currentUri.toString();
        File root = android.os.Environment.getExternalStorageDirectory();


        bitmap = BitmapFactory.decodeFile(root.getAbsolutePath() + "/Pictures/"+s.getName());

        holder.img.setImageBitmap(bitmap);

    }

    @Override
    public int getItemCount() {
        return paintPojos.size();
    }
}

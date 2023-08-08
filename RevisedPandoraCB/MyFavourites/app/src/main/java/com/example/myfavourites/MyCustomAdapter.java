package com.example.myfavourites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyCustomAdapter extends RecyclerView.Adapter<MyCustomAdapter.MyVeiwHolder>{

    private ArrayList<VideoInfo> videoInfoArrayList;
    private Context context;

    public MyCustomAdapter(ArrayList<VideoInfo> videoInfoArrayList,Context context){
       this.videoInfoArrayList = videoInfoArrayList;
       this.context = context;
    }

    @NonNull
    @Override
    public MyCustomAdapter.MyVeiwHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater lif=LayoutInflater.from(context);
        View inflatedView=lif.inflate(R.layout.item_row,viewGroup,false);
        return new MyVeiwHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyCustomAdapter.MyVeiwHolder myVeiwHolder, int i) {
        VideoInfo currentVideoInfo=videoInfoArrayList.get(i);
        myVeiwHolder.description.setText(currentVideoInfo.getDescription());
        myVeiwHolder.drawable.setImageResource(currentVideoInfo.getDrawable());


    }

    @Override
    public int getItemCount() {
        return videoInfoArrayList.size();
    }

    public class MyVeiwHolder extends RecyclerView.ViewHolder {

        TextView description;
        ImageView drawable;

        public MyVeiwHolder(@NonNull View itemView) {
            super(itemView);

            description=itemView.findViewById(R.id.tvItemRow);
            drawable=itemView.findViewById(R.id.thumbnail);


        }
    }

}

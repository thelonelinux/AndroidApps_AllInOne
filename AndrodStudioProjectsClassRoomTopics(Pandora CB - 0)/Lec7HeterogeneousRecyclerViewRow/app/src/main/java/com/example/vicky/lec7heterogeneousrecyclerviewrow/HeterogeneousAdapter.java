package com.example.vicky.lec7heterogeneousrecyclerviewrow;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class HeterogeneousAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Object> objects;
    private Context context;

   public static final int IMAGE=0;
   public static final int NAME=1;

    public HeterogeneousAdapter(ArrayList<Object> objects, Context context) {
        this.objects = objects;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
        Object currentObject = objects.get(position);
        if (currentObject instanceof ImageUrl){
            return IMAGE;
        }else if (currentObject instanceof Name){
            return NAME;
        }
        return -1;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater li = LayoutInflater.from(context);
        if (i==NAME){
            View inflatedView = li.inflate(R.layout.item_row_1,viewGroup,false);
            return new ViewHolder1(inflatedView);
        }else if (i==IMAGE){
            View inflatedView = li.inflate(R.layout.item_row_2,viewGroup,false);
            return new ViewHolder2(inflatedView);
        }
        else return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder.getItemViewType()==NAME){
            ViewHolder1 vh1= (ViewHolder1) viewHolder;
            Name currentName= (Name) objects.get(i);
            vh1.tvRow1.setText(currentName.name);

        }else  if (viewHolder.getItemViewType()==IMAGE){
            ViewHolder2 vh2= (ViewHolder2) viewHolder;
            ImageUrl currentImage = (ImageUrl) objects.get(i);
            Picasso.get().load(currentImage.url).into(vh2.ivRow2);
        }

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class ViewHolder1 extends RecyclerView.ViewHolder {

        TextView tvRow1;

        public ViewHolder1(@NonNull View itemView) {
            super(itemView);
            tvRow1=itemView.findViewById(R.id.tvRow1);

        }
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder{

        ImageView ivRow2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            ivRow2=itemView.findViewById(R.id.ivRow2);
        }
    }
}

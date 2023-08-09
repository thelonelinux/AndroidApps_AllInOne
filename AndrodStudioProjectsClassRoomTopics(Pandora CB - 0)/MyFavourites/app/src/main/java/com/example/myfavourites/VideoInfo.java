package com.example.myfavourites;

import android.graphics.drawable.Drawable;

public class VideoInfo {

    private String description;
    private int drawable;

    public VideoInfo(String description, int drawable) {
        this.description = description;
        this.drawable = drawable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDrawable() {
        return drawable;
    }

    public void setDrawable(int drawable) {
        this.drawable = drawable;
    }
}

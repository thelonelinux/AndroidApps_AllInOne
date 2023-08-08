package com.example.myfavouritesapp.AudioRecorderActivity;

/**
 * POJO for the voiceRecorder.
 */

public class Recording {

    String Uri, fileName;
    boolean isPlaying = false;
    boolean isSelected;


    public Recording(String uri, String fileName, boolean isPlaying) {
        Uri = uri;
        this.fileName = fileName;
        this.isPlaying = isPlaying;

    }

    public Recording(String uri, String fileName, boolean isPlaying,boolean isSelected) {
        Uri = uri;
        this.fileName = fileName;
        this.isPlaying = isPlaying;
        this.isSelected=isSelected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public String getUri() {
        return Uri;
    }

    public String getFileName() {
        return fileName;
    }

    public boolean isPlaying() {
        return isPlaying;
    }

    public void setPlaying(boolean playing){
        this.isPlaying = playing;
    }
}

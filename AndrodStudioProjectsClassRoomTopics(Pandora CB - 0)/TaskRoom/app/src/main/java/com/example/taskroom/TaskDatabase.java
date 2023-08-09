package com.example.taskroom;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Task.class,SubTask.class}, version = 4)
public abstract class TaskDatabase extends RoomDatabase{

    public abstract TaskDao getTaskDao();

}

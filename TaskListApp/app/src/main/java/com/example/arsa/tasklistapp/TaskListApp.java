package com.example.arsa.tasklistapp;

import android.app.Application;
import android.content.Context;


public class TaskListApp extends Application {

    private static TaskListApp taskListApp;

    public static Context getAppContext() {
        return taskListApp.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        taskListApp = this;
    }
}

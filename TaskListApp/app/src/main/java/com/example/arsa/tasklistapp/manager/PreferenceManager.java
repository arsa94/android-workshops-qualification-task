package com.example.arsa.tasklistapp.manager;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.arsa.tasklistapp.TaskListApp;
import com.example.arsa.tasklistapp.model.Task;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class PreferenceManager {


    private static final String TASK_LIST_APP = "TaskListApp";

    private static final String TASKS = "Tasks";

    private static PreferenceManager ourInstance = new PreferenceManager();

    public static PreferenceManager getInstance() {
        return ourInstance;
    }

    private final SharedPreferences sharedPreferences;

    private final Gson gson = new Gson();

    private PreferenceManager() {
        sharedPreferences = TaskListApp.getAppContext().getSharedPreferences(TASK_LIST_APP, Context.MODE_PRIVATE);
    }

    public List<Task> getTasks(){
        Type collectionType = new TypeToken<List<Task>>() {}.getType();
        List<Task> tasks = gson.fromJson(sharedPreferences.getString(TASKS, ""), collectionType);
        if(tasks == null){
            tasks = new ArrayList<>();
        }
        return tasks;
    }


    public void saveTasks(List<Task> tasks) {
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TASKS, gson.toJson(tasks));
        editor.apply();
    }

}

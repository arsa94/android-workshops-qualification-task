package com.example.arsa.tasklistapp.api;


import com.example.arsa.tasklistapp.manager.PreferenceManager;
import com.example.arsa.tasklistapp.model.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public TaskService(){

    }

    public List<Task> getTasks(){
        return PreferenceManager.getInstance().getTasks();
    }

    public Task getTask(String taskName){
        for(Task task: getTasks()){
            if(task.getName().equals(taskName)){
                return task;
            }
        }
        return null;
    }

    public void addTask(Task newTask){
        List<Task> tasks = getTasks();
        tasks.add(newTask);
        PreferenceManager.getInstance().saveTasks(tasks);
    }

    public void markTaskAsDone(String taskName){
        List<Task> tasks = getTasks();
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).getName().equals(taskName)){
                tasks.get(i).setDone(true);
                PreferenceManager.getInstance().saveTasks(tasks);
                break;
            }
        }

    }

    public void removeTask(String taskName){
        List<Task> tasks = getTasks();
        for(int i=0; i<tasks.size(); i++){
            if(tasks.get(i).getName().equals(taskName)){
                tasks.remove(i);
                PreferenceManager.getInstance().saveTasks(tasks);
                break;
            }
        }
    }

    public List<Task> getToDoTasks(){
        final List<Task> allTasks = getTasks();

        List<Task> toDoTasks = new ArrayList<>();

        for (Task t: allTasks) {
            if(!t.isDone()){
                toDoTasks.add(t);
            }
        }

        return toDoTasks;
    }

    public List<Task> getDoneTasks(){
        final List<Task> allTasks = getTasks();

        List<Task> doneTasks = new ArrayList<>();

        for (Task t: allTasks) {
            if(t.isDone()){
                doneTasks.add(t);
            }
        }

        return doneTasks;
    }

    public boolean checkIfTitleExists(String taskName){
        for(Task t: getTasks()){
            if(t.getName().equals(taskName)){
                return true;
            }
        }
        return false;
    }

}

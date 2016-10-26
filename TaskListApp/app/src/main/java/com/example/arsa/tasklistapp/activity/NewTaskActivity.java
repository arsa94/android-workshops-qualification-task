package com.example.arsa.tasklistapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arsa.tasklistapp.R;
import com.example.arsa.tasklistapp.api.TaskService;
import com.example.arsa.tasklistapp.model.Task;

public class NewTaskActivity extends AppCompatActivity {

    private EditText taskName;
    private EditText taskDescription;
    private TaskService taskService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);

        taskService = new TaskService();

        taskName = (EditText) findViewById(R.id.task_name);
        taskDescription = (EditText) findViewById(R.id.task_description);

        final Button newTaskButton = (Button) findViewById(R.id.add);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createTask();
            }
        });
    }

    private void createTask(){
        if(taskName.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),
                    "Task must have title." , Toast.LENGTH_LONG)
                    .show();
        }else if(taskService.checkIfTitleExists(taskName.getText().toString())){
            Toast.makeText(getApplicationContext(),
                    "Task title must be unique." , Toast.LENGTH_LONG)
                    .show();
        }else{
            Task newTask = new Task(taskName.getText().toString(), taskDescription.getText().toString(), false);
            taskService.addTask(newTask);
            finish();
            Toast.makeText(getApplicationContext(),
                    "Task "+newTask.getName()+" has been created" , Toast.LENGTH_LONG)
                    .show();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

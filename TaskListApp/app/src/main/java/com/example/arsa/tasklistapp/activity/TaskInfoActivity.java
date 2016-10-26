package com.example.arsa.tasklistapp.activity;

import android.content.DialogInterface;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import com.example.arsa.tasklistapp.R;
import com.example.arsa.tasklistapp.api.TaskService;
import com.example.arsa.tasklistapp.model.Task;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TaskInfoActivity extends AppCompatActivity {

    private EditText taskName;
    private EditText taskDescription;

    private Button doneButton;
    private Button removeButton;

    private Task task;

    private TaskService taskService;

    private String selectedTaskName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_info);

        taskService = new TaskService();
        selectedTaskName = getIntent().getStringExtra("task_name");
        task = taskService.getTask(selectedTaskName);

        taskName = (EditText) findViewById(R.id.task_name);
        taskName.setText(task.getName());
        taskName.setFocusable(false);
        taskDescription = (EditText) findViewById(R.id.task_description);
        taskDescription.setText(task.getDescription());
        taskDescription.setFocusable(false);
        doneButton = (Button) findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                markTaskAsDone();
            }
        });

        removeButton = (Button) findViewById(R.id.remove_button);
        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeTask();
            }
        });

        if(task.isDone()){
            doneButton.setEnabled(false);
        }
    }

    private void markTaskAsDone(){
        taskService.markTaskAsDone(task.getName());
        doneButton.setEnabled(false);
        finish();
        Toast.makeText(getApplicationContext(),
                "Task "+task.getName()+" is marked as DONE" , Toast.LENGTH_LONG)
                .show();
    }

    private void removeTask(){
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        Toast.makeText(getApplicationContext(),
                                "Task "+task.getName()+" has been removed" , Toast.LENGTH_LONG)
                                .show();
                        taskService.removeTask(selectedTaskName);
                        finish();
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked
                        break;
                }
            }
        };

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to delete this task?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

package com.example.arsa.tasklistapp.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import com.example.arsa.tasklistapp.R;
import com.example.arsa.tasklistapp.activity.TaskInfoActivity;
import com.example.arsa.tasklistapp.adapter.TasksAdapter;
import com.example.arsa.tasklistapp.api.TaskService;
import com.example.arsa.tasklistapp.model.Task;

public class TasksToDoFragment extends Fragment {

    private View view;
    private ListView listView;

    private TaskService taskService;

    public TasksToDoFragment() {
        taskService = new TaskService();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_tasks_to_do, container, false);

        listView = (ListView) view.findViewById(R.id.list_view);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Task  selectedTask    = (Task) listView.getItemAtPosition(position);

                final Intent intent = new Intent(TasksToDoFragment.this.getActivity(), TaskInfoActivity.class);
                intent.putExtra("task_name", selectedTask.getName());

                startActivity(intent);

            }

        });

        initList();

        return view;
    }

    private void initList() {
        final TasksAdapter adapter = new TasksAdapter(getActivity(), taskService.getToDoTasks());
        listView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        initList();
    }
}

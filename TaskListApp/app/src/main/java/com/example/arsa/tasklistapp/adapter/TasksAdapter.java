package com.example.arsa.tasklistapp.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.arsa.tasklistapp.R;
import com.example.arsa.tasklistapp.model.Task;

import java.util.List;



/**
 * {@link BaseAdapter Adapter} that provides a data source to a {@link android.widget.ListView ListView}.
 * Created by Alex on 10/24/16.
 */

public class TasksAdapter extends BaseAdapter {

    private final List<Task> tasks;

    private final LayoutInflater layoutInflater;

    private final Context context;

    public TasksAdapter(Context context, List<Task> tasks) {
        this.tasks = tasks;
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.item_task, parent, false);

            viewHolder.taskName = (TextView) convertView.findViewById(R.id.task_name);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        final Task task = (Task) getItem(position);
        viewHolder.taskName.setText(task.getName());

        return convertView;
    }


    private static class ViewHolder {

        TextView taskName;
    }
}

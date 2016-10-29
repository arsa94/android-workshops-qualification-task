package com.example.arsa.tasklistapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.arsa.tasklistapp.R;
import com.example.arsa.tasklistapp.adapter.TabAdapter;

public class NavigationActivity extends AppCompatActivity {

    FloatingActionButton newTaskButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        initTabs();

        newTaskButton = (FloatingActionButton) findViewById(R.id.new_task_button);

        newTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent = new Intent(NavigationActivity.this, NewTaskActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initTabs() {
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        final ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new TabAdapter(getSupportFragmentManager(), this));
        tabLayout.setupWithViewPager(pager);
    }
}

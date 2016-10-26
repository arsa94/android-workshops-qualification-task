package com.example.arsa.tasklistapp.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.arsa.tasklistapp.fragment.TasksDoneFragment;
import com.example.arsa.tasklistapp.fragment.TasksToDoFragment;

import java.util.ArrayList;
import java.util.List;

import com.example.arsa.tasklistapp.R;


public class TabAdapter extends FragmentPagerAdapter {


    private final List<Fragment> fragments = new ArrayList<>();

    private final Context context;

    public TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
        fragments.add(new TasksToDoFragment());
        fragments.add(new TasksDoneFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0){
            return "To Do";
        }else if(position == 1){
            return "Done";
        }
        return "";
    }
}

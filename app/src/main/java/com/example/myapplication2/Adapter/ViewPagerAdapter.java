package com.example.myapplication2.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication2.fragment.TabNews;
import com.example.myapplication2.fragment.TabThongBao;
import com.example.myapplication2.fragment.TabUser;
import com.example.myapplication2.fragment.SchedulesFrag;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new SchedulesFrag();
            case 1:
                return new TabNews();
            case 2:
                return new TabThongBao();
            case 3:
                return new TabUser();
            default:
                return new SchedulesFrag();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}

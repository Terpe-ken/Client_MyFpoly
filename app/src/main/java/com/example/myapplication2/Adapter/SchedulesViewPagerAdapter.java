package com.example.myapplication2.Adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.myapplication2.fragment.SchedulesFrag;
import com.example.myapplication2.fragment.TabExam;
import com.example.myapplication2.fragment.TabSchedules;

public class SchedulesViewPagerAdapter extends FragmentStatePagerAdapter {
    public SchedulesViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabSchedules();
            case 1:
                return new TabExam();
            default:
                return new SchedulesFrag();
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Lịch Học";
            case 1:
                return "Lịch Thi";
            default:
                return "Lịch Học";
        }
    }
}

package com.example.myapplication2.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapplication2.fragment.SchedulesFrag;
import com.example.myapplication2.fragment.TabNews;
import com.example.myapplication2.fragment.TabThongBao;
import com.example.myapplication2.fragment.TabUser;

public class ViewNe extends FragmentPagerAdapter {

    public ViewNe(@NonNull FragmentManager fm) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
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

//    @Override
//    public CharSequence getPageTitle(int position) {
//        switch (position) {
//            case 0:
//                return "Tab0";
//            case 1:
//                return"Tab1";
//            case 2:
//                return"Tab2";
//            case 3:
//                return "Tab3";
//            default:
//                return null;
//        }
//    }

}

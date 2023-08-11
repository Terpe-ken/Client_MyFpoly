package com.example.myapplication2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.myapplication2.Adapter.ViewNe;
import com.example.myapplication2.Adapter.ViewPagerAdapter;
import com.example.myapplication2.fragment.TabUser;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = findViewById(R.id.viewPager);
        //tabLayout = findViewById(R.id.tabLayout);

//        TabLayout.Tab tab1 = tabLayout.newTab();
//        tab1.setIcon(R.drawable.chuong); // Thay ic_tab_icon_1 bằng tên tập tin biểu tượng của bạn
//        tabLayout.addTab(tab1);
//
//        TabLayout.Tab tab2 = tabLayout.newTab();
//        tab2.setIcon(R.drawable.chuong); // Thay ic_tab_icon_2 bằng tên tập tin biểu tượng của bạn
//        tabLayout.addTab(tab2);
//
//        TabLayout.Tab tab3 = tabLayout.newTab();
//        tab1.setIcon(R.drawable.chuong); // Thay ic_tab_icon_1 bằng tên tập tin biểu tượng của bạn
//        tabLayout.addTab(tab3);
//
//        TabLayout.Tab tab4 = tabLayout.newTab();
//        tab2.setIcon(R.drawable.chuong); // Thay ic_tab_icon_2 bằng tên tập tin biểu tượng của bạn
//        tabLayout.addTab(tab4);


        SetUpViewPager();
        bottomNavigationView = findViewById(R.id.bottomNavigation);
        //tabLayout.setupWithViewPager(viewPager);

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_schedules) {
                    viewPager.setCurrentItem(0);
                } else if (itemId == R.id.nav_news) {
                    viewPager.setCurrentItem(1);
                } else if (itemId == R.id.nav_notification) {
                    viewPager.setCurrentItem(2);
                } else if (itemId == R.id.nav_profile) {
                    viewPager.setCurrentItem(3);
                }
                return true;
            }
        });
    }
//    private void SetUpViewPager(int id) {
//        // Tạo adapter cho ViewPager và thêm các fragment vào đây
//        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//
//        // Tạo Bundle và truyền ID vào fragment tương ứng
//        Bundle bundle = new Bundle();
//        bundle.putInt("id", id);
//
//        TabUser scheduleFragment = new TabUser();
//        scheduleFragment.setArguments(bundle);
//        viewPagerAdapter.addFragment(scheduleFragment, "Schedules");
//
//        // Tương tự với các fragment khác...
//
//        viewPager.setAdapter(viewPagerAdapter);
//    }
    public void SetUpViewPager(){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdapter);
    }
    public void SetUpViewPagerne(){
        ViewNe viewNe = new ViewNe(getSupportFragmentManager());
        viewPager.setAdapter(viewNe);
    }
}
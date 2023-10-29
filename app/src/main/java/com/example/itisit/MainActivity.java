package com.example.itisit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private HistoryFragment historyFragment = new HistoryFragment();
    private AboutFragment aboutFragment = new AboutFragment();


    private ContentCourseFragment contentCourseFragment = new ContentCourseFragment();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        setTitle("ITISIT");

        bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, homeFragment)
                                .commit();
                        return true;

                    case R.id.current_course_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, historyFragment)
                                .commit();
                        return true;
                    case R.id.about_btn:

                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.fragment1, aboutFragment)
                                .commit();
                        return true;

                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.home_btn);
    }

    public void click_start_content_course(View view) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1, contentCourseFragment)
                .addToBackStack(null)
                .commit();
    }


}
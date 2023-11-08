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

    private Course1_Theory_Fragment course1_theory_fragment = new Course1_Theory_Fragment();

    private Course1_Test_Fragment course1_test_fragment = new Course1_Test_Fragment();





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

                        if(Current_Fragment.now_fragment == 0)
                        {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment1, homeFragment)
                                    .commit();
                            return true;
                        }
                        else if(Current_Fragment.now_fragment == 1)
                        {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment1, contentCourseFragment)
                                    .commit();
                            return true;
                        }
                        else if(Current_Fragment.now_fragment == 2)
                        {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment1, course1_theory_fragment)
                                    .commit();
                            return true;
                        }
                        else if(Current_Fragment.now_fragment == 3)
                        {
                            getSupportFragmentManager()
                                    .beginTransaction()
                                    .replace(R.id.fragment1, course1_test_fragment)
                                    .commit();
                            return true;
                        }


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
        Current_Fragment.now_fragment = 1;
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1, contentCourseFragment)
                .addToBackStack(null)
                .commit();
    }


}
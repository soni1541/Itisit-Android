package com.example.itisit;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private HomeFragment homeFragment = new HomeFragment();
    private CourseFragment courseFragment = new CourseFragment();
    private AboutFragment aboutFragment = new AboutFragment();


    private ContentCourseFragment contentCourseFragment = new ContentCourseFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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
                                .replace(R.id.fragment1, courseFragment)
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
                .commit();
    }

    public void click_hide_content(View view) {
        LinearLayout content_course = findViewById(R.id.linear_layout_content_course1);
        ImageButton btn_hide = findViewById(R.id.imageButton_hide);

        if(content_course.getVisibility() == View.VISIBLE) {
            content_course.setVisibility(View.GONE);
            btn_hide.setImageResource(R.drawable.circle_down);
        }
        else {
            content_course.setVisibility(View.VISIBLE);
            btn_hide.setImageResource(R.drawable.circle_up);
        }
    }
    public void click_hide_content2(View view) {
        LinearLayout content_course = findViewById(R.id.linear_layout_content_course2);
        ImageButton btn_hide = findViewById(R.id.imageButton_hide2);

        if(content_course.getVisibility() == View.VISIBLE) {
            content_course.setVisibility(View.GONE);

            btn_hide.setImageResource(R.drawable.circle_down);
        }
        else {
            content_course.setVisibility(View.VISIBLE);
            btn_hide.setImageResource(R.drawable.circle_up);
        }
    }
    public void click_hide_content3(View view) {
        LinearLayout content_course = findViewById(R.id.linear_layout_content_course3);
        ImageButton btn_hide = findViewById(R.id.imageButton_hide3);

        if(content_course.getVisibility() == View.VISIBLE) {
            content_course.setVisibility(View.GONE);
            btn_hide.setImageResource(R.drawable.circle_down);
        }
        else {
            content_course.setVisibility(View.VISIBLE);
            btn_hide.setImageResource(R.drawable.circle_up);
        }
    }
}
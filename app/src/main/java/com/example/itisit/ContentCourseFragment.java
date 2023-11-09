package com.example.itisit;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import android.view.View.OnClickListener;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ContentCourseFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ContentCourseFragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private LinearLayout content_course1;
    private LinearLayout content_course2;
    private LinearLayout content_course3;

    private Course1_Theory_Fragment course1_theory_fragment = new Course1_Theory_Fragment();

    private Course2_Theory_Fragment course2_theory_fragment = new Course2_Theory_Fragment();

    Current_Course course_now;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ContentCourseFragment() {
        // Required empty public constructor
        course_now = new Current_Course();
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ContentCourseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ContentCourseFragment newInstance(String param1, String param2) {
        ContentCourseFragment fragment = new ContentCourseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setTitle("ОСНОВЫ С++");
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowHomeEnabled(true);

        View view = inflater.inflate(R.layout.fragment_content_course, container, false);



        ImageButton b1 = (ImageButton) view.findViewById(R.id.imageButton_hide1);
        ImageButton b2 = (ImageButton) view.findViewById(R.id.imageButton_hide2);
        ImageButton b3 = (ImageButton) view.findViewById(R.id.imageButton_hide3);

        Button btn_start_course1 = (Button) view.findViewById(R.id.button_start_course1);
        Button btn_start_course2 = (Button) view.findViewById(R.id.button_start_course2);
        Button btn_start_course3 = (Button) view.findViewById(R.id.button_start_course3);

        content_course1 = (LinearLayout) view.findViewById(R.id.linear_layout_content_course1);
        content_course2 = (LinearLayout) view.findViewById(R.id.linear_layout_content_course2);
        content_course3 = (LinearLayout) view.findViewById(R.id.linear_layout_content_course3);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        btn_start_course1.setOnClickListener(this);
        btn_start_course2.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.imageButton_hide1:
            {
                ImageButton btn_hide = (ImageButton) view.findViewById(R.id.imageButton_hide1);
                if(content_course1.getVisibility() == View.VISIBLE) {
                    content_course1.setVisibility(View.GONE);
                    btn_hide.setImageResource(R.drawable.circle_down);
                }
                else {
                    content_course1.setVisibility(View.VISIBLE);
                    btn_hide.setImageResource(R.drawable.circle_up);
                }
                break;
            }
            case R.id.imageButton_hide2:
            {
                ImageButton btn_hide = (ImageButton) view.findViewById(R.id.imageButton_hide2);
                if(content_course2.getVisibility() == View.VISIBLE) {
                    content_course2.setVisibility(View.GONE);
                    btn_hide.setImageResource(R.drawable.circle_down);
                }
                else {
                    content_course2.setVisibility(View.VISIBLE);
                    btn_hide.setImageResource(R.drawable.circle_up);
                }
                break;
            }
            case R.id.imageButton_hide3:
            {
                ImageButton btn_hide = (ImageButton) view.findViewById(R.id.imageButton_hide3);
                if(content_course3.getVisibility() == View.VISIBLE) {
                    content_course3.setVisibility(View.GONE);
                    btn_hide.setImageResource(R.drawable.circle_down);
                }
                else {
                    content_course3.setVisibility(View.VISIBLE);
                    btn_hide.setImageResource(R.drawable.circle_up);
                }
                break;
            }

            case R.id.button_start_course1:
            {

                if(course_now.name_content_course_now != "Введение в С++")
                {
                    course_now.name_course_now = "ОСНОВЫ С++";
                    course_now.name_content_course_now = "Введение в С++";
                    Current_Course course = new Current_Course();
                    course.name_course_now = "ОСНОВЫ С++";
                    course.name_content_course_now = "Введение в С++";
                    History_Courses.currentCourses.add(course);
                }

                Current_Fragment.now_fragment = 2;


                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment1, course1_theory_fragment)
                        .addToBackStack(null)
                        .commit();

               break;
            }
            case R.id.button_start_course2:
            {
                if(course_now.name_content_course_now != "Переменные")
                {
                    course_now.name_course_now = "ОСНОВЫ С++";
                    course_now.name_content_course_now = "Переменные";
                    Current_Course course = new Current_Course();
                    course.name_course_now = "ОСНОВЫ С++";
                    course.name_content_course_now = "Переменные";
                    History_Courses.currentCourses.add(course);
                }


                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment1, course2_theory_fragment)
                        .addToBackStack(null)
                        .commit();

                break;
            }

        }

    }
}
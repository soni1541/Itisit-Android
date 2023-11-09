package com.example.itisit;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HistoryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoryFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private LinearLayout linearLayout_history;

    public HistoryFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoryFragment newInstance(String param1, String param2) {
        HistoryFragment fragment = new HistoryFragment();
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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_history, container, false);

        linearLayout_history = (LinearLayout) view.findViewById(R.id.linear_layout_history);

        List<Current_Course> courses_history = History_Courses.currentCourses;

        for(Current_Course course_now : courses_history)
        {
            TextView name_course_now_text = new TextView(this.getContext());
            name_course_now_text.setText(course_now.name_course_now);

            //name_course_now_text.setTypeface(getResources().getFont(R.font.source_code_pro_bold));


            TextView name_content_course_now_text = new TextView(this.getContext());
            name_content_course_now_text.setText(course_now.name_content_course_now);

            LinearLayout linearLayout_course = new LinearLayout(this.getContext());

            linearLayout_course.addView(name_course_now_text);
            linearLayout_course.addView(name_content_course_now_text);
            linearLayout_course.setOrientation(LinearLayout.VERTICAL);

            linearLayout_course.setPadding(0,0,0,60);

            linearLayout_history.addView(linearLayout_course);
        }





        return view;
    }
}
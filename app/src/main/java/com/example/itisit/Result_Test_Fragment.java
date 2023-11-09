package com.example.itisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Result_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Result_Test_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Result_Test_Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Result_Test_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Result_Test_Fragment newInstance(String param1, String param2) {
        Result_Test_Fragment fragment = new Result_Test_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_result__test_, container, false);

        Button exit_course = (Button) view.findViewById(R.id.button_exit_course);

        TextView textView_content_course_now = (TextView) view.findViewById(R.id.textView_content_course);
        textView_content_course_now.setText("Вы прошли тему \"" + History_Courses.currentCourses.get(History_Courses.currentCourses.size() - 1).name_content_course_now + "\"");

        exit_course.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.button_exit_course: {
                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment1, new ContentCourseFragment())
                        .addToBackStack(null)
                        .commit();

                break;
            }
        }
    }
}
package com.example.itisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course2_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course2_Test_Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private String[] test_headers;
    private String[][] test_questions;

    private int current_index_question;

    public Course2_Test_Fragment() {
        // Required empty public constructor

        test_headers = new String[]{
                //0
                "В чём плюсы С++?",
                //1
                "",
                //2
                "Где правильно инициализирована переменная?",
                //3
                "Структура проекта",
                //4
                "Структура программы",
                //5
                "Структура программы",
                //6
                "Синтаксис С++"
        };

        test_questions = new String[][]
        {
                {
                        "int a",
                        "int a;",
                        "int a = 5;",
                        "int a = 5"
                },
                {

                }
        };

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course2_Test_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Course2_Test_Fragment newInstance(String param1, String param2) {
        Course2_Test_Fragment fragment = new Course2_Test_Fragment();
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
        return inflater.inflate(R.layout.fragment_course2__test_, container, false);
    }
}
package com.example.itisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course1_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course1_Test_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView header_test;

    private LinearLayout question_test;

    private ImageButton b_forward;
    private ImageButton b_back;

    private String[] test_headers;
    private String[][] test_questions;

    private int current_index_question;

    private ImageView image_result;
    private TextView text_check_answer;

    public Course1_Test_Fragment() {
        // Required empty public constructor

        test_headers = new String[]{
                //0
                "В чём плюсы С++?",
                //1
                "Один из основных инструментов, которым пользуются программисты:",
                //2
                "В каком файле находиться исходный код?",
                //3
                "Как выглядит начало любой программы?",
                //4
                "Каждая инструкция должна заканчиваться:",
                //5
                "Где правильно написана функция ввода?",
                //6
                "Выберите однострочный комментарий:",


        };

        test_questions = new String[][]
        {
                //0
                {
                    "Универсальность",
                    "Производительность",
                    "Можно писать как низкоуровневые, так и высокоуровневые коды",
                    "Использование готовых библиотек и конструкций",
                },
                //1
                {
                    "Драйверы",
                    "Среды разработки (IDE)",
                    "Утилиты"
                },
                {
                    "source.cpp",
                    "windows.h",
                    "source.h"
                },
                //2
                {
                    "include<iostream>\nusing namespace;\n int main()\n{\n}",
                    "int main()\n{\n}",
                    "#include<iostream>\nusing namespace std;\n int main()\n{\n}"
                },
                //3
                {
                        ";",
                        ":",
                        "."
                },
                //4
                {
                    "int a;\ncin a;",
                    "int a;\ncin >> a;",
                    "int a;\ncin << a;"
                },
                //5
                {
                        "## я комментарий",
                        "** я комментарий",
                        "// я комментарий"
                }
        };

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course1_Test_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Course1_Test_Fragment newInstance(String param1, String param2) {
        Course1_Test_Fragment fragment = new Course1_Test_Fragment();
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

        View view = inflater.inflate(R.layout.fragment_course1__test_, container, false);

        b_forward = (ImageButton) view.findViewById(R.id.imageButton_forward);
        b_back = (ImageButton) view.findViewById(R.id.imageButton_back);

        header_test = (TextView) view.findViewById(R.id.textView__header_question);
        question_test = (LinearLayout) view.findViewById(R.id.linear_layout_content_test);

        current_index_question = 0;

        image_result = (ImageView) view.findViewById(R.id.imageView_result);
        text_check_answer = (TextView) view.findViewById(R.id.textView_check_answer);

        show_action(view);


        b_forward.setOnClickListener(this);
        b_back.setOnClickListener(this);

        return view;
    }

    public void show_action(View view){
        if(current_index_question == 0)
        {
            b_back.setVisibility(View.INVISIBLE);
            b_forward.setVisibility(View.INVISIBLE);

            text_check_answer.setVisibility(View.INVISIBLE);

            image_result.setVisibility(View.GONE);
        }

        // Отображение теста (заголовка и выбора ответов)
        if(current_index_question >= 0 &&
                current_index_question < test_headers.length)
        {
            header_test.setText(test_headers[current_index_question]);

            for(int answer = 0; answer < test_questions[current_index_question].length; answer ++)
            {
                String text_question = test_questions[current_index_question][answer];
                CheckBox checkBox_question = null;
                checkBox_question.setText(text_question);
            }

        }
        else if (current_index_question == test_headers.length)
        {
            // направить на тест
        }
        else
        {
            Log.d("Ошибка", "Выход за массив");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imageButton_forward: {

                ++current_index_question;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
            case R.id.imageButton_back: {

                --current_index_question;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
        }
    }
}
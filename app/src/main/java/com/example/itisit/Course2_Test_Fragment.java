package com.example.itisit;

import android.graphics.Color;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course2_Test_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course2_Test_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private TextView header_test;

    private LinearLayout content_question_test;

    private ImageButton b_forward;
    private ImageButton b_back;
    private Button b_check;
    private ImageButton b_theory;

    private List<Question> questions;

    private List<CheckBox> checkBoxes;
    private List<RadioButton> radioButtons;

    private int current_index_question;

    private ImageView image_result;
    private TextView text_check_answer;

    private ConstraintLayout constraintLayout;

    private Result_Test_Fragment result_test_fragment = new Result_Test_Fragment();


    public Course2_Test_Fragment() {
        // Required empty public constructor
        questions = new ArrayList<Question>();

        current_index_question = 0;

        Question q1 = new Question();
        q1.header = "Где правильно инициализирована переменная?";
        q1.text_answers = new ArrayList<String>();
        q1.text_answers.add("int a");
        q1.text_answers.add("double a = true;");
        q1.text_answers.add("int a = 5;");
        q1.text_answers.add("a = 3;");
        q1.id_answers = new ArrayList<Integer>();
        q1.id_answers.add(2);
        questions.add(q1);

        Question q2 = new Question();
        q2.header = "int a,b; - объявление каких переменных? ";
        q2.text_answers = new ArrayList<String>();
        q2.text_answers.add("Вещественных");
        q2.text_answers.add("Целочисленных");
        q2.text_answers.add("Логических");
        q2.id_answers = new ArrayList<Integer>();
        q2.id_answers.add(1);
        questions.add(q2);

        Question q3 = new Question();
        q3.header = "Какие имена переменных являются правильными?";
        q3.text_answers = new ArrayList<String>();
        q3.text_answers.add("1Ва");
        q3.text_answers.add("D234");
        q3.text_answers.add(" _gh");
        q3.text_answers.add("D(f)");
        q3.id_answers = new ArrayList<Integer>();
        q3.id_answers.add(1);
        q3.id_answers.add(2);
        questions.add(q3);

        Question q4 = new Question();
        q4.header = "Какой из вариантов не верен?";
        q4.text_answers = new ArrayList<String>();
        q4.text_answers.add("bool a = 1;");
        q4.text_answers.add("bool b = 0;");
        q4.text_answers.add("bool c = 'k';");
        q4.text_answers.add("bool d = 3.4;");
        q4.text_answers.add("Все верны");
        q4.text_answers.add("Все неверны");
        q4.id_answers = new ArrayList<Integer>();
        q4.id_answers.add(4);
        questions.add(q4);

        Question q5 = new Question();
        q5.header = "Какие два выражения верны для переменных в C++?";
        q5.text_answers = new ArrayList<String>();
        q5.text_answers.add("Переменные должны иметь тип данных");
        q5.text_answers.add("Переменные должны быть объявлены до их использования");
        q5.text_answers.add("Переменные не имеют имён");
        q5.text_answers.add("Переменные являются директивами препроцессора");
        q5.id_answers = new ArrayList<Integer>();
        q5.id_answers.add(0);
        q5.id_answers.add(1);
        questions.add(q5);

        Question q6 = new Question();
        q6.header = "Какой результат будет выведен? \n" +
                "int x = 24;\n" +
                "int y;\n" +
                "y = x — 13;\n" +
                "cout << y;";
        q6.text_answers = new ArrayList<String>();
        q6.text_answers.add("24");
        q6.text_answers.add("13");
        q6.text_answers.add("Мусор");
        q6.text_answers.add("11");
        q6.id_answers = new ArrayList<Integer>();
        q6.id_answers.add(3);
        questions.add(q6);

        Question q7 = new Question();
        q7.header = "Какой результат будет выведен?\n" +
                "int x = 20 / 3;\n" +
                "cout << x;";
        q7.text_answers = new ArrayList<String>();
        q7.text_answers.add("6");
        q7.text_answers.add("7");
        q7.text_answers.add("6.66");
        q7.text_answers.add("6.0");
        q7.id_answers = new ArrayList<Integer>();
        q7.id_answers.add(0);
        questions.add(q7);


        checkBoxes = new ArrayList<CheckBox>();
        radioButtons = new ArrayList<RadioButton>();

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
        View view = inflater.inflate(R.layout.fragment_course2__test_, container, false);

        b_forward = (ImageButton) view.findViewById(R.id.imageButton_forward);
        b_back = (ImageButton) view.findViewById(R.id.imageButton_back);
        b_theory = (ImageButton) view.findViewById(R.id.imageButton_theory);
        b_check = (Button) view.findViewById(R.id.button_check);

        header_test = (TextView) view.findViewById(R.id.textView__header_question);
        content_question_test = (LinearLayout) view.findViewById(R.id.linear_layout_content_test);

        current_index_question = 0;

        image_result = (ImageView) view.findViewById(R.id.imageView_result);
        text_check_answer = (TextView) view.findViewById(R.id.textView_check_answer);

        constraintLayout = (ConstraintLayout) view.findViewById(R.id.layout_test_course2);

        show_action(view);


        b_forward.setOnClickListener(this);
        b_back.setOnClickListener(this);
        b_theory.setOnClickListener(this);
        b_check.setOnClickListener(this);

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
                current_index_question < questions.size())
        {
            Question question_now = questions.get(current_index_question);


            b_check.setVisibility(View.VISIBLE);
            b_check.setText("ПРОВЕРИТЬ");
            b_check.setBackgroundColor(Color.BLACK);
            text_check_answer.setVisibility(View.INVISIBLE);
            b_back.setVisibility(View.INVISIBLE);
            b_forward.setVisibility(View.INVISIBLE);
            constraintLayout.setBackgroundColor(Color.parseColor("#5B9C34"));
            image_result.setVisibility(View.INVISIBLE);


            header_test.setText(question_now.header);

            RadioGroup radioGroup = new RadioGroup(this.getContext());

            for(int answer = 0; answer < question_now.text_answers.size(); answer ++)
            {
                String text_question = question_now.text_answers.get(answer);
                if(question_now.id_answers.size() > 1) {
                    CheckBox checkBox_question = new CheckBox(getContext());
                    checkBox_question.setId(answer);
                    checkBox_question.setText(text_question);
                    checkBoxes.add(checkBox_question);
                    content_question_test.addView(checkBox_question);
                }
                else if (question_now.id_answers.size() == 1) {

                    RadioButton radioButton_question = new RadioButton(getContext());
                    radioButton_question.setId(answer);
                    radioButton_question.setText(text_question);
                    if(radioGroup.getParent() != null) {
                        ((ViewGroup)radioGroup.getParent()).removeView(radioGroup); // <- fix
                    }
                    radioGroup.addView(radioButton_question);
                    radioButtons.add(radioButton_question);
                    content_question_test.addView(radioGroup);
                }
            }

        }
        else if (current_index_question == questions.size())
        {
            Current_Fragment.now_fragment = 1;
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment1, result_test_fragment)
                    .addToBackStack(null)
                    .commit();
            return;
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


                content_question_test.removeAllViews();
                checkBoxes.clear();
                radioButtons.clear();
                ++current_index_question;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
            case R.id.imageButton_back: {


                content_question_test.removeAllViews();
                checkBoxes.clear();
                radioButtons.clear();
                --current_index_question;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
            case R.id.button_check: {

                Log.d("START", "START CHECK");
                boolean result = true;

                Question question_now = questions.get(current_index_question);


                if(question_now.id_answers.size() > 1)
                {
                    Log.d("CHECKBOX", "Я в боксе");
                    for (CheckBox checkBox_question: checkBoxes)
                    {
                        int id_check_now = checkBox_question.getId();
                        if(checkBox_question.isChecked())
                        {
                            //Log.d("ID_CHECK_BOX", String.valueOf(checkBox_question.getId()));
                            if(questions.get(current_index_question).id_answers.contains(id_check_now))
                            {
                                //Правильно
                            }
                            else
                            {
                                //Неправильно
                                result = false;
                                break;
                            }
                        }
                        else
                        {
                            if(!questions.get(current_index_question).id_answers.contains(id_check_now))
                            {
                                //Правильно
                            }
                            else
                            {
                                //Неправильно
                                result = false;
                                break;
                            }
                        }
                    }
                }
                else if(question_now.id_answers.size() == 1)
                {
                    for (RadioButton radioButton_question: radioButtons) {
                        int id_check_now = radioButton_question.getId();
                        Log.d("RADIO size", String.valueOf(radioButtons.size()));
                        if (radioButton_question.isChecked()) {
                            Log.d("ID_RADIO", String.valueOf(id_check_now));
                            if (questions.get(current_index_question).id_answers.contains(id_check_now)) {
                                // id_кнопки  == правильный ответ
                                //Правильно
                            } else {
                                //Неправильно
                                result = false;
                                break;
                            }
                        } else {
                            if (!questions.get(current_index_question).id_answers.contains(id_check_now)) {
                                //Правильно
                            } else {
                                //Неправильно
                                result = false;
                                break;
                            }
                        }
                    }
                }

                if(result)
                {
                    b_check.setVisibility(View.INVISIBLE);
                    text_check_answer.setText("Всё верно! Молодец!\nДвигаемся дальше");
                    text_check_answer.setTextColor(Color.parseColor("#5B9C34"));
                    text_check_answer.setVisibility(View.VISIBLE);

                    if(current_index_question > 0)
                        b_back.setVisibility(View.VISIBLE);
                    b_forward.setVisibility(View.VISIBLE);

                    image_result.setImageResource(R.drawable.correct);
                    image_result.setVisibility(View.VISIBLE);

                    constraintLayout.setBackgroundColor(Color.parseColor("#5B9C34"));
                }
                else
                {
                    b_check.setText("Проверить ещё раз");
                    b_check.setBackgroundColor(Color.parseColor("#F35D78"));

                    image_result.setImageResource(R.drawable.incorrect);
                    image_result.setVisibility(View.VISIBLE);
                    constraintLayout.setBackgroundColor(Color.parseColor("#F35D78"));
                }
//
                break;
            }
            case R.id.imageButton_theory: {

                getParentFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment1, new Course1_Theory_Fragment())
                        .addToBackStack(null)
                        .commit();

                break;
            }
        }
    }
}
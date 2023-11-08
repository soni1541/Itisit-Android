package com.example.itisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course2_Theory_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course2_Theory_Fragment extends Fragment implements View.OnClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;


    private TextView header_theory;
    private TextView text_theory;

    private ImageButton b_forward;
    private ImageButton b_back;


    private TextView text_start_test;


    private String[] texts_headers;
    private String[] texts_theories;

    private int current_index_text;

    public Course2_Theory_Fragment() {
        // Required empty public constructor

        texts_headers = new String[]{
                //0
                "Что такое переменная?",
                //1
                "Определение переменной",
                //2
                "Именование переменной",
                //3
                "Стандартные типы данных",
                //4
                "Инициализация переменной",
                //5
                "Инициализация переменной",
                //6
                "Изменение значения"
        };

        texts_theories = new String[]{
                //0
                "ПЕРЕМЕННАЯ - это выделенная ячейка в памяти под определенный тип данных. \n\nСами же ячейки постоянно хранятся на компьютере пользователя. Их мы можем заполнять различными значениями, модифицировать и использовать в наших целях.",
                //1
                "Перед использованием любую переменную надо определить.\n\nСинтаксис определения переменной:\nТИП_переменной ИМЯ_переменной;\n\nПеременная имеет тип, имя и значение. Тип определяет, какие именно данные может хранить переменная.\n\n"+
                "Например, определение переменной:\n\n" +
                        "int sum;",
                //2
                "ИМЕНА переменных задаются следующим образом:\n" +
                        "\n" +
                        "- Имя переменной не может начинаться с цифры.\n\n" +
                        "- В имени переменной не может быть пробелов, а также специальных символов (вроде ; № # % или /).\n\n" +
                        "- Имя переменной не может совпадать с другими, ранее объявленными, именами (функций, переменных, стандартных операторов и т. п.).",

                //3
                "int - это целый тип, может хранить в себе только целые числа.\n\n" +
                "float - данный тип позволяет хранить не только целую часть, но и дробную.\n\n" +
                "double - данный тип имеет более высокую точность, чем float (позволяет хранить больше чисел после запятой).\n\n" +
                "char - в данный тип данных можно записывать отдельные символы (абсолютно любые).\n\n" +
                "bool - хранит в себе значения логического типа: “правду” - true, либо “ложь” - false.",
                //4
                "Присвоение переменной начального значения называется инициализацией.\n\n" +
                        "Виды инициализации:\n" +
                        "\n" +
                        "1. Нотация присваивания\n\n" +
                        "int age;\n" +
                        "age = 20;\n" +
                        "\n" +
                        "2. Функциональная нотация\n\n" +
                        "int age (38);\n" +
                        "\n" +
                        "3. Инициализация в фигурных скобках\n\n" +
                        "int age {38};\n",
                //5
                "Во всех трех случаях присваиваемое переменной значение может представлять сложное вычисляемое выражение. Например:\n\n" +
                        "int age1 {22 + 5};\n" +
                        "int age2 (22 + 5);\n" +
                        "int age3 = 22 + 5;\n\n" +
                "Можно сразу инициализировать несколько переменных:\n\n" +
                        "int age1 {22}, age2 (23), age3 = 24;",
                //6
                "Ключевой особенностью переменных является то, что мы можем изменять их значения:\n\n" +
                        "#include <iostream>\n" +
                        "int main()\n" +
                        "{\n" +
                        "  int age = 22;\n" +
                        "  std::cout << \"Age1 = \" << age;\n" +
                        "  age = 23;\n" +
                        "  std::cout << \"Age2 = \" << age;\n" +
                        "  age = 38;\n" +
                        "  std::cout << \"Age3 = \" << age;\n" +
                        "}\n\n" +
                "Результат программы:\n" +
                        "Age1 = 22\n" +
                        "Age2 = 23\n" +
                        "Age3 = 38"
        };

        current_index_text = 0;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course2_Theory_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Course2_Theory_Fragment newInstance(String param1, String param2) {
        Course2_Theory_Fragment fragment = new Course2_Theory_Fragment();
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

        View view = inflater.inflate(R.layout.fragment_course2__theory_, container, false);

        b_forward = (ImageButton) view.findViewById(R.id.imageButton_forward);
        b_back = (ImageButton) view.findViewById(R.id.imageButton_back);

        header_theory = (TextView) view.findViewById(R.id.textView_header);
        text_theory = (TextView) view.findViewById(R.id.textView_theory);


        text_start_test = (TextView) view.findViewById(R.id.textView_text_start_test);

        show_action(view);


        b_forward.setOnClickListener(this);
        b_back.setOnClickListener(this);

        current_index_text = 0;


        return view;
    }

    public void show_action(View view){
        if(current_index_text == 0)
        {
            b_back.setVisibility(View.INVISIBLE);
            b_forward.setVisibility(View.VISIBLE);

            text_start_test.setVisibility(View.GONE);
        }
        else if (current_index_text + 1 == texts_theories.length)
        {
            b_back.setVisibility(View.VISIBLE);
            b_forward.setVisibility(View.VISIBLE);

            text_start_test.setVisibility(View.VISIBLE);
        }
        else
        {
            b_back.setVisibility(View.VISIBLE);
            b_forward.setVisibility(View.VISIBLE);

            text_start_test.setVisibility(View.GONE);
        }

        // Отображение текстов теории (заголовка и текста)
        if(current_index_text >= 0 &&
                current_index_text < texts_theories.length)
        {
            header_theory.setText(texts_headers[current_index_text]);
            text_theory.setText(texts_theories[current_index_text]);
        }
        else if (current_index_text == texts_theories.length)
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

                ++current_index_text;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
            case R.id.imageButton_back: {

                --current_index_text;

                //Отображение положений кнопок
                show_action(view);

                break;
            }
        }
    }
}
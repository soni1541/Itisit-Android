package com.example.itisit;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Course1_Theory_Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Course1_Theory_Fragment extends Fragment implements View.OnClickListener {

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

    private Course1_Test_Fragment course1_test_fragment = new Course1_Test_Fragment();


    public Course1_Theory_Fragment() {
        // Required empty public constructor

        texts_headers = new String[]{
                //0
                "Кто такой С++?",
                //1
                "Почему С++?",
                //2
                "Среды разработки",
                //3
                "Структура проекта",
                //4
                "Структура программы",
                //5
                "Структура программы",
                //6
                "Синтаксис С++"
        };

        texts_theories = new String[]{
                //0
                "Язык программирования С++ представляет высокоуровневый компилируемый язык программирования общего назначения со статической типизацией, который подходит для создания самых различных приложений.\n\nЯзык возник в начале 1980-х годов, когда сотрудник фирмы Bell Labs Бьёрн Страуструп придумал ряд усовершенствований к языку C.",
                //1
                "На C++ можно писать НИЗКОУРОВНЕВЫЙ код, обращаясь к памяти напрямую. Или можно использовать ВЫСОКОУРОВНЕВЫЕ концепции вроде ООП и ФУНКЦИОНАЛЬНОЕ ПРОГРАММИРОВАНИЕ.\n\nВ C++ есть много высокоуровневых ИНСТРУМЕНТОВ, КОНСТРУКЦИЙ и БИБЛИОТЕК, что позволяет значительно ускорить разработку\n\nC++ даёт разработчикам столько возможностей, что на нём можно писать что угодно: от драйверов до сайтов.\n" +
                        "Также он не только УНИВЕРСАЛЬНЫЙ, но и очень ПРОИЗВОДИТЕЛЬНЫЙ.",
                //2
                "Среда разработки (IDE) — это программа или несколько программ, которые вы используете для создания программ.\n\nТоп 7 популярных IDE для программирования на С++:\n\n1. Microsoft Visual Studio.\n2. Xcode.\n3. NetBeans.\n4. Eclipse.\n5. CodeLite.\n6. Qt Creator.\n7. Code::Blocks.",
                //3
                "1. Header Files - предназначена для хранения заголовочных файлов с расширением .h\n" +
                "\n" +
                "2. Resource Files - предназначена для хранения файлов ресурсов, например, изображений\n" +
                "\n" +
                "3. Source Files - хранит файлы с исходным кодом\n\n\n" +
                "По умолчанию каталог Source Files содержит один файл с исходным кодом - MyApp.cpp\n(название проекта + расширение файла .cpp).",
                //4
                "Исходный код первой программы:\n\n\n" +
                "#include <iostream>\n\n" +
                        "using namespace std;\n\n" +
                        "int main()\n" +
                        "{\n" +
                        "   cout << \"Hello World\";\n\n" +
                        "   return 0;" +
                        "\n}",
                //5
                "Разберём код по строкам:\n\n\n" +
                "#include <iostream>\n\n" +
                        "// раскрытие пространства имен\n" +
                        "using namespace std;\n\n" +
                        "// основная функция, в которой начинается выполнение программы\n" +
                        "int main()\n" +
                        "{\n" +
                        "// вызов на экране сообщения «Hello World».\n" +
                        "cout << \"Hello World\";\n\n" +
                        "// завершение функции main() и возвращение значения 0 в вызывающий процесс.\n" +
                        "return 0;" +
                        "\n}",
                //6
                "Программа на C++ — это последовательность команд. Большинство команд должны заканчиваться ТОЧКОЙ С ЗАПЯТОЙ.\n\n" +
                "Структура программы формируется ФИГУРНЫМИ СКОБКАМИ, т.е. блоки функций, блоки if, циклов и т.п. указываются с помощью фигурных скобок.\n\n" +
                "ОТСТУПЫ в программе на C++ не имеют никакого значения для компилятора\n\n" +
                "Язык C++ чувствителен к РЕГИСТРУ: заглавные и маленькие буквы различаются."
        };

        current_index_text = 0;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Course1_Theory_Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Course1_Theory_Fragment newInstance(String param1, String param2) {
        Course1_Theory_Fragment fragment = new Course1_Theory_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_course1__theory_, container, false);

        b_forward = (ImageButton) view.findViewById(R.id.imageButton_forward);
        b_back = (ImageButton) view.findViewById(R.id.imageButton_back);

        header_theory = (TextView) view.findViewById(R.id.textView_header);
        text_theory = (TextView) view.findViewById(R.id.textView_theory);

        current_index_text = 0;

        text_start_test = (TextView) view.findViewById(R.id.textView_text_start_test);

        show_action(view);


        b_forward.setOnClickListener(this);
        b_back.setOnClickListener(this);

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
            getParentFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment1, course1_test_fragment)
                    .addToBackStack(null)
                    .commit();
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
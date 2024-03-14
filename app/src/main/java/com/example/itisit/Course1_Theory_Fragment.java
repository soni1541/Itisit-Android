package com.example.itisit;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Locale;

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


    private ImageButton micro;

    MediaPlayer mediaPlayer;

    private TextView header_theory;
    private TextView text_theory;

    private ImageButton b_forward;
    private ImageButton b_back;


    private TextView text_start_test;


    private String[] texts_headers;
    private String[] texts_theories;

    private String[] texts_headers_en;
    private String[] texts_theories_en;

    private int[] audio_texts;

    private int current_index_text;

    private Course1_Test_Fragment course1_test_fragment = new Course1_Test_Fragment();


    @SuppressLint("ResourceType")
    public Course1_Theory_Fragment() {
        // Required empty public constructor

            texts_headers_en = new String[]{
                    //0
                    "Who is C++?",
                    //1
                    "Why С++?",
                    //2
                    "Development environments",
                    //3
                    "Project structure",
                    //4
                    "Program structure",
                    //5
                    "Program structure",
                    //6
                    "The syntax of C++"
            };

            texts_theories_en = new String[]{
                    //0
                    "The C++ programming language is a high-level compiled general-purpose programming language with static typing, which is suitable for creating a wide variety of applications.The language originated in the early 1980s, when Bjorn Stroustrup, an employee of Bell Labs, came up with a number of improvements to the C language.",
                    //1
                    "In C++, you can write LOW-LEVEL code by accessing memory directly. Or you can use HIGH-LEVEL concepts like OOP and FUNCTIONAL PROGRAMMING.\\n\\n C++ has many high-level TOOLS, CONSTRUCTS and LIBRARIES, which allows you to significantly speed up development\\n\\nC++ gives developers so many opportunities that you can write anything on it: from drivers to websites.\\n\"+\n" +
                            "\" It is also not only VERSATILE, but also very PRODUCTIVE.",
                    //2
                    "A development environment (IDE) is a program or several programs that you use to create programs.\n\nTop 7 popular IDE for C++ programming:\n\n1. Microsoft Visual Studio.\n2. Xcode.\n3. NetBeans.\n4. Eclipse.\n5. CodeLite.\n6. Qt Creator.\n7. Code::Blocks.",
                    //3
                    "1. Header Files - designed to store header files with an extension.h\n"+
                            "\n"+
                            "2. Resource Files - designed to store resource files, such as images\n"+
                            "\n"+
                            "3. Source Files - stores source code files\n\n\n"+
                            "By default, the Source Files directory contains one source code file is MyApp.cpp\n(project name + .cpp file extension).",
                    //4
                    "The source code of the first program:\n\n\n" +
                            "#include <iostream>\n\n" +
                            "using namespace std;\n\n" +
                            "int main()\n" +
                            "{\n" +
                            " cout << \"Hello World\";\n\n" +
                            " return 0;" +
                            "\n}",
                    //5
                    "Let's analyze the code by lines:\n\n\n"+
                            "#include <iostream>\n\n"+
                            "// namespace disclosure\n"+
                            "using namespace std;\n\n"+
                            "// the main function in which the program execution begins\n"+
                            "int main()\n"+
                            "{\n"+
                            "// calling the message \"Hello World\" on the screen.\n"+
                            "cout <<\"Hello World\";\n\n"+
                            "// terminating the main() function and returning the value 0 to the calling process.\n" +
                            "return 0;" +
                            "\n}",
                    //6
                    "A C++ program is a sequence of commands. Most commands should end with a SEMICOLON.\n\n"+
                            " The program structure is formed by CURLY BRACKETS, i.e. function blocks, if blocks, loops, etc. are specified using curly brackets.\n\n" +
                            "INDENTATION in a C++ program has no meaning for the compiler\n\n"+
                            "The C++ language is CASE sensitive: uppercase and lowercase letters differ."
            };

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

        audio_texts = new int[]{
                //0
                R.raw.theory1_1,
                //1
                R.raw.theory1_2,
                //2
                R.raw.theory1_3,
                //3
                R.raw.theory1_4,
                //4
                R.raw.theory1_5,
                //5
                R.raw.theory1_6,
                //6
                R.raw.theory1_7
        };

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
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setTitle(getString(R.string.content_course1_name));
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowHomeEnabled(true);

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
                .setTitle(getString(R.string.content_course1_name));
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowHomeEnabled(true);

        View view = inflater.inflate(R.layout.fragment_course1__theory_, container, false);


        micro = (ImageButton) view.findViewById(R.id.imageButton_micro);

        b_forward = (ImageButton) view.findViewById(R.id.imageButton_forward);
        b_back = (ImageButton) view.findViewById(R.id.imageButton_back);

        header_theory = (TextView) view.findViewById(R.id.textView_header);
        text_theory = (TextView) view.findViewById(R.id.textView_theory);

        current_index_text = 0;

        text_start_test = (TextView) view.findViewById(R.id.textView_text_start_test);

        show_action(view);


        b_forward.setOnClickListener(this);
        b_back.setOnClickListener(this);




        micro.setOnClickListener(this);



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
            if(Locale.getDefault().getLanguage() == "en") {
                header_theory.setText(texts_headers_en[current_index_text]);
                text_theory.setText(texts_theories_en[current_index_text]);
            }
            else if (Locale.getDefault().getLanguage() == "ru") {
                header_theory.setText(texts_headers[current_index_text]);
                text_theory.setText(texts_theories[current_index_text]);
            }

            mediaPlayer = MediaPlayer.create(view.getContext(),audio_texts[current_index_text]);

        }
        else if (current_index_text == texts_theories.length)
        {
            Current_Fragment.now_fragment = 3;
            getParentFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment1, course1_test_fragment)
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
            case R.id.imageButton_micro: {

                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                }
                else {
                    mediaPlayer = MediaPlayer.create(getContext(), audio_texts[current_index_text]);
                    mediaPlayer.start();
                }
            }
        }
    }

    private void return_frag(){
        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1, new Course1_Theory_Fragment())
                .commit();
    }

}
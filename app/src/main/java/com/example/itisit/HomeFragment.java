package com.example.itisit;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ImageButton btn_lang;


    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
                .setTitle("ITISIT");
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowHomeEnabled(false);

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
                .setTitle("ITISIT");
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayHomeAsUpEnabled(false);
        ((AppCompatActivity) getActivity()).getSupportActionBar()
                .setDisplayShowHomeEnabled(false);

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btn_lang = (ImageButton) view.findViewById(R.id.btn_change_lang);

        if(Locale.getDefault().getLanguage() == "en")
        {
            btn_lang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    set_language("ru");
                }
            });
        }
        else if (Locale.getDefault().getLanguage() == "ru") {
            btn_lang.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    set_language("en");
                }
            });
        }

        return view;
    }

    private void set_language(String language_code){
        Resources resources = this.getResources();
        Configuration configuration = resources.getConfiguration();
        Locale locale = new Locale(language_code);
        Locale.setDefault(locale);
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, resources.getDisplayMetrics());

        getParentFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment1, new HomeFragment())
                .commit();
    }
}
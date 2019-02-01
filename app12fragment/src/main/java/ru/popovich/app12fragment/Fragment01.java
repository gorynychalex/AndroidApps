package ru.popovich.app12fragment;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Fragment01 extends Fragment {

    Button button_change;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // Создание разметки для этого фрагмента
        View layout_view = inflater.inflate(R.layout.fragment_fragment01, container, false);

        // Инициализация кнопки смены фрагмента
        button_change = layout_view.findViewById(R.id.fragment01_button);

        // Установка фрагмента
        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FragmentManager fragmentManager1 = getFragmentManager();

                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();

                if (fragmentManager1.findFragmentById(R.id.frame_layout) instanceof Fragment01){
                    fragmentTransaction1.replace(R.id.frame_layout,MainActivity.fragment02);
                } else if(fragmentManager1.findFragmentById(R.id.frame_layout) instanceof Fragment02){
                    fragmentTransaction1.replace(R.id.frame_layout,MainActivity.fragment01);
                }

                fragmentTransaction1.commit();
            }
        });

        return layout_view;
    }

}

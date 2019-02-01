package ru.popovich.app12fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Fragment02 extends Fragment {

    Button button_change;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        // Создание разметки для этого фрагмента
        View fragment_layout_view = inflater.inflate(R.layout.fragment_fragment02, container, false);

        // Инициализация кнопки смены фрагмента
        button_change = fragment_layout_view.findViewById(R.id.fragment02_button);

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

        return fragment_layout_view;
    }
}

package ru.popovich.app12fragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // Объявление фрагментов
    public static Fragment fragment01, fragment02;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация объектов фрагментов
        fragment01 = new Fragment01(); fragment02 = new Fragment02();

        // Объект транзакции фрагментов
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // Добавление фрагмента
        fragmentTransaction.add(R.id.frame_layout, fragment02);

        // Подтверждение транзакции
        fragmentTransaction.commit();

        // Инициализация объекта - контейнера фрагментов
        FrameLayout frameLayout = findViewById(R.id.frame_layout);

        // Вызов слушателя на нажатие фрагмента
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager1 = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction1 = fragmentManager1.beginTransaction();
                if (fragmentManager1.findFragmentById(R.id.frame_layout) instanceof Fragment01){
                    fragmentTransaction1.replace(R.id.frame_layout,fragment02);
                } else if(fragmentManager1.findFragmentById(R.id.frame_layout) instanceof Fragment02){
                    fragmentTransaction1.replace(R.id.frame_layout,fragment01);
                }
                fragmentTransaction1.commit();
            }
        });



    }
}

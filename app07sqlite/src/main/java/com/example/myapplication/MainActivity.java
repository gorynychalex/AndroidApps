package com.example.myapplication;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.example.myapplication.db.DBHelper;

public class MainActivity extends AppCompatActivity {

    // Метка для журналирования
    public static final String TAG = "MainActivity";

    // Объявление переменной для списка
    ListView listView;

    // Переменная для кнопки
    Button button;

    // Переменная для инициализации DB
    DBHelper dbHelper;

    // Переменная для управления DB, через методы:
    // query(),insert(),delete(),update(), execSQL()
    SQLiteDatabase sqLiteDatabase;

    // Переменная для курсора - временного объекта для хранения записей
    Cursor cursor;

    // Переменная для адаптера
    SimpleCursorAdapter simpleCursorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Определение списка из макета activity_main.xml
        listView = (ListView) findViewById(R.id.list_view);

        //Экземпляр класса базы данных
        dbHelper = new DBHelper(this);
        //объект класса для получения доступа к управлению с поддержкой записи данных
        sqLiteDatabase = dbHelper.getWritableDatabase();

        Log.d(TAG, "dbHelper.getWritableDatabase() has done");

        // Объект Cursor типа MAP-коллекция
        cursor = sqLiteDatabase.query(DBHelper.TABLE_QUIZ,null,null,null,null,null,null);

        // Вывод данных из базы
        if(cursor.moveToFirst()) {
            do {
                Log.d(TAG, "Cursor = " + cursor.getPosition() + ", ID = " + cursor.getInt(0) + " , " + DBHelper.TABLE_QUIZ_NAME + " = " + cursor.getString(1));
            } while (cursor.moveToNext());
        }
//        cursor.close();

        simpleCursorAdapter = new SimpleCursorAdapter(this,
                R.layout.list_item, cursor,
                new String[]{DBHelper.TABLE_QUIZ_NAME}, new int[]{R.id.item},0);

        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        listView.setAdapter(simpleCursorAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "position = " + position, Toast.LENGTH_SHORT).show();
                getResources().getString(R.string.app_name);

            }
        });

    }
}

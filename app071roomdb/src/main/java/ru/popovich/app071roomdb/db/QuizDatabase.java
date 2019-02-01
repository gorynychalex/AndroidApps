package ru.popovich.app071roomdb.db;

// Простая реализация абстрактного класса базы данных

import androidx.room.Database;
import androidx.room.RoomDatabase;
import ru.popovich.app071roomdb.db.dao.QuizDao;
import ru.popovich.app071roomdb.db.model.Quiz;

@Database(entities = {Quiz.class}, version = 1)
public abstract class QuizDatabase extends RoomDatabase {

    public abstract QuizDao quizDao();

}

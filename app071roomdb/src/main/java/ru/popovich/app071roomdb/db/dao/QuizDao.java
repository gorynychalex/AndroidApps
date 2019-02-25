package ru.popovich.app071roomdb.db.dao;

// Интерфейс запросов к базе данных

import java.util.List;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import ru.popovich.app071roomdb.db.model.Quiz;

@Dao
public interface QuizDao {

    @Query("select * from quiz")
    List<Quiz> getAll();

    @Query("select * from quiz")
    LiveData<List<Quiz>> getAllLive();

    @Query("select * from quiz WHERE id = :id")
    Quiz getById(int id);

    @Query("select * from quiz WHERE name = :name")
    Quiz getByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Quiz> quizList);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Quiz quiz);

    @Delete
    void delete(Quiz quiz);

}

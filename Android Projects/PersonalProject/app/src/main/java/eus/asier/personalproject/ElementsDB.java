package eus.asier.personalproject;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.Update;

import java.util.List;

@Database(entities = { Element.class }, version = 1, exportSchema = false)
public abstract class ElementsDB extends RoomDatabase {

    private static volatile ElementsDB INSTANCE;
    public abstract ElementsDAO getElementsDAO();

    static ElementsDB obtainInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (ElementsDB.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context,
                                    ElementsDB.class, "elements.db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    @Dao
    interface ElementsDAO {
        @Query("SELECT * FROM Element")
        LiveData<List<Element>> getElements();

        @Insert
        void insert(Element element);

        @Update
        void update(Element element);

        @Delete
        void delete(Element element);

        @Query("SELECT * FROM Element WHERE name LIKE '%' || :t || '%'")
        LiveData<List<Element>> search(String t);
    }
}
package com.example.android.pets.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Pet.class}, version = 1, exportSchema = false)
public abstract class PetDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "pets";

    private static final Object LOCK = new Object();
    private static volatile PetDatabase PetDatabaseInstance;

    public static PetDatabase getInstance(Context context) {

        if (PetDatabaseInstance == null) {
            synchronized (LOCK) {
                if (PetDatabaseInstance == null) {
                    PetDatabaseInstance = Room.databaseBuilder(context, PetDatabase.class,
                            PetDatabase.DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return PetDatabaseInstance;
    }

    public abstract PetDao PetDao();
}

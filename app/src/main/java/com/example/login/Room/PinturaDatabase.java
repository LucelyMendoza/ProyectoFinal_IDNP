package com.example.login.Room;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import android.content.Context;

import com.example.login.Entity.Autor;
import com.example.login.Entity.Galeria;
import com.example.login.Entity.Pintura;

@Database(entities = {Pintura.class, Autor.class, Galeria.class}, version = 2)
public abstract class PinturaDatabase extends RoomDatabase {

    public abstract PinturaDao pinturaDao();
    public abstract AutorDao autorDao();
    public abstract GaleriaDao galeriaDao();
    private static volatile PinturaDatabase INSTANCE;

    // Define la migración aquí
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Implementa los cambios necesarios en el esquema aquí
            // Ejemplo: database.execSQL("ALTER TABLE table_name ADD COLUMN new_column INTEGER DEFAULT 0");
        }
    };

    public static PinturaDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PinturaDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    PinturaDatabase.class, "pintura_database")
                            .addMigrations(MIGRATION_1_2) // Agrega la migración
                            .fallbackToDestructiveMigration() // Opcional, si necesitas permitir destrucción destructiva
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

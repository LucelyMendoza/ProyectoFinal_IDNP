package com.example.login;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class MIGRATION_1_2 {
    public static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            // Aquí puedes realizar cambios en el esquema de la base de datos.
            // Por ejemplo, si estás añadiendo una nueva columna:
            database.execSQL("ALTER TABLE pintura ADD COLUMN nueva_columna INTEGER DEFAULT 0 NOT NULL");
        }
    };
}
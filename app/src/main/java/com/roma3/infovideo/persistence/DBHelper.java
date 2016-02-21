/*
 * Copyright (c) 2016 Enrico Candino
 * <p>
 * Distributed under the MIT License.
 */

package com.roma3.infovideo.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import java.io.File;
import static com.roma3.infovideo.persistence.RomaTreContract.*;

public class DBHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    private static final String FILE_DIR = "infovideo";
    private static final String DATABASE_NAME = "orariromatre.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + CorsoEntry.TABLE_NAME + " (" +
                    CorsoEntry._ID + " INTEGER PRIMARY KEY," +
                    CorsoEntry.COLUMN_NAME_NOME + TEXT_TYPE + COMMA_SEP +
                    CorsoEntry.COLUMN_NAME_FACOLTA_ID + TEXT_TYPE + COMMA_SEP +
                    CorsoEntry.COLUMN_NAME_FACOLTA_NOME + TEXT_TYPE + COMMA_SEP +
                    " UNIQUE (" +
                        CorsoEntry.COLUMN_NAME_NOME + COMMA_SEP +
                        CorsoEntry.COLUMN_NAME_FACOLTA_ID +
                    ") ON CONFLICT IGNORE" +
            " )";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME,
                /*Environment.getExternalStorageDirectory()
                + File.separator + FILE_DIR
                + File.separator + DATABASE_NAME,*/ null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

package com.example.android.habbittracker.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.android.habbittracker.data.HabbitContract.HabbitEntry;

import static com.example.android.habbittracker.data.HabbitContract.HabbitEntry.TABLE_NAME;

/**
 * Created by Asim on 17/05/2017.
 */

public class HabbitDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = HabbitDbHelper.class.getSimpleName();

    /**
     * Name of the database file
     */
    private static final String DATABASE_NAME = "daily.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Constructs a new instance of {@link HabbitDbHelper}.
     *
     * @param context of the app
     */
    public HabbitDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * This is called when the database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the habbit tracker table
        String SQL_CREATE_HABBIT_TRACKER_TABLE = "CREATE TABLE " + HabbitEntry.TABLE_NAME + " ("
                + HabbitEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabbitEntry.COLUMN_WALK + " INTEGER NOT NULL DEFAULT 0, "
                + HabbitEntry.COLUMN_EXCERCISE + " INTEGER NOT NULL DEFAULT 0, "
                + HabbitEntry.COLUMN_BREAKFAST + " INTEGER NOT NULL DEFAULT 0, "
                + HabbitEntry.COLUMN_SHOWER + " INTEGER NOT NULL DEFAULT 0);";

        // Execute the SQL statement
        db.execSQL(SQL_CREATE_HABBIT_TRACKER_TABLE);
    }

    /**
     * This is called when the database needs to be upgraded.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}


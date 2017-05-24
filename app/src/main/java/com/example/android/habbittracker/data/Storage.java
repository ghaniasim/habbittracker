package com.example.android.habbittracker.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by qaisersiddique on 25/05/2017.
 */

public class Storage {

    /**
     * Get user input from editor and save new habbit into database.
     */
    public static void insertHabbitIntoStorage(Context context, Habit habit) {
        HabbitDbHelper mHabbitDbHelper = new HabbitDbHelper(context);
        SQLiteDatabase db = mHabbitDbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(HabbitContract.HabbitEntry.COLUMN_WALK, habit.isWalk());
        values.put(HabbitContract.HabbitEntry.COLUMN_EXCERCISE, habit.isExercise());
        values.put(HabbitContract.HabbitEntry.COLUMN_BREAKFAST, habit.isBreakfast());
        values.put(HabbitContract.HabbitEntry.COLUMN_SHOWER, habit.isShower());
        db.insert(HabbitContract.HabbitEntry.TABLE_NAME, null, values);
    }

    public static ArrayList<Habit> readAllHabitsFromStorage(Context context) {
        HabbitDbHelper mCodeDbHelper = new HabbitDbHelper(context);
        SQLiteDatabase db = mCodeDbHelper.getReadableDatabase();
        String[] projection = {HabbitContract.HabbitEntry._ID, HabbitContract.HabbitEntry.COLUMN_WALK,
                HabbitContract.HabbitEntry.COLUMN_EXCERCISE, HabbitContract.HabbitEntry.COLUMN_BREAKFAST, HabbitContract.HabbitEntry.COLUMN_SHOWER};
        Cursor cursor = db.query(HabbitContract.HabbitEntry.TABLE_NAME, projection,
                null, null,
                null, null, null);
        ArrayList<Habit> data = new ArrayList<>();
        while (cursor.moveToNext()) {
            boolean walk = cursor.getInt(cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_WALK)) == 1;
            boolean exercise = cursor.getInt(cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_EXCERCISE)) == 1;
            boolean breakfast = cursor.getInt(cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_BREAKFAST)) == 1;
            boolean shower = cursor.getInt(cursor.getColumnIndex(HabbitContract.HabbitEntry.COLUMN_SHOWER)) == 1;

            Habit habit = new Habit( walk, exercise, breakfast, shower);
            data.add(habit);
        }
        cursor.close();
        db.close();
        return data;
    }

}

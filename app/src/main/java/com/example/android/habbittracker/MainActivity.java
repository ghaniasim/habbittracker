package com.example.android.habbittracker;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.habbittracker.data.HabbitContract.HabbitEntry;
import com.example.android.habbittracker.data.HabbitDbHelper;

public class MainActivity extends AppCompatActivity {

    /**
     * Database helper that will provide us access to the database
     */
    private HabbitDbHelper mHabbitDbHelper;

    /**
     * Spinner to enter the answer of the user
     */
    private Spinner mMorningWalkSpinner;
    /**
     * Spinner to enter the answer of the user
     */
    private Spinner mExcerciseSpinner;
    /**
     * Spinner to enter the answer of the user
     */
    private Spinner mBreakfastSpinner;
    /**
     * Spinner to enter the answer of the user
     */
    private Spinner mShowerSpinner;
    /**
     * The possible valid values are in the HabbitContract.java file:
     * {@link HabbitEntry#ANSWER_NO}, {@link HabbitEntry#ANSWER_YES}
     */
    private int mMorningWalk = HabbitEntry.ANSWER_NO;
    private int mExcercise = HabbitEntry.ANSWER_NO;
    private int mBreakfast = HabbitEntry.ANSWER_NO;
    private int mShower = HabbitEntry.ANSWER_NO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMorningWalkSpinner = (Spinner) findViewById(R.id.spinner_morning_walk);
        mExcerciseSpinner = (Spinner) findViewById(R.id.spinner_excercise);
        mBreakfastSpinner = (Spinner) findViewById(R.id.spinner_breakfast);
        mShowerSpinner = (Spinner) findViewById(R.id.spinner_shower);

        insertHabbit();

        Cursor c = read();

        displayDatabaseInfo(c);
    }

    /**
     * Setup the dropdown spinner that allows to select the answer.
     */
    private void setupMorningWalkSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter morningWalkSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_answer_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        morningWalkSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mMorningWalkSpinner.setAdapter(morningWalkSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mMorningWalkSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.answer_no))) {
                        mMorningWalk = HabbitEntry.ANSWER_NO; // NO
                    } else {
                        mMorningWalk = HabbitEntry.ANSWER_YES; // YES
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mMorningWalk = HabbitEntry.ANSWER_NO; // NO
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows to select the answer.
     */
    private void setupExcersieSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter excerciseSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_answer_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        excerciseSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mExcerciseSpinner.setAdapter(excerciseSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mExcerciseSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.answer_no))) {
                        mExcercise = HabbitEntry.ANSWER_NO; // NO
                    } else {
                        mExcercise = HabbitEntry.ANSWER_YES; // YES
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mExcercise = HabbitEntry.ANSWER_NO; // NO
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows to select the answer.
     */
    private void setupBreakfastSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter breakfastSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_answer_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        breakfastSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mBreakfastSpinner.setAdapter(breakfastSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mBreakfastSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.answer_no))) {
                        mBreakfast = HabbitEntry.ANSWER_NO; // NO
                    } else {
                        mBreakfast = HabbitEntry.ANSWER_YES; // YES
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mBreakfast = HabbitEntry.ANSWER_NO; // NO
            }
        });
    }

    /**
     * Setup the dropdown spinner that allows to select the answer.
     */
    private void setupShowerSpinner() {
        // Create adapter for spinner. The list options are from the String array it will use
        // the spinner will use the default layout
        ArrayAdapter showerSpinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.array_answer_options, android.R.layout.simple_spinner_item);

        // Specify dropdown layout style - simple list view with 1 item per line
        showerSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);

        // Apply the adapter to the spinner
        mShowerSpinner.setAdapter(showerSpinnerAdapter);

        // Set the integer mSelected to the constant values
        mShowerSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selection = (String) parent.getItemAtPosition(position);
                if (!TextUtils.isEmpty(selection)) {
                    if (selection.equals(getString(R.string.answer_no))) {
                        mShower = HabbitEntry.ANSWER_NO; // NO
                    } else {
                        mShower = HabbitEntry.ANSWER_YES; // YES
                    }
                }
            }

            // Because AdapterView is an abstract class, onNothingSelected must be defined
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                mShower = HabbitEntry.ANSWER_NO; // NO
            }
        });
    }


    /**
     * Get user input from editor and save new habbit into database.
     */
    private void insertHabbit() {

        // Gets the data repository in write mode
        // Create database helper
        HabbitDbHelper mHabbitDbHelper = new HabbitDbHelper(this);
        SQLiteDatabase db = mHabbitDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(HabbitEntry.COLUMN_WALK, mMorningWalk);
        values.put(HabbitEntry.COLUMN_EXCERCISE, mExcercise);
        values.put(HabbitEntry.COLUMN_BREAKFAST, mBreakfast);
        values.put(HabbitEntry.COLUMN_SHOWER, mShower);

        // Insert the new row, returning the primary key value of the new row
        db.insert(HabbitEntry.TABLE_NAME, null, values);
        Toast.makeText(this, "new column added", Toast.LENGTH_SHORT).show();

    }

    private Cursor read() {
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        HabbitDbHelper mCodeDbHelper = new HabbitDbHelper(this);

        // Create and/or open a database to read from it
        SQLiteDatabase db = mCodeDbHelper.getReadableDatabase();
        // Use query method on Database object making use of projection, selection and selection argument
        String[] projection = {HabbitEntry._ID, HabbitEntry.COLUMN_WALK,
                HabbitEntry.COLUMN_EXCERCISE, HabbitEntry.COLUMN_BREAKFAST, HabbitEntry.COLUMN_SHOWER};
        Cursor cursor = db.query(HabbitEntry.TABLE_NAME, projection,
                null, null,
                null, null, null);
        db.close();
        return cursor;

    }

    /**
     * Temporary helper method to display information in the onscreen TextView about the state of
     * the habbittracker database.
     */
    private void displayDatabaseInfo(Cursor cursor) {

        TextView displayView = (TextView) findViewById(R.id.text_view_habbit_record);

        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // habbittracker table in the database).
            displayView.setText("Habbit database contains: " + cursor.getCount() + " habit history \n\n");
            displayView.append(HabbitEntry._ID + "-" + HabbitEntry.COLUMN_WALK + "-" + HabbitEntry.COLUMN_EXCERCISE + "-" +
                    HabbitEntry.COLUMN_BREAKFAST + "-" + HabbitEntry.COLUMN_SHOWER + "\n");
            int idColumnIndex = cursor.getColumnIndex(HabbitEntry._ID);
            int morningWalkColumnIndex = cursor.getColumnIndex(HabbitEntry.COLUMN_WALK);
            int excerciseColumnIndex = cursor.getColumnIndex(HabbitEntry.COLUMN_EXCERCISE);
            int breakfastColumnIndex = cursor.getColumnIndex(HabbitEntry.COLUMN_BREAKFAST);
            int showerColumnIndex = cursor.getColumnIndex(HabbitEntry.COLUMN_SHOWER);
            while (cursor.moveToNext()) {
                int currentId = cursor.getInt(idColumnIndex);
                String currentMorningWalk = String.valueOf(cursor.getInt(morningWalkColumnIndex));
                String currentExcercise = String.valueOf(cursor.getInt(excerciseColumnIndex));
                String currentBreakfast = String.valueOf(cursor.getInt(breakfastColumnIndex));
                String currentShower = String.valueOf(cursor.getInt(showerColumnIndex));
                displayView.append("\n" + currentId + "-" + currentMorningWalk + "-" + currentExcercise + "-" +
                        currentBreakfast + "-" + currentShower);
            }

        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.
            cursor.close();
        }
    }

}

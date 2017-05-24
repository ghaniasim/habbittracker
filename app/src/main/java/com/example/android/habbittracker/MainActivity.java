package com.example.android.habbittracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.android.habbittracker.data.Habit;
import com.example.android.habbittracker.data.Storage;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Habit> data = Storage.readAllHabitsFromStorage(this);
        displayAStringOnTextView(data);
    }

    public void saveHabit (){
      // TODO: Get the values from check boxes
        boolean walk = checkboxWalk.getValue();
        boolean breakfast =  checkboxBreakdast.getValue();
        boolean exercise =  checkboxExcercise.getValue();
        boolean shower=  checkboxShower.getValue();

        Habit habit = new Habit(walk, exercise,breakfast, shower);

        Storage.insertHabbitIntoStorage(this, habit);
    }

    private void displayAStringOnTextView(ArrayList<Habit> list) {
        //TODO: make ListView with ListAdapter.
        TextView displayView = (TextView) findViewById(R.id.text_view_habbit_record);
        String data = "";
        for (Habit habit : list) {
            data += "\n WALK: " + habit.isWalk();
            data += "\n BREAKFAST: " + habit.isBreakfast();
            data += "\n EXERCISE: " + habit.isExercise();
            data += "\n SHOWER: " + habit.isShower();
            data += "\n";
        }
        displayView.setText(data);
    }
}
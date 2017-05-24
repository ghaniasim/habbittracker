package com.example.android.habbittracker.data;

/**
 * Created by qaisersiddique on 25/05/2017.
 */

public class Habit {

    boolean walk, exercise, breakfast, shower;

    public Habit(boolean walk, boolean exercise, boolean breakfast, boolean shower) {
        this.walk = walk;
        this.exercise = exercise;
        this.breakfast = breakfast;
        this.shower = shower;
    }

    public Habit() {

    }

    public boolean isWalk() {
        return walk;
    }

    public void setWalk(boolean walk) {
        this.walk = walk;
    }

    public boolean isExercise() {
        return exercise;
    }

    public void setExercise(boolean exercise) {
        this.exercise = exercise;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }
}

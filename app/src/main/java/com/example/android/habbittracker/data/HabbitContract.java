package com.example.android.habbittracker.data;

import android.provider.BaseColumns;

/**
 * Created by Asim on 17/05/2017.
 */

public class HabbitContract {

    // To prevent someone from accidentally instantiating the contract class,
    // give it an empty constructor.
    private HabbitContract() {}

    /**
     * Inner class that defines constant values for the habbitTracker database table.
     */
    public static final class HabbitEntry implements BaseColumns {

        /**
         * Name of database table for habbit tracker
         */
        public final static String TABLE_NAME = "habbit_tracker";

        /**
         * Unique ID number.
         * <p>
         * Type: INTEGER
         */
        public final static String _ID = BaseColumns._ID;

        /**
         * Name of the habbit.
         * <p>
         * The only possible values are {@link #ANSWER_YES}, {@link #ANSWER_NO}
         * Type: INTEGER
         */
        public final static String COLUMN_WALK = "walk";

        /**
         * Name of the habbit.
         * <p>
         * The only possible values are {@link #ANSWER_YES}, {@link #ANSWER_NO}
         * Type: INTEGER
         */
        public final static String COLUMN_EXCERCISE = "excercise";

        /**
         * Name
         * <p>
         * The only possible values are {@link #ANSWER_YES}, {@link #ANSWER_NO}
         * Type: INTEGER
         */
        public final static String COLUMN_BREAKFAST = "breakfast";

        /**
         * Weight of the pet.
         * <p>
         * The only possible values are {@link #ANSWER_YES}, {@link #ANSWER_NO}
         * Type: INTEGER
         */
        public final static String COLUMN_SHOWER = "shower";

        /**
         * Possible values for each column.
         */
        public static final int ANSWER_NO = 0;
        public static final int ANSWER_YES = 1;
    }

}

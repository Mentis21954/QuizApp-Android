package com.example.vikasojha.quizbee;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "HIGHSCORE";

    // Table columns
    public static final String SCORE = "score" ;

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "QuizBall.db";

    public DatabaseHelper (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate (SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + SCORE + " INTEGER PRIMARY KEY )";
        // method to execute above sql query
        db.execSQL(query);
    }

    public void addNewScore(int newScore) {
        SQLiteDatabase db = this.getWritableDatabase();
        // variable for content values.
        ContentValues values = new ContentValues();
        values.put(SCORE, newScore);
        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public int findHighScore() {
        // read database.
        SQLiteDatabase db = this.getReadableDatabase();
        return  (int) DatabaseUtils.longForQuery(db, "SELECT MAX(score) FROM " + TABLE_NAME, null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

package com.example.kcfapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class db_helper extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "location_db";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "locations";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String ADDRESS_COL = "address";
    private static final String FOOD = "food";
    private static final String CLOTHING = "clothing";
    private static final String SHELTER = "shelter";
    private static final String HEALTHCARE = "healthcare";

    // creating a constructor for our database handler.
    public db_helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + FOOD + " INTEGER,"
                + CLOTHING + " INTEGER,"
                + SHELTER + "INTEGER,"
                + HEALTHCARE + "INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new location to our sqlite database.
    // food, clothing, shelter, healthcare takes 0 (false) or 1 (true)
    public void addNewLocation(String locName, String locAddress, int food, int clothing, int shelter, int healthcare) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, locName);
        values.put(ADDRESS_COL, locAddress);
        values.put(FOOD, food);
        values.put(CLOTHING, clothing);
        values.put(SHELTER, shelter);
        values.put(HEALTHCARE, healthcare);

        // after adding all values we are passing
        // content values to our table.
        // TODO: produces error regarding healthcare column
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

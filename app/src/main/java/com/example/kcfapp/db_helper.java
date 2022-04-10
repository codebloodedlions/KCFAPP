//++++++++++++++++++++++++++++++++++++++++++++++++
// Name: db_helper.java
// Function: app database functionality
// Programmer: Charles Lett Jr.
// Last Updated: 04/06/2022
// Reference: https://www.geeksforgeeks.org/how-to-create-and-add-data-to-sqlite-database-in-android/
//++++++++++++++++++++++++++++++++++++++++++++++++

package com.example.kcfapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.HashMap;

public class db_helper extends SQLiteOpenHelper {
    private static final boolean ENABLE_DEBUG = false;

    // clears db; ALWAYS LEAVE TO FALSE UNLESS YOU INTEND TO DELETE THE LOCATION TABLE
    // the table will be recreated next time a query is made
    private static final boolean KILL_DB = false;

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "location.db";
    private static final int DB_VERSION = 2;
    private static final String TABLE_NAME = "locations";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String ADDRESS_COL = "address";
    private static final String FOOD = "food";
    private static final String CLOTHING = "clothing";
    private static final String SHELTER = "shelter";
    private static final String HEALTHCARE = "healthcare";

    // on below line we are creating a variable for
    // our sqlite database and calling writable method
    // as we are writing data in our database.
    SQLiteDatabase db = this.getWritableDatabase();


    // creating a constructor for our database handler.
    public db_helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if(KILL_DB){
            System.out.println(TABLE_NAME + " Cleared!!!");
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        }
        if(ENABLE_DEBUG) viewLocationTable(db, TABLE_NAME);

    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + FOOD + " INTEGER,"
                + CLOTHING + " INTEGER,"
                + SHELTER + " INTEGER,"
                + HEALTHCARE + " INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new location to our sqlite database.
    // food, clothing, shelter, healthcare takes 0 (false) or 1 (true)
    public void addNewLocation(String locName, String locAddress, int prov_food, int prov_clothing, int prov_shelter, int prov_healthcare) {
        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(NAME_COL, locName);
        values.put(ADDRESS_COL, locAddress);
        values.put(FOOD, prov_food);
        values.put(CLOTHING, prov_clothing);
        values.put(SHELTER, prov_shelter);
        values.put(HEALTHCARE, prov_healthcare);

        // after adding all values we are passing
        // content values to our table.
        // TODO: produces error regarding healthcare column
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    // update location info; may leave alone
    public void updateLocation(String locName, String locAddress, int prov_food, int prov_clothing, int prov_shelter, int prov_healthcare){

    }

    public String viewLocationTable(SQLiteDatabase db, String tableName){
        Log.d("","*****ViewLocationTable started*****");
        String tableStr = String.format("Table %s:\n", tableName);
        Cursor allRows = db.rawQuery("SELECT * FROM " + tableName, null);
        tableStr += cursorToString(allRows);
        System.out.println("[DB INFO]" + tableStr);
        return tableStr;
    }

    @SuppressLint("Range")
    public String cursorToString(Cursor cursor){
        String cursorString = "";
        if (cursor.moveToFirst()){
            String[] colNames = cursor.getColumnNames();
            for(String name: colNames)
                cursorString += String.format("%s ][ ", name);
            cursorString += "\n";
            do{
                for (String name: colNames){
                    cursorString += String.format("%s ][ ",
                            cursor.getString(cursor.getColumnIndex(name)));
                }
                cursorString += "\n";
            }
            while(cursor.moveToNext());
        }
        return cursorString;
    }

//    public HashMap<Integer, String> getLocationInfo() {
//
//    }

    // for upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}

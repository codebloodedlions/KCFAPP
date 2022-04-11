//++++++++++++++++++++++++++++++++++++++++++++++++
// Name: db_helper.java
// Function: app database functionality
// Programmer: Charles Lett Jr.
// Last Updated: 04/10/2022
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
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.io.PrintWriter;

public class db_helper extends SQLiteOpenHelper {
    private static final boolean ENABLE_DEBUG = false;

    // clears db; ALWAYS LEAVE TO FALSE UNLESS YOU INTEND TO DELETE THE LOCATION TABLE
    // the table will be recreated next time a query is made
    private static final boolean KILL_DB = false;

    // webserver info
    private static final String URL = "http://codebloodedlu.com/scripts/updateDB.php";

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
    private static final String SYNC = "sync";

    // on below line we are creating a variable for
    // our sqlite database and calling writable method
    // as we are writing data in our database.
    // SQLiteDatabase db = this.getWritableDatabase();


    // creating a constructor for our database handler.
    public db_helper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        if(KILL_DB){
            SQLiteDatabase db = this.getWritableDatabase();
            System.out.println(TABLE_NAME + " Cleared!!!");

            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

            String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                    + NAME_COL + " TEXT,"
                    + ADDRESS_COL + " TEXT,"
                    + FOOD + " INTEGER,"
                    + CLOTHING + " INTEGER,"
                    + SHELTER + " INTEGER,"
                    + HEALTHCARE + " INTEGER)";
            db.execSQL(query);

            db.close();
        }
        if(ENABLE_DEBUG) {
            SQLiteDatabase db = this.getWritableDatabase();
            viewLocationTable(db, TABLE_NAME);
            db.close();
        }

    }

    public void killDB(){
        SQLiteDatabase db = this.getWritableDatabase();
        System.out.println(TABLE_NAME + " Cleared!!!");

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);

        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + FOOD + " INTEGER,"
                + CLOTHING + " INTEGER,"
                + SHELTER + " INTEGER,"
                + HEALTHCARE + " INTEGER)";
        db.execSQL(query);

        db.close();
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " ("
                + NAME_COL + " TEXT,"
                + ADDRESS_COL + " TEXT,"
                + FOOD + " INTEGER,"
                + CLOTHING + " INTEGER,"
                + SHELTER + " INTEGER,"
                + HEALTHCARE + " INTEGER,"
                + SYNC + "INTEGER)";

        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query);
    }

    // this method is use to add new location to our sqlite database.
    // food, clothing, shelter, healthcare takes 0 (false) or 1 (true)
    public void addNewLocation(String locName, String locAddress, int prov_food, int prov_clothing, int prov_shelter, int prov_healthcare) {
        SQLiteDatabase db = this.getWritableDatabase();

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

    public List<locationOBJ> getLocationData(){
        SQLiteDatabase db = this.getWritableDatabase();

        // object for storing location data
        List<locationOBJ> ld = new ArrayList<>();
        Cursor csr = db.query(TABLE_NAME, null, null, null, null, null, null);

        while (csr.moveToNext()){
            @SuppressLint("Range")
            locationOBJ temp = new locationOBJ(
                    csr.getString(csr.getColumnIndex(NAME_COL)),
                    csr.getString(csr.getColumnIndex(ADDRESS_COL)),
                    csr.getInt(csr.getColumnIndex(FOOD)),
                    csr.getInt(csr.getColumnIndex(CLOTHING)),
                    csr.getInt(csr.getColumnIndex(SHELTER)),
                    csr.getInt(csr.getColumnIndex(HEALTHCARE))
            );

            ld.add(temp);
        }
        csr.close();
        db.close();

        return ld;


    }


    public void writeJSON() throws FileNotFoundException {
        @SuppressLint("SdCardPath") String path = "/data/data/com.example.kcfapp/";
        Gson gs = new Gson();
        locationOBJ data;

        File file = new File(path + "locations.json");
        PrintWriter writer = new PrintWriter(new FileOutputStream(file));

        for(int i=0; i < getLocationData().size(); i++){
            data = getLocationData().get(i);
            writer.write(gs.toJson(data) + "\n");
        }

        writer.close();

    }


    // for upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
package com.example.diy2210.sharebypgp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class SQLHelper extends SQLiteOpenHelper {

    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "keydb";
    private static final String TABLE_KEYS = "keydetails";
    private static final String KEY_ID = "id";
    private static final String KEY_TIME = "time";
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_FILE = "file";
    private SQLiteDatabase sqLiteDatabase;

    public SQLHelper(Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_KEYS + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_TIME + " TEXT,"
                + KEY_NAME + " TEXT,"
                + KEY_EMAIL + " TEXT,"
                + KEY_FILE + " TEXT"+ ")";
        sqLiteDatabase.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        // Drop older table if exist
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_KEYS);
        // Create tables again
        onCreate(sqLiteDatabase);
    }

    // **** CRUD (Create, Read, Update, Delete) Operations ***** //
    // Adding new Key Details
    void insertCounterDetails(String time, String name, String email, String file) {
        //Get the Data Repository in write mode
        sqLiteDatabase = this.getWritableDatabase();
        //Create a new map of values, where column names are the keys
        ContentValues cValues = new ContentValues();
        cValues.put(KEY_TIME, time);
        cValues.put(KEY_NAME, name);
        cValues.put(KEY_EMAIL, email);
        cValues.put(KEY_FILE, file);
        // Insert the new row, returning the primary key value of the new row
        long newRowId = sqLiteDatabase.insert(TABLE_KEYS,null, cValues);
        sqLiteDatabase.close();
    }

    // Get Key Details
    public ArrayList<HashMap<String, String>> GetKeys() {
        sqLiteDatabase = this.getWritableDatabase();
        ArrayList<HashMap<String, String>> keyList = new ArrayList<>();
        String query = "SELECT time, name, email, file FROM "+ TABLE_KEYS;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        while (cursor.moveToNext()){
            HashMap<String,String> key = new HashMap<>();
            key.put("time",cursor.getString(cursor.getColumnIndex(KEY_TIME)));
            key.put("name",cursor.getString(cursor.getColumnIndex(KEY_NAME)));
            key.put("email",cursor.getString(cursor.getColumnIndex(KEY_EMAIL)));
            key.put("file",cursor.getString(cursor.getColumnIndex(KEY_FILE)));
            keyList.add(key);
        }
        return  keyList;
    }
}

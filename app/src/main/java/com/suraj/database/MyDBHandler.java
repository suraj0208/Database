package com.suraj.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by suraj on 22/7/15.
 */
public class MyDBHandler extends SQLiteOpenHelper
{
    private  static final int DATABASE_VERSION= 1;
    private  static final String DATABASE_NAME = "products.db";

    public static final String TABLE_PRODUCTS = "products";
    public static final String COLUMN_ID ="_id";
    public static final String COLUMN_PRODUCTNAME="productname";
    public static final String COLUMN_NUMBER="number";

    String dbString[];
    String dbString1[];
    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
        dbString = new String[5];
        dbString1 = new String[5];
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCTS +
                "("+ COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                +COLUMN_PRODUCTNAME + " TEXT, " + COLUMN_NUMBER + " TEXT "+");";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addproduct(Product product)
    {

        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_PRODUCTNAME,product.get_productname());
        contentValues.put(COLUMN_NUMBER,product.get_number());

        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PRODUCTS,null,contentValues);
        db.close();
    }

    public  String[] getdatabasestring()
    {


        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_PRODUCTS + " WHERE 2";

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();
        int i =0;
        //Position after the last row means the end of the results
        while (!c.isAfterLast()) {
            if (c.getString(c.getColumnIndex("productname")) != null) {
                dbString[i] = c.getString(c.getColumnIndex("productname"));

            }
            if (c.getString(c.getColumnIndex("number")) != null) {
                dbString1[i] = c.getString(c.getColumnIndex("number"));

            }
            i++;


            c.moveToNext();
        }
        db.close();
        return dbString;
    }
    public  String[] getdatabasestring1()
    {
        return  dbString1;
    }
}

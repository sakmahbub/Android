package com.example.sqlliteex;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDbAdapter {

    MyDbHelper helper;

    public MyDbAdapter(Context context)
    {
        helper = new MyDbHelper(context);
    }


   static class MyDbHelper extends SQLiteOpenHelper
   {

      // Table Name
      public static final String TABLE_NAME = "TODOS";

       // Table columns
       public static final String ID = "id";
       private static final String NAME = "name";
       private static final String QTY= "qty";
       // Database Information
       static final String DB_NAME = "JAVATECHIG_TODOS.DB";

       // database version
       static final int DB_VERSION = 1;

       // Creating table query
       private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID
               + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " TEXT NOT NULL, " + QTY + " TEXT);";

       public MyDbHelper(Context context) {
           super(context, DB_NAME, null, DB_VERSION);
       }

       @Override
       public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_TABLE);
       }

       @Override
       public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
          db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
          onCreate(db);
       }
   }
    public long insertData(Product product)
    {
        SQLiteDatabase db = helper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(MyDbHelper.NAME, product.getName());
        contentValues.put(MyDbHelper.QTY, product.getQty());
        long id = db.insert(MyDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }

    public Product findProductById(int id){
        SQLiteDatabase db=helper.getReadableDatabase();
        String[] projection ={MyDbHelper.ID , MyDbHelper.NAME, MyDbHelper.QTY};
        String selection=MyDbHelper.ID + " = " + id;

        Cursor cursor=db.query(MyDbHelper.TABLE_NAME, projection, selection, null, null, null, null);

        Product product=new Product();
        if(cursor.moveToFirst()){
           cursor.moveToFirst();
           product.setId(Integer.parseInt(cursor.getString(0)));
           product.setName(cursor.getString(1));
            product.setQty(Integer.parseInt(cursor.getString(2)));
        }
        return product;
    }

    public  void deleteProduct(int id){
        SQLiteDatabase db=helper.getWritableDatabase();
        db.execSQL("DELETE FROM "  + MyDbHelper.TABLE_NAME + " WHERE " + MyDbHelper.ID + "='" + id +"'");
        db.close();

    }

}

package com.isil.am2template.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabase extends SQLiteOpenHelper {


	public static final int DATABASE_VERSION = 1;
 
	public static final String DATABASE_NAME = "BDEasy";
 
    public static final String TABLE_FAVORITE = "tb_favorite";
    
    //Columnas de la Tabla Notes
    public static final String KEY_ID = "id";
    public static final String KEY_USER_EMAIL = "user_email";
    public static final String KEY_PLACE_NAME = "place_name";
    public static final String KEY_PLACE_ADDRESS = "place_address";
    public static final String KEY_DISTANCE= "distance";
    public static final String KEY_FAVORITE = "favorite";
    
    
    public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql= "CREATE TABLE " + TABLE_FAVORITE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_USER_EMAIL + " VARCHAR,"
				+ KEY_PLACE_NAME + " VARCHAR,"
                + KEY_PLACE_ADDRESS + " VARCHAR,"
				+ KEY_DISTANCE + " DOUBLE,"
                + KEY_FAVORITE + " BOOLEAN" + ")";
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql= "DROP TABLE IF EXISTS " + TABLE_FAVORITE;
		db.execSQL(sql);
	}

}

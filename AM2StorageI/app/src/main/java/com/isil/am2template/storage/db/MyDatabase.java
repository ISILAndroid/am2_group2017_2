package com.isil.am2template.storage.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDatabase extends SQLiteOpenHelper {


	public static final int DATABASE_VERSION = 1;
 
	public static final String DATABASE_NAME = "BDNote";
 
    public static final String TABLE_NOTES = "tb_notes";
    public static final String TABLE_USER = "tb_users";

    //Columnas de la Tabla Notes
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_DESC = "desc";
    public static final String KEY_PATH = "path";
    
    //User table
	public static final String KEY_USER_ID = "id";
	public static final String KEY_USER_NAME = "name";

    public MyDatabase(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql= "CREATE TABLE " + TABLE_NOTES + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL ," + KEY_NAME + " TEXT,"
				+ KEY_DESC + " TEXT,"
                + KEY_PATH + " TEXT" + ")";

		Log.d("CONSOLE","sql "+sql );
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String sql= "DROP TABLE IF EXISTS " + TABLE_NOTES;
		db.execSQL(sql);
	}

}

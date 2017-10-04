package com.isil.am2template.storage.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.isil.am2template.model.Place;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emedinaa on 2/10/17.
 */

public class PlaceCrudOperations {

    private final MyDatabase helper;

    public PlaceCrudOperations(SQLiteOpenHelper mHelper) {
        super();
        // TODO Auto-generated constructor stub
        helper = (MyDatabase) mHelper;
    }

    public void addPlace(Place place) {
        SQLiteDatabase db = helper.getWritableDatabase(); //modo escritura
        ContentValues values = new ContentValues();
        values.put(MyDatabase.KEY_USER_EMAIL, place.getUserEmail());
        values.put(MyDatabase.KEY_PLACE_NAME, place.getName());
        values.put(MyDatabase.KEY_PLACE_ADDRESS, place.getAddress());
        values.put(MyDatabase.KEY_DISTANCE, place.getDistance());
        values.put(MyDatabase.KEY_FAVORITE, place.isFavorite());

        db.insert(MyDatabase.TABLE_FAVORITE, null, values);
        db.close();
    }

    public List<Place> getAllFavoritePlaces() {
        List<Place> lst = new ArrayList<Place>();
        String sql = "SELECT  * FROM " + MyDatabase.TABLE_FAVORITE;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        if (cursor.moveToFirst()) {
            do {
                Place place = new Place();
                place.setId(Integer.parseInt(cursor.getString(0)));
                place.setUserEmail(cursor.getString(1));
                place.setName(cursor.getString(2));
                place.setAddress(cursor.getString(3));
                place.setDistance(Double.parseDouble(cursor.getString(4)));
                place.setFavorite(Boolean.parseBoolean(cursor.getString(5)));

                lst.add(place);
            } while (cursor.moveToNext());
        }
        return lst;
    }

    public int getPlaceCount() {
        String sql = "SELECT * FROM " + MyDatabase.TABLE_FAVORITE;
        SQLiteDatabase db = helper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        int count = cursor.getCount();
        cursor.close();

        return count;

    }
}

package com.isil.am2template;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class DemoActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor sharedPreferencesEditor;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        app();
    }

    private void ui(){
        textView= (TextView) findViewById(R.id.textView);
        //textView.setText("TEXTO...");
    }

    private void app() {
        ui();
        setUpSharedPreferences();

        //save
        //saveStringKey("USERNAME","edu");
        //saveStringKey("PASSWORD","123456");

        //retrieve
        //retrieveStringValue("USERNAME");
        //retrieveStringValue("PASSWORD");

        //clear
        //clearKey("USERNAME");
        //clear();
    }

    private void setUpSharedPreferences(){
        sharedPreferences=getSharedPreferences("DEMO", Context.MODE_PRIVATE);
        //sharedPreferences=getSharedPreferences("DEMO", Context.MODE_APPEND);
        sharedPreferencesEditor= sharedPreferences.edit();
    }

    private void retrieveStringValue(String key){
        String value= sharedPreferences.getString(key,null);

        log(String.format("retrieve key : %s , value : %s",key,value));
    }

    private void retrieveIntValue(String key){
        int value= sharedPreferences.getInt(key,0);
        log(String.format("retrieve key : %s , value : %s",key,value));
    }

    private void retrieveBooleanValue(String key){
        boolean value= sharedPreferences.getBoolean(key,false);
        log(String.format("retrieve key : %s , value : %s",key,value));
    }

    private void saveStringKey(String key, String value){
        sharedPreferencesEditor.putString(key, value);
        sharedPreferencesEditor.apply();

        log(String.format("key : %s , value : %s",key,value));
    }

    private void saveIntKey(String key, int value){
        sharedPreferencesEditor.putInt(key, 0);
        sharedPreferencesEditor.apply();
        log(String.format("key : %s , value : %s",key,value));
    }

    private void saveBooleanKey(String key, boolean value){
        sharedPreferencesEditor.putBoolean(key, value);
        //sharedPreferencesEditor.apply();

        log(String.format("key : %s , value : %s",key,value));
    }

    private void clearKey(String key){
        sharedPreferencesEditor.remove(key);
        sharedPreferencesEditor.apply();
    }


    private void clear(){
        //sharedPreferencesEditor.remove(key);
        //sharedPreferencesEditor.remove(key);
        sharedPreferencesEditor.clear();
        sharedPreferencesEditor.apply();
    }
    private void log(String message){
        if(message==null)return;
        Log.d("CONSOLE", message);
    }


}

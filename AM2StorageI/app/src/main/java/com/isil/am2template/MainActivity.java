package com.isil.am2template;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final String PREFERENCES= "com.isil.am2template";
    private final String PREFERENCES_TEXT= "com.isil.am2template.session.text";

    private TextView textView;
    private Button buttonSave,buttonClear;
    private View constraintLayoutContainer;
    private Snackbar snackbar;

    private SharedPreferences sharedPreferences;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ui();
        app();
    }


    private void  saveValue(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(PREFERENCES_TEXT, "Hello Android");
        editor.apply();
    }


    private void  clearSession(){
        SharedPreferences.Editor editor = sharedPreferences.edit();
        /*editor.remove(PREFERENCES_TEXT);
        editor.clear();
        editor.apply();*/
    }
    private void app() {
        sharedPreferences= getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveValue();
                showMessage("Save successful!");
            }
        });

        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearSession();
                showMessage("Cleaned session !");

            }
        });

        renderText();
    }

    private void renderText() {

        String text= "SP empty";
        if(sharedPreferences.contains(PREFERENCES_TEXT)){
            text= sharedPreferences.getString(PREFERENCES_TEXT,"SP empty");
        }
        textView.setText(text);

    }

    private void showMessage(String message){
        if(message==null)return;
        snackbar.setText(message);
        snackbar.show();
    }
    private void showMessage(){
        snackbar.setText("Hello Android");
        snackbar.show();
    }


    private void updateText() {
        textView.setText("Hello Android");
    }

    private void ui() {
        constraintLayoutContainer= findViewById(R.id.constraintLayoutContainer);
        textView= (TextView) findViewById(R.id.textView);
        buttonSave= (Button) findViewById(R.id.buttonSave);
        buttonClear=(Button)findViewById(R.id.buttonClear);
        snackbar= Snackbar.make(constraintLayoutContainer,"",Snackbar.LENGTH_LONG);
    }
}

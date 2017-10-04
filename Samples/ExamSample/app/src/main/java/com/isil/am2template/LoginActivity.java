package com.isil.am2template;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.isil.am2template.storage.PreferencesHelper;


public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText eteUsername;
    private EditText etePassword;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        eteUsername = (EditText) findViewById(R.id.eteUsername);
        etePassword = (EditText) findViewById(R.id.etePassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validateForm()) {
                    gotoMain();
                }
            }
        });
    }

    private void gotoMain() {
        saveSession();
        Intent intent = new Intent(this, DashboardActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveSession() {
        PreferencesHelper.saveSession(this, username, password);
    }

    private boolean validateForm() {
        username = eteUsername.getText().toString();
        password = etePassword.getText().toString();

        if (username.isEmpty()) {
            eteUsername.setError("Error campo username");
            return false;
        }
        if (password.isEmpty()) {
            etePassword.setError("Error campo password");
            return false;
        }
        return true;
    }

}

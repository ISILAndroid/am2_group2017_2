package com.isil.am2fragments.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.am2fragments.R;
import com.isil.am2fragments.ui.fragments.BlankFragmentListener;

public class MyActivity extends AppCompatActivity
        implements BlankFragmentListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
    }

    @Override
    public void actionFragment(Object object) {

    }

    @Override
    public void actionActivityCambiarColor() {

    }
}

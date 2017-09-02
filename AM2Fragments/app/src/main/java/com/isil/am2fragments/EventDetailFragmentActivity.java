package com.isil.am2fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.isil.am2fragments.ui.fragments.MyFragmentListener;

/**
 * Esta Actividad muestra el detalle de un evento utilizando Fragment
 */

public class EventDetailFragmentActivity extends AppCompatActivity implements MyFragmentListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void fragmentAction(Object object) {}

    @Override
    public void goToEventDetail(Object object) {}

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

package com.isil.am2fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.isil.am2fragments.model.StarWarsEvent;
import com.isil.am2fragments.ui.fragments.EventDetailsFragment;
import com.isil.am2fragments.ui.fragments.EventFragment;
import com.isil.am2fragments.ui.fragments.MyFragmentListener;

public class MainFragmentActivity extends AppCompatActivity implements MyFragmentListener {

    private FragmentManager fragmentManager;
    private EventFragment eventFragment;
    private EventDetailsFragment eventDetailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        app();
    }

    private void app() {
        fragmentManager= getSupportFragmentManager();
        eventFragment= (EventFragment) fragmentManager.findFragmentById(R.id.fragmentEvents);
        eventDetailsFragment= (EventDetailsFragment) fragmentManager.findFragmentById(R.id.fragmentDetails);
    }

    @Override
    public void fragmentAction(Object object) {}

    @Override
    public void goToEventDetail(Object object) {

        StarWarsEvent starWarsEvent= (StarWarsEvent)(object);
        if(eventDetailsFragment!=null){
            startEventDetail(starWarsEvent);
        }else{
            sendDataToEventDetail(starWarsEvent);
        }
    }

    private void startEventDetail(StarWarsEvent starWarsEvent){
        Intent intent= new Intent(this,EventDetailFragmentActivity.class);
        intent.putExtra("EVENT",starWarsEvent);
        startActivity(intent);
    }

    private void sendDataToEventDetail(StarWarsEvent starWarsEvent){
        eventDetailsFragment.showEventInfo(starWarsEvent);
    }
}

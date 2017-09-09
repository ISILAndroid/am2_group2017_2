package com.isil.am2fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.isil.am2fragments.data.StarWarsEventData;
import com.isil.am2fragments.model.StarWarsEvent;
import com.isil.am2fragments.ui.adapter.StarWarsEventAdapter;
import com.isil.am2fragments.ui.events.ClickListener;
import com.isil.am2fragments.ui.events.RecyclerTouchListener;

import java.util.List;

/**
 * Este ejemplo esta hecho solo con actividades y
 * muestra un listado de eventos , cuando seleccionas un eventos
 * te manda a otra pantalla con el detalle del evento.
 */
public class StarWarsEventsActivity extends AppCompatActivity {

    private RecyclerView recyclerViewEvents;
    private List<StarWarsEvent> events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_star_wars_events);
        ui();
        loadData();
    }

    private void loadData() {
        events= new StarWarsEventData().generate();
        renderEvents(events);
    }

    private void renderEvents(List<StarWarsEvent> events){
        this.events= events;
        recyclerViewEvents.setAdapter(new StarWarsEventAdapter(this,this.events));

    }
    private void ui() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        recyclerViewEvents= (RecyclerView)findViewById(R.id.recyclerViewEvents);
        recyclerViewEvents.setLayoutManager(new LinearLayoutManager(this));

        //events
        recyclerViewEvents.addOnItemTouchListener(new RecyclerTouchListener(this, recyclerViewEvents, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                if(events!=null){
                    StarWarsEvent starWarsEvent= events.get(position);
                    gotoDetails(starWarsEvent);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void gotoDetails(StarWarsEvent starWarsEvent) {
        Intent intent= new Intent(this,EventDetailsActivity.class);
        intent.putExtra("EVENT",starWarsEvent);
        //intent.putExtra("TITLE",starWarsEvent.getTitle());
        //intent.putExtra("DESC",starWarsEvent.getDescription());
        //intent.putExtra("PHOTO",starWarsEvent.getPhoto());
        startActivity(intent);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}

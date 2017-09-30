package com.isil.am2template;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.isil.am2template.adapters.NoteAdapter;
import com.isil.am2template.model.entity.NoteEntity;
import com.isil.am2template.storage.PreferencesHelper;
import com.isil.am2template.storage.db.CRUDOperations;
import com.isil.am2template.storage.db.MyDatabase;

import java.util.List;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;

    private ListView lstNotes;
    private List<NoteEntity> lsNoteEntities;
    private CRUDOperations crudOperations;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        init();

        //populate();
        loadData();
    }

    private void init() {

        lstNotes= (ListView)(findViewById(R.id.lstNotes));

        //user Info
        String username = PreferencesHelper.getUserSession(this);
        if(username!=null)
        {
            //tviUser.setText("Bienvenido "+ StringUtils.firstCapitalize(username));
        }

        //events
        /*btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });*/

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteEntity noteEntity = (NoteEntity) adapterView.getAdapter().getItem(i);
                //gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

        /*tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });*/
    }

    private void loadData() {
        crudOperations= new CRUDOperations(new MyDatabase(this));
        lsNoteEntities= crudOperations.getAllNotes();
        noteAdapter= new NoteAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapter);

    }

    private void populate() {

        CRUDOperations crudOperations= new CRUDOperations(new MyDatabase(this));
        crudOperations.addNote(new NoteEntity("Mi Nota","Esta es un nota ",null));
        crudOperations.addNote(new NoteEntity("Segunda Nota","Esta es la segunds nota ",null));
        crudOperations.addNote(new NoteEntity("Tercera Nota","Esta es la tercera nota ",null));
        crudOperations.addNote(new NoteEntity("Cuarta Nota","Esta es la cuarta nota ",null));
        crudOperations.addNote(new NoteEntity("Quinta Nota","Esta es la quinta nota ",null));
        crudOperations.addNote(new NoteEntity("Sexta Nota","Esta es la sexta nota ",null));

        Log.v(TAG, "populate " + crudOperations.getAllNotes());
    }


}

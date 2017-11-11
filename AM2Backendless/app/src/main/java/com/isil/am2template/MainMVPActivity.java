package com.isil.am2template;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.isil.am2template.model.entity.NoteBLEntity;
import com.isil.am2template.presenter.MainPresenter;
import com.isil.am2template.presenter.NoteContract;
import com.isil.am2template.storage.PreferencesHelper;
import com.isil.am2template.storage.db.CRUDOperations;
import com.isil.am2template.utils.StringUtils;
import com.isil.am2template.view.adapters.NoteBLAdapter;

import java.util.List;


public class MainMVPActivity extends AppCompatActivity implements NoteContract.NotesView {

    private static final String TAG ="MainActivity" ;
    private static final int ACTION_ADD=1;
    private static final int ACTION_DETAIL=2;

    private TextView tviLogout,tviUser;
    private ListView lstNotes;
    private Button btnAddNote;
    private List<NoteBLEntity> lsNoteEntities;
    private CRUDOperations crudOperations;
    private NoteBLAdapter noteAdapter;

    private MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpPresenter();
        init();
    }

    private void setUpPresenter(){
        mainPresenter= new MainPresenter();
        mainPresenter.attachView(this);
    }

    @Override
    public void showMessage(String message) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void emptyNotes() {

    }

    @Override
    public void retrieveNotes() {
        String token= PreferencesHelper.getTokenSession(this);
        mainPresenter.retrieveNotes(token);
    }

    @Override
    public void gotoNote(int action, NoteBLEntity noteEntity) {
        Intent intent= new Intent(this,NoteActivity.class);

        switch (action)
        {
            case ACTION_ADD:
                intent.putExtra("FRAGMENT",NoteActivity.ADD_NOTE);
                startActivity(intent);
                break;
            case ACTION_DETAIL:
                intent.putExtra("FRAGMENT",NoteActivity.DETAIL_NOTE);
                intent.putExtra("NOTE", noteEntity);
                startActivity(intent);
                break;
        }
    }

    @Override
    public void renderNotes(List<NoteBLEntity> notes) {
        Log.v("CONSOLE", "renderNotes");
        lsNoteEntities= notes;
        noteAdapter= new NoteBLAdapter(this,lsNoteEntities);
        lstNotes.setAdapter(noteAdapter);
    }

    private void init() {
        tviLogout= (TextView)findViewById(R.id.tviLogout);
        tviUser= (TextView)findViewById(R.id.tviUser);
        lstNotes= (ListView)(findViewById(R.id.lstNotes));
        btnAddNote= (Button)(findViewById(R.id.btnAddNote));

        //user Info
        String username = PreferencesHelper.getUserSession(this);
        if(username!=null)
        {
            tviUser.setText("Bienvenido "+ StringUtils.firstCapitalize(username));
        }

        //events
        btnAddNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoNote(ACTION_ADD, null);
            }
        });

        lstNotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                NoteBLEntity noteEntity = (NoteBLEntity) adapterView.getAdapter().getItem(i);
                gotoNote(ACTION_DETAIL, noteEntity);
            }
        });

        tviLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                logout();
            }
        });
    }


    private void logout() {
        PreferencesHelper.signOut(this);
        startActivity(new Intent(this, LoginMVPActivity.class));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v(TAG, "MainActivity onResumen - 2");
        retrieveNotes();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v(TAG, "MainActivity onPause - 1");
    }
}

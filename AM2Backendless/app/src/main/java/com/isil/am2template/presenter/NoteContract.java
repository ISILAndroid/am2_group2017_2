package com.isil.am2template.presenter;


import com.isil.am2template.model.entity.NoteBLEntity;
import com.isil.am2template.model.entity.NoteEntity;

import java.util.List;

/**
 * Created by eduardomedina on 8/11/17.
 */

public interface NoteContract {

    interface NotesView{
        void showMessage(String message);
        void showLoading();
        void hideLoading();
        void emptyNotes();
        void retrieveNotes();
        void renderNotes(List<NoteBLEntity> notes);
        void gotoNote(int action, NoteEntity noteEntity);
    }
}

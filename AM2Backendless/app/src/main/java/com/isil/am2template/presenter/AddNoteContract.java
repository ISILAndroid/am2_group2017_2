package com.isil.am2template.presenter;

/**
 * Created by emedinaa on 17/11/17.
 */

public interface AddNoteContract {

    interface View{
        void showMessage(String message);
        void showLoading();
        void hideLoading();

        void operationSuccess();
    }
}

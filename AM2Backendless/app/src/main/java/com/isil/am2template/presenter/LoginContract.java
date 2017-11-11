package com.isil.am2template.presenter;

/**
 * Created by emedinaa on 27/10/17.
 */

public interface LoginContract {

    public interface View{
        void showLoading();
        void hideLoading();
        void gotoMain();
        void gotoUserRegister();
        void showMessage(String message);
        void saveBLSession(String username,String token);

        boolean validateForm();

        String getUsername();
        String getPassword();
    }
}

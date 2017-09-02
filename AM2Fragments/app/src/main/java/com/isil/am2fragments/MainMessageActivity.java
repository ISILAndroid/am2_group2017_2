package com.isil.am2fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.isil.am2fragments.ui.fragments.MessageListener;
import com.isil.am2fragments.ui.fragments.ShowMessageFragment;
import com.isil.am2fragments.ui.fragments.WriteMessageFragment;

/**
 * Este ejemplo muestra como comunicar los fragments
 * - Comunicar un fragment con la actividad que lo contiene
 * - Comunicar la actividad a un fragment
 * - Comunicar fragments utilizando la actividad que los contiene.
 */
public class MainMessageActivity extends AppCompatActivity implements MessageListener{

    private final String TAG= "CONSOLE";

    private WriteMessageFragment oneFragment;
    private ShowMessageFragment twoFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_message);
        app();
    }

    private void app() {
        fragmentManager= getSupportFragmentManager();
        oneFragment= (WriteMessageFragment) fragmentManager.findFragmentById(R.id.fragmentWriteMessage);
        twoFragment= (ShowMessageFragment) fragmentManager.findFragmentById(R.id.fragmentShowMessage);
    }

    @Override
    public void recibiryEnviardesdeFragment(String message) {
        Log.v(TAG, "2 recibiryEnviarMensaje " + message);
        twoFragment.mostrarMensaje(message);
    }

    public void recibiryEnviarMensaje(String message)
    {
        Log.v(TAG, "2 recibiryEnviarMensaje " + message);
        twoFragment.mostrarMensaje(message);
    }
}

package com.isil.am2fragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.isil.am2fragments.ui.fragments.BlankFragment;
import com.isil.am2fragments.ui.fragments.BlankFragmentListener;

public class FragmentCommunicationActivity extends AppCompatActivity
implements BlankFragmentListener{

    private BlankFragment blankFragment;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communication);

        fragmentManager= getSupportFragmentManager();
        blankFragment= (BlankFragment)fragmentManager.findFragmentById(R.id.blankFragment);

        blankFragment.ejecutarAccionDesdeFragment("Hola Fragment");
    }

    @Override
    public void actionFragment(Object object) {
        String message= String.valueOf(object);
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}

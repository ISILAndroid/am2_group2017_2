package com.isil.am2fragments;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.isil.am2fragments.ui.fragments.BlankFragment;
import com.isil.am2fragments.ui.fragments.BlankFragmentListener;

public class FragmentProgrammingActivity extends AppCompatActivity implements BlankFragmentListener {

    private FrameLayout frameLayoutContainer;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_programming);

        frameLayoutContainer= (FrameLayout) findViewById(R.id.frameLayoutContainer);
        fragmentManager= getSupportFragmentManager();

        addFragment();
    }

    @Override
    public void actionFragment(Object object) {

    }

    private void addFragment(){
        BlankFragment blankFragment= new BlankFragment();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayoutContainer,blankFragment,"BlankFragment");
        fragmentTransaction.commit();
    }
}

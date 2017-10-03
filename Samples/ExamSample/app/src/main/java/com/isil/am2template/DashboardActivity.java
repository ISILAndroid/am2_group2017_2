package com.isil.am2template;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.isil.am2template.fragments.FavoritePlaceFragment;
import com.isil.am2template.fragments.MyPinFragment;
import com.isil.am2template.listeners.OnNavListener;

public class DashboardActivity extends AppCompatActivity implements OnNavListener {

    private final int MENU_FAVORITE= 103;
    private final int MENU_MY_PIN= 101;
    private final int MENU_EXIT= 104;

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        // Initializing Toolbar and setting it as the actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initializing NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {


                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);

                //Closing drawer on item click
                drawerLayout.closeDrawers();

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {


                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.menuPin:
                        changeFragment(MENU_MY_PIN);
                        return true;

                    case R.id.menuCard:
                        //Toast.makeText(getApplicationContext(),"Stared Selected",Toast.LENGTH_SHORT).show();
                        //changeFragment(1);
                        return true;
                    case R.id.menuTravel:
                        return true;

                    case R.id.menuFavorite:
                        //Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        changeFragment(MENU_FAVORITE);
                        return true;
                    case R.id.menuNews:
                        //Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        //changeFragment(2);
                        return true;

                    case R.id.menuExit:
                        //Toast.makeText(getApplicationContext(),"Send Selected",Toast.LENGTH_SHORT).show();
                        //changeFragment(2);
                        changeFragment(MENU_EXIT);
                        return true;
                    default:
                        return true;

                }

            }
        });

        // Initializing Drawer Layout and ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerClosed(View drawerView) {
                // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                super.onDrawerOpened(drawerView);
            }
        };

        //Setting the actionbarToggle to drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
        changeFragment(0);
        navigationView.setCheckedItem(R.id.menuAndroid);

    }

    private void changeFragment(int i) {
        Fragment fragment = null;
        switch (i) {
            case MENU_MY_PIN:
                fragment = new MyPinFragment();
                break;
            case MENU_FAVORITE:
                fragment = new FavoritePlaceFragment();
                break;
            case MENU_EXIT:
                logout();
                return;
        }
        if (fragment != null) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame, fragment);
            fragmentTransaction.commit();
        }
    }

    private void logout() {
        //clear session
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}

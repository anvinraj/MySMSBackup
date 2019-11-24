package com.anvi.MySMS;

import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.anvi.MySMS.utilities.DetectConnection;
import com.anvi.nearme.utilities.CheckAndRequestPermission;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    public static NavigationView navigationView;
    public static DrawerLayout drawer;
    private ImageView nav_open;
    com.anvi.nearme.utilities.CheckAndRequestPermission crp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);//for keeping scrren on during this activity
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_main);



        drawer= (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.setBackgroundResource(R.drawable.gradient);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        toggle.setDrawerIndicatorEnabled(false);
        navigationView = (NavigationView) findViewById(R.id.navigation_drawer_container);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setBackgroundResource(R.drawable.nav_gradient);

        nav_open=(ImageView)findViewById(R.id.nav_open);
        //welcome_name=(TextView)findViewById(R.id.user_name);

        nav_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawer.openDrawer(GravityCompat.START);
            }
        });

        crp = new CheckAndRequestPermission();
        crp.checkAndRequestPermissions(this);

        if (DetectConnection
                .checkInternetConnection(getApplicationContext())) {


        } else {
            Toast.makeText(getApplicationContext(), "Oops Your Connection Seems Off..!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);

        } else {

        }
    }
    public boolean onNavigationItemSelected(MenuItem item) {

        return true;
    }


}

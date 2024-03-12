package com;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.constiutionofindia.Information_PartsActivity;
import com.example.constiutionofindia.R;
import com.google.android.material.navigation.NavigationView;

public class Parliments_Activity extends AppCompatActivity {

    CardView card1, card2, card3, card4, card5, card6;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageView toggle;

    Animation together, slidedown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parliments);

        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.blue_dark))));



        drawerLayout = findViewById(R.id.dwawerlayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);
        toggle = findViewById(R.id.toggle);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
        card5 = findViewById(R.id.card5);
        card6 = findViewById(R.id.card6);

        slidedown = AnimationUtils.loadAnimation(Parliments_Activity.this,R.anim.slide_down) ;

        card1.setAnimation(slidedown);
        card2.setAnimation(slidedown);
        card3.setAnimation(slidedown);
        card4.setAnimation(slidedown);
        card5.setAnimation(slidedown);
        card6.setAnimation(slidedown);


        card1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, Preamble_Activity.class);
                startActivity(intent);


            }
        });

        card2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, Parts_Activity.class);
                startActivity(intent);


            }
        });
        card3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, Schedule_Activity.class);
                startActivity(intent);


            }
        });
        card4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, Amendment_Activity.class);
                startActivity(intent);


            }
        });

        card5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, News_ArticlesActivity.class);
                startActivity(intent);


            }
        });

        card6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Parliments_Activity.this, Case_StudiesActivity.class);
                startActivity(intent);


            }
        });

        navigationView.bringToFront();
        setSupportActionBar(toolbar);

        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.optHome) {

                    Toast.makeText(Parliments_Activity.this, "Home", Toast.LENGTH_SHORT).show();


                } else if (id == R.id.notes) {

                    Intent i = new Intent(getApplicationContext(), Note_editerActivity.class);
                    startActivity(i);

                }
                 else if (id == R.id.about) {

                    Intent i = new Intent(getApplicationContext(), About_Activity.class);
                    startActivity(i);
                } else if (id == R.id.nightmode) {

                    Intent i = new Intent(getApplicationContext(), Mode_Activity.class);
                    startActivity(i);

                } else{
                    Toast.makeText(Parliments_Activity.this, "Rate Us", Toast.LENGTH_SHORT).show();
            }

            drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }
        });

}

private void loadFragment(Fragment fragment){

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.container,fragment);
        ft.commit();

}


    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

}




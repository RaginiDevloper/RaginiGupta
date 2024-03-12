package com.trycatch_ragini.practice_papers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.trycatch_ragini.pratice_paper.R;

public class Subjects_Activity extends AppCompatActivity {

    ImageView jee, abc, winner, dna;

    CardView cardView1, cardView2, cardView3, cardView4;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);

        getWindow().setStatusBarColor(Integer.parseInt(String.valueOf(getColor(R.color.lightblack))));

        drawerLayout = findViewById(R.id.Drawerlayout);
        navigationView = findViewById(R.id.navigationView);
        toolbar = findViewById(R.id.toolbar);

        jee = findViewById(R.id.jee);
        winner = findViewById(R.id.winner);
        abc = findViewById(R.id.abc);
        dna = findViewById(R.id.dna);

        cardView1 = findViewById(R.id.cardview1);
        cardView2 = findViewById(R.id.cardview2);
        cardView3 = findViewById(R.id.cardview3);
        cardView4 = findViewById(R.id.cardview4);

        jee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, JEE_ButtonActivity.class);
                startActivity(intent);


            }
        });

        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, MHcet_Activity.class);
                startActivity(intent);


            }
        });

        winner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, JeeAdvance_Activity.class);
                startActivity(intent);


            }
        });

        dna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, NEET_ButtonActivity.class);
                startActivity(intent);


            }
        });


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, JEE_ButtonActivity.class);
                startActivity(intent);


            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, JeeAdvance_Activity.class);
                startActivity(intent);


            }
        });

        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, MHcet_Activity.class);
                startActivity(intent);


            }
        });

        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Subjects_Activity.this, NEET_ButtonActivity.class);
                startActivity(intent);


            }
        });


        navigationView.bringToFront();
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.OpenDrawer, R.string.CloseDrawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();
                if (id==R.id.optHome) {
                    Toast.makeText(Subjects_Activity.this, "Home", Toast.LENGTH_SHORT).show();

                }
                if (id==R.id.aboutus){

                    Intent i = new Intent(getApplicationContext(), AboutUsActivity.class);
                    startActivity(i);
//                 getSupportFragmentManager().beginTransaction().replace(R.id.container, new Aboutus_Fragment()).commit();
//                    getSupportActionBar().setTitle(item.getTitle());

                }
//                }else if (id==R.id.optSharing){
//                    loadFragment(new Share_Fragment());
//
//
//                }else {
//                    loadFragment(new Aboutus_Fragment());
//
//                }
                    drawerLayout.closeDrawer(GravityCompat.START);


                return true;
            }

        });


    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.container, fragment);
        ft.commit();

    }
}
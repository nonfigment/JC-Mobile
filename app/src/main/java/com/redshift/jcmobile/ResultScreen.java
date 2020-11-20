package com.redshift.jcmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.redshift.jcmobile.tutorial.WelcomeScreen;
import com.redshift.jumpcalc.DataStorage;
import com.redshift.jumpcalc.Util;

public class ResultScreen<getResult> extends AppCompatActivity {
    private CardView results;
    String ship1name = JCApp.shipStorage.ship1.name;
    String ship2name = JCApp.shipStorage.ship2.name;
    float ship1range = JCApp.shipStorage.ship1.range;
    float ship2range = JCApp.shipStorage.ship2.range;
    int ship1routeTime = JCApp.shipStorage.ship1.routeTime;
    int ship2routeTime = JCApp.shipStorage.ship2.routeTime;
    float distance = DataStorage.getDistance();
    int jumpscount = DataStorage.getJumpscount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

        if (JCApp.shipStorage.ship1 == null || JCApp.shipStorage.ship2 == null) {
            finish();
        } else {
            displayResults();
        }

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
        }

        FloatingActionButton fab = findViewById(R.id.fab_rerun);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                processRerunBtnClick();
            }
        });


        //       resultFirstShip.setText(ship1routeTime);


    }

    public void displayResults() {
        TextView resultFirstShip = findViewById(R.id.resultFirstShip);
        resultFirstShip.setText(getString(R.string.RSfirstShipName, ship1name, Util.timeFormatter(ship1routeTime)));
        TextView resultSecondShip = findViewById(R.id.resultSecondShip);
        resultSecondShip.setText(getString(R.string.RSsecondShipName, ship2name, Util.timeFormatter(ship2routeTime)));
        TextView totalDistance = findViewById(R.id.resultTotalDistance);
        totalDistance.setText(getString(R.string.RStotalDistance, distance));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    private void processRerunBtnClick() {
        Intent replayCalc = new Intent(this, MainActivity.class);
        startActivity(replayCalc);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            case R.id.mainMenuShowWSBtn:
                Intent showWS = new Intent(this, WelcomeScreen.class);
                startActivity(showWS);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
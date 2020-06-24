package com.redshift.jcmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.redshift.jcmobile.tutorial.WelcomeScreen;

public class ResultScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_screen);

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }

    private void processRerunBtnClick() {
        Intent replayCalc = new Intent (this, MainActivity.class);
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
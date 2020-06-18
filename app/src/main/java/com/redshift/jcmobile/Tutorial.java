package com.redshift.jcmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Tutorial extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial);
        Button endTutorial = findViewById(R.id.ws_btn_end_tutorial);

        endTutorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    processClick();
                } catch (Exception e) {
                    Log.e(Util.TAG, "Error! ");
                }
            }
        });
    }
        private void processClick () {
            Intent calcScreen = new Intent(this, MainActivity.class);
            startActivity(calcScreen);
        }
    }

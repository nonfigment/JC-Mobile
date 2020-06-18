package com.redshift.jcmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeScreen extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        Button startTutorialButton = findViewById(R.id.ws_btn_start_tutorial);
        Button endTutorialButton = findViewById(R.id.ws_btn_end_tutorial);

        startTutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    processClickStartButton();
                } catch (Exception e) {
                    Log.e(TAG, "Error encountered while processed click", e);
                }
            }
        });
    }

    private void processClickStartButton() {
        Intent intent = new Intent(this, Tutorial.class);
        startActivity(intent);
    }
}
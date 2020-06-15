package com.redshift.jcmobile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.redshift.jumpcalc.Logic;
import com.redshift.jumpcalc.Ship;

public class MainActivity extends AppCompatActivity {

    private EditText shipNameEdit;
    private EditText ship2NameEdit;
    private EditText shipRangeEdit;
    private EditText ship2RangeEdit;
    private EditText distanceEdit;
    private EditText jumpsCountEdit;
    private Button submitButton;

    private final static String TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pref = getSharedPreferences("myPref", MODE_PRIVATE);
        if (pref.getBoolean("firststart", true)) {
            SharedPreferences.Editor editor = pref.edit();
            editor.putBoolean("firststart", false);
            editor.apply();
            Intent intent = new Intent(this, WelcomeScreen.class);
            startActivity(intent);

        }
        submitButton = findViewById(R.id.button);
        shipNameEdit = findViewById(R.id.mainShipNameEditText);
        ship2NameEdit = findViewById(R.id.mainShip2NameEditText);
        shipRangeEdit = findViewById(R.id.mainShipRangeEditText);
        ship2RangeEdit = findViewById(R.id.mainShip2RangeEditText);
        distanceEdit = findViewById(R.id.mainDistanceEditTextNumber2);
        jumpsCountEdit = findViewById(R.id.mainJumpsCountEditTextNumber);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    processClick();
                } catch (Exception e) {
                    Log.e(TAG, "submitButton click process error", e);
                    Toast.makeText(MainActivity.this, "Error!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }


    private void processClick() {
        Log.d(TAG, "Start process");

        Ship ship1 = new Ship();
        ship1.name = Util.getString(shipNameEdit);
        ship1.range = Util.getFloat(shipRangeEdit, 1);

        Ship ship2 = new Ship();
        ship2.name = Util.getString(ship2NameEdit);
        ship2.range = Util.getFloat(ship2RangeEdit, 1);

        float distance = Util.getFloat(distanceEdit, 1);
        int jumpscount = Util.getInt(jumpsCountEdit);

        Logic logic = new Logic();
        logic.calc(distance, jumpscount, ship1, ship2);
    }
}
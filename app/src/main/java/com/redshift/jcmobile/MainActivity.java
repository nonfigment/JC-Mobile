package com.redshift.jcmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.redshift.jumpcalc.Logic;
import com.redshift.jumpcalc.Ship;
import com.redshift.jumpcalc.Util;

import static java.lang.Float.parseFloat;

public class MainActivity extends AppCompatActivity {

    private EditText shipNameEdit;
    private EditText ship2NameEdit;
    private EditText shipRangeEdit;
    private EditText ship2RangeEdit;
    private EditText distanceEdit;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submitButton = findViewById(R.id.button);
        shipNameEdit = findViewById(R.id.mainShipNameEditText);
        ship2NameEdit = findViewById(R.id.mainShip2NameEditText);
        shipRangeEdit = findViewById(R.id.mainShipRangeEditText);
        ship2RangeEdit = findViewById(R.id.mainShip2RangeEditText);
        distanceEdit = findViewById(R.id.mainDistanceEditTextNumber2);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processClick();
            }
        });
    }



    private void processClick() {

        Ship ship1 = new Ship();
        Ship ship2 = new Ship();

        float distance;

        ship1.name = shipNameEdit.getText().toString();
        ship1.range = parseFloat(ship2RangeEdit.getText().toString());
        ship2.name = shipNameEdit.getText().toString();
        ship2.range = parseFloat(ship2RangeEdit.getText().toString());
        distance = parseFloat(distanceEdit, getText().toString());

        Logic logic = new Logic();
        logic.calc(distance, ship1, ship2);

        System.out.printf("%s route time: %s%n", ship1.name, Util.timeFormatter(ship1.routeTime));
        System.out.printf("%s route time: %s%n", ship2.name, Util.timeFormatter(ship2.routeTime));


    }
}
package com.tvchatten.floortileapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    double rmLength; //length of room in feet
    double rmWidth; //width of room in feet
    double numTiles; //number of tiles needed
    double area; // area of the room

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        final EditText length = (EditText) findViewById(R.id.txtLength);
        final EditText width = (EditText) findViewById(R.id.txtWidth);
        final RadioButton radSmall = (RadioButton) findViewById(R.id.radSmallTile);
        final RadioButton radLarge = (RadioButton) findViewById(R.id.radLargeTile);
        final TextView result = (TextView) findViewById(R.id.txtResult);
        Button convert = (Button) findViewById(R.id.btnResult);

        convert.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                rmLength = Double.parseDouble(length.getText().toString());
                rmWidth = Double.parseDouble(width.getText().toString());
                if (radSmall.isChecked()) {
                    if (rmLength >= 1 && rmLength <= 2000 && rmWidth >= 1 && rmLength <= 2000) {
                        area = rmLength * rmWidth;
                        numTiles = area;
                        DecimalFormat whole = new DecimalFormat("#,###");
                        result.setText(whole.format(numTiles));
                    } else {
                        Toast.makeText(MainActivity.this, "The number of feet must be between 1 and 2000,", Toast.LENGTH_LONG).show();
                    }
                }
                else if (radLarge.isChecked()) {
                    if (rmLength >= 1 && rmLength <= 2000 && rmWidth >= 1 && rmLength <= 2000) {
                        area = rmLength * rmWidth;
                        numTiles = area / 1.5;
                        DecimalFormat whole = new DecimalFormat("#,###");
                        result.setText(whole.format(numTiles));
                    } else {
                        Toast.makeText(MainActivity.this, "The number of feet must be between 1 and 2000.", Toast.LENGTH_LONG).show();
                    }
                }
            }

        });
    }

}
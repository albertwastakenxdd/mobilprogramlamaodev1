package com.example.myapplication;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private SeekBar seekBarMin;
    private SeekBar seekBarMax;
    private Button buttonGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        seekBarMin = findViewById(R.id.seekBarMin);
        seekBarMax = findViewById(R.id.seekBarMax);
        buttonGenerate = findViewById(R.id.buttonGenerate);

        seekBarMin.setMin(1);
        seekBarMax.setMax(20);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int min = seekBarMin.getProgress();
                int max = seekBarMax.getProgress();

                Random random = new Random();
                int randomNumber = random.nextInt(max - min + 1) + min;

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("randomNumber", randomNumber);
                startActivity(intent);
            }
        });
    }
}



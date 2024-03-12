package com.example.myapplication;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.graphics.Color; // Assuming you need Color for background color
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets; // Only if you need to handle window insets

public class SecondActivity extends AppCompatActivity {

    private TextView textViewRandomNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewRandomNumber = findViewById(R.id.textViewRandomNumber);

        Intent intent = getIntent();
        int randomNumber = intent.getIntExtra("randomNumber", 0);

        textViewRandomNumber.setText(String.valueOf(randomNumber));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Random random = new Random();
                int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));

                getWindow().getDecorView().setBackgroundColor(color);

                new Handler().postDelayed(this, 2000);
            }
        }, 0);
    }
}

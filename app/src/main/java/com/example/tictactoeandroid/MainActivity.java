package com.example.tictactoeandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    Button aButtons[][] = new Button[3][3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aButtons[0][0] = findViewById(R.id.b00);
        aButtons[0][1] = findViewById(R.id.b01);
        aButtons[0][2] = findViewById(R.id.b02);
        aButtons[1][0] = findViewById(R.id.b10);
        aButtons[1][1] = findViewById(R.id.b11);
        aButtons[1][2] = findViewById(R.id.b12);
        aButtons[2][0] = findViewById(R.id.b20);
        aButtons[2][1] = findViewById(R.id.b21);
        aButtons[2][2] = findViewById(R.id.b22);
    }




}
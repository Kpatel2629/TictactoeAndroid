package com.example.tictactoeandroid;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {


    Button aButtons[][] = new Button[3][3];
    int turn_count = 0;
    TextView tvInfo;
    Button buttonReset;
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



        aButtons[0][0].setOnClickListener(this);


        //A button that reset the Game
        buttonReset = (Button) findViewById(R.id.buttonReset);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }

    @Override
    public void onClick(View view){

    }




}
package com.example.tictactoeandroid;
import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {

    boolean playerX = true;
    int[][] bStatus = new int[3][3];
    int turn_count = 0;
    TextView tvInfo;
    Button buttonReset;

    Button buttons00 ;
    Button buttons01 ;
    Button buttons02 ;
    Button buttons10 ;
    Button buttons11 ;
    Button buttons12 ;
    Button buttons20 ;
    Button buttons21 ;
    Button buttons22 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         buttons00 = findViewById(R.id.b00);
         buttons01 = findViewById(R.id.b01);
         buttons02 = findViewById(R.id.b02);
         buttons10 = findViewById(R.id.b10);
         buttons11 = findViewById(R.id.b11);
         buttons12 = findViewById(R.id.b12);
         buttons20 = findViewById(R.id.b20);
         buttons21 = findViewById(R.id.b21);
         buttons22 = findViewById(R.id.b22);

        //Bind each button to the event listener
        buttons00.setOnClickListener(this);
        buttons01.setOnClickListener(this);
        buttons02.setOnClickListener(this);
        buttons10.setOnClickListener(this);
        buttons11.setOnClickListener(this);
        buttons12.setOnClickListener(this);
        buttons20.setOnClickListener(this);
        buttons21.setOnClickListener(this);
        buttons22.setOnClickListener(this);




        //A button that reset the Game
        buttonReset = findViewById(R.id.buttonReset);

        tvInfo =  findViewById(R.id.tvInfo);
        buttonReset.setOnClickListener(this);

        initializeBoardStatus();
    }

    @Override
    public void onClick(View view){

        boolean resetButtonPressed = false;

        switch (view.getId()){
            case R.id.b00:
                if(playerX){
                    buttons00.setText("X");
                    bStatus[0][0] = 1;
                }
                else{
                    buttons00.setText("0");
                    bStatus[0][0] = 0;
                }
                buttons00.setEnabled(false);
                break;

            case R.id.b01:
                if(playerX){
                    buttons01.setText("X");
                    bStatus[0][1] = 1;
                }
                else{
                    buttons01.setText("0");
                    bStatus[0][1] = 0;
                }
                buttons01.setEnabled(false);
                break;

            case R.id.b02:
                if(playerX){
                    buttons02.setText("X");
                    bStatus[0][2] = 1;
                }
                else{
                    buttons02.setText("0");
                    bStatus[0][2] = 0;
                }
                buttons02.setEnabled(false);
                break;

            case R.id.b10:
                if(playerX){
                    buttons10.setText("X");
                    bStatus[1][0] = 1;
                }
                else{
                    buttons10.setText("0");
                    bStatus[1][0] = 0;
                }
                buttons10.setEnabled(false);
                break;

            case R.id.b11:
                if(playerX){
                    buttons11.setText("X");
                    bStatus[1][1] = 1;
                }
                else{
                    buttons11.setText("0");
                    bStatus[1][1] = 0;
                }
                buttons11.setEnabled(false);
                break;

            case R.id.b12:
                if(playerX){
                    buttons12.setText("X");
                    bStatus[1][2] = 1;
                }
                else{
                    buttons12.setText("0");
                    bStatus[1][2] = 0;
                }
                buttons12.setEnabled(false);
                break;

            case R.id.b20:
                if(playerX){
                    buttons20.setText("X");
                    bStatus[2][0] = 1;
                }
                else{
                    buttons20.setText("0");
                    bStatus[2][0] = 0;
                }
                buttons20.setEnabled(false);
                break;

            case R.id.b21:
                if(playerX){
                    buttons21.setText("X");
                    bStatus[2][1] = 1;
                }
                else{
                    buttons21.setText("0");
                    bStatus[2][1] = 0;
                }
                buttons21.setEnabled(false);
                break;

            case R.id.b22:
                if(playerX){
                    buttons22.setText("X");
                    bStatus[2][2] = 1;
                }
                else{
                    buttons22.setText("0");
                    bStatus[2][2] = 0;
                }
                buttons22.setEnabled(false);
                break;

            case R.id.buttonReset:
                resetButtonPressed = true;
                break;

            default:
                break;

        }

        if(resetButtonPressed){
            resetBoard();
        }
        else{
            turn_count ++;
            playerX = !playerX;

            if(playerX){
                setInfo("Player X turn");
            }
            else {
                setInfo("Player 0 turn");
            }

            if(turn_count==9){
                result("Game Draw");
            }

            checkWinner();
        }
    }

    private void checkWinner(){


        //Horizontal --- rows
        for(int i=0; i<3; i++){
            if(bStatus[i][0] == bStatus[i][1] && bStatus[i][0] == bStatus[i][2]){
                if (bStatus[i][0]==1){
                    result("Player X winner\n" + (i+1)+" row");
                    break;
                }
                else if (bStatus[i][0]==0) {
                    result("Player 0 winner\n" + (i+1)+" row");
                    break;
                }
            }
        }

        //Vertical --- columns
        for(int i=0; i<3; i++){
            if(bStatus[0][i] == bStatus[1][i] && bStatus[0][i] == bStatus[2][i]){
                if (bStatus[0][i]==1){
                    result("Player X winner\n" + (i+1)+" column");
                    break;
                }
                else if (bStatus[0][i]==0) {
                    result("Player 0 winner\n" + (i+1)+" column");
                    break;
                }
            }
        }

        //First diagonal
        if(bStatus[0][0] == bStatus[1][1] && bStatus[0][0] == bStatus[2][2]){
            if (bStatus[0][0]==1){
                result("Player X winner\nFirst Diagonal");
            }
            else if (bStatus[0][0]==0) {
                result("Player 0 winner\nFirst Diagonal");
            }
        }

        //Second diagonal
        if(bStatus[0][2] == bStatus[1][1] && bStatus[0][2] == bStatus[2][0]){
            if (bStatus[0][2]==1){
                result("Player X winner\nSecond Diagonal");
            }
            else if (bStatus[0][2]==0) {
                result("Player 0 winner\nSecond Diagonal");
            }
        }
    }

    private void enableAllBoxes(boolean value){

        buttons00.setEnabled(value);
        buttons01.setEnabled(value);
        buttons02.setEnabled(value);

        buttons10.setEnabled(value);
        buttons11.setEnabled(value);
        buttons12.setEnabled(value);

        buttons20.setEnabled(value);
        buttons21.setEnabled(value);
        buttons22.setEnabled(value);
    }

    private void result(String winner){

        setInfo(winner);
        enableAllBoxes(false);
    }

    private void resetBoard(){
        buttons00.setText("");
        buttons01.setText("");
        buttons02.setText("");

        buttons10.setText("");
        buttons11.setText("");
        buttons12.setText("");

        buttons20.setText("");
        buttons21.setText("");
        buttons22.setText("");

        enableAllBoxes(true);

        playerX = true;
        turn_count = 0;

        initializeBoardStatus();

        setInfo("Start Again!!!");

        Toast.makeText(this,"Board Reset",Toast.LENGTH_SHORT).show();
    }

    private void setInfo(String text){
        tvInfo.setText(text);
    }

    private void initializeBoardStatus(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                bStatus[i][j] = -1;
            }
        }

    }

}


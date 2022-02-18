package com.example.rockpaperscissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button rock,paper,scissors;
    TextView computerScore,userScore,result,computerChoices;
    int comScr=0,userScr=0,comChoices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock=            findViewById(R.id.rockBtn);
        paper=           findViewById(R.id.paperBtn);
        scissors=        findViewById(R.id.scissorsBtn);
        computerScore=   findViewById(R.id.computerScore);
        userScore=       findViewById(R.id.userScore);
        result=          findViewById(R.id.result);
        computerChoices= findViewById(R.id.computerChoices);
    }

    public void mainClick(View view) {
        switch (view.getId())
        {
            case R.id.rockBtn:computerChoices(1);
                break;
            case R.id.paperBtn:computerChoices(2);
                break;
            case R.id.scissorsBtn:computerChoices(3);
                break;
        }
    }
    public void computerChoices(int userChoice){
        comChoices=(int)(Math.random()*3+1);
        String comName;
        if (comChoices==1){
            comName="ROCK";
        }
        else if (comChoices==2){
            comName="PAPER";
        }
        else
            comName="SCISSORS";
        if ((comChoices==1&&userChoice==1)||(comChoices==2&&userChoice==2)||(comChoices==3&&userChoice==3)){
            result.setText("DRAW!!!");
            computerChoices.setText(comName);

        }
        else if ((comChoices==1&&userChoice==3)||(comChoices==3&&userChoice==2)||(comChoices==2&&userChoice==1)){
            result.setText("COMPUTER WIN!!!");
            comScr++;
            computerScore.setVisibility(View.VISIBLE);
            computerScore.setText(String.valueOf(comScr));
            computerChoices.setText(comName);

        }
        else{
            result.setText("USER WIN!!!");
            userScr++;
            userScore.setVisibility(View.VISIBLE);
            userScore.setText(String.valueOf(userScr));
            computerChoices.setText(comName);


        }
    }
}
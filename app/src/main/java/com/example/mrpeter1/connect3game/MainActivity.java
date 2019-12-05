package com.example.mrpeter1.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //dari menit 25 nonton ulang

    // 0 = yellow , 1 = red, 2 = empty
    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    int [][] winningPositions = {{0,1,2}, {3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
    int activePlayer = 0;

    boolean gameActive = true;
    public  void dropIn(View view){


        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);

        Log.i("tag", counter.getTag().toString());
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2 & gameActive) {


            gameState[tappedCounter] = activePlayer; // belum ngerti yang ini

            if (activePlayer == 0) {

                counter.setImageResource(R.drawable.yellow);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.red);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

            for (int[] winningPosition : winningPositions) {
                if (gameState[winningPosition[0]] == gameState[winningPosition[1]]
                        && gameState[winningPosition[1]] == gameState[winningPosition[2]] && gameState[winningPosition[0]] != 2) {

                    String winner = "";
                    gameActive = false;
                    if (activePlayer == 1) {

                        winner = " yellow ";
                    } else {

                        winner = " red ";
                    }
                    Toast.makeText(this, winner + "has won!", Toast.LENGTH_SHORT).show();
                }


            }
        }


    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

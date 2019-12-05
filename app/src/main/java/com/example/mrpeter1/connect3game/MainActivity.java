package com.example.mrpeter1.connect3game;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    // 0 = yellow , 1 = red
    int activePlayer = 0;
    public  void dropIn(View view){


        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        if (activePlayer == 0 ){

            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;
        } else {
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;
        }

        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}

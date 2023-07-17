package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    int cnt =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.txt);
    }
    Handler myHandler = new Handler();
    public void start(View v)
    {
        myHandler.postDelayed(threadCount,0);
    }

    public void stop(View v)
    {
        cnt =0;
        myHandler.removeCallbacks(threadCount);
    }

    Runnable threadCount = new Runnable() {
        @Override
        public void run() {
            cnt++;
            txt.setText(""+cnt);
            myHandler.postDelayed(threadCount,100);
        }
    };
}
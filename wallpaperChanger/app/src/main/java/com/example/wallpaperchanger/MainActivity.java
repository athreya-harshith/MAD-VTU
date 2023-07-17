package com.example.wallpaperchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    boolean running = false;
    int [] img = new int[]{R.drawable.wpa,R.drawable.wpb,R.drawable.wpc};
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.change);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(!running)
        {
            new Timer().schedule(new MyTimer(),0,100);
            running = false;
        }
    }

    class MyTimer extends TimerTask
    {

        @Override
        public void run() {
            WallpaperManager wp = WallpaperManager.getInstance(getBaseContext());
            Random rand = new Random();
            i = rand.nextInt(3);
            try {
                wp.setBitmap(BitmapFactory.decodeResource(getResources(),img[i]));
            }
           catch (Exception e){}

        }
    }
}
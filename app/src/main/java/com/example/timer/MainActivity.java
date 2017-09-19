package com.example.timer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Chronometer;
import android.os.SystemClock;
import android.support.annotation.Nullable;

public class MainActivity extends AppCompatActivity {

    private Chronometer timer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (Chronometer) findViewById(R.id.timer);
    }

    public void btnClick(View view) {
        timer.setBase(SystemClock.elapsedRealtime());//timer reset-up
        int hour = (int) ((SystemClock.elapsedRealtime() - timer.getBase()) / 1000 / 60);
        timer.setFormat("0"+String.valueOf(hour)+":%s");
        timer.start();
    }

    public void stopClick(View view) {
        timer.stop();
    }

    public void sendMessage(View view){
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        startActivity(intent);
    }

}
package com.mafaz.backgroundmusicplayer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button start;
    Button stop;
    EditText input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input=(EditText)findViewById(R.id.inputtext);

         start = (Button) findViewById(R.id.start);
         stop = (Button)findViewById(R.id.stop);

        start.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if(view==start){
            ////startService(new Intent(this,musicService.class));
            startService();


        }else if(view==stop){
           // stopService(new Intent(this,musicService.class));
            stopService();
        }


    }

    public void startService() {
        String inputdata= String.valueOf(input.getText());
        Intent serviceIntent = new Intent(this, musicService.class);
        serviceIntent.putExtra("inputExtra", inputdata);
        ContextCompat.startForegroundService(this, serviceIntent);
    }
    public void stopService() {
        Intent serviceIntent = new Intent(this, musicService.class);
        stopService(serviceIntent);
    }
}

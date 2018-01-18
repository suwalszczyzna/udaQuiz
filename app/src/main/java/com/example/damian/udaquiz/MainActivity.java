package com.example.damian.udaquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.cosmos_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {;
                Intent intent = new Intent(getBaseContext(), CosmosActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.music_btn).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MusicActivity.class);
                startActivity(intent);
            }
        });



    }




}

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

        @Override
    public void onBackPressed() {

        quitingDialog();


    }

    public void quitingDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder
                .setTitle("Do you want exit game?");
         builder
                 .setCancelable(false)
                 .setPositiveButton("yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        MainActivity.this.finish();
                    }
                })
                .setNegativeButton("no",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });
         builder.create();
         builder.show();
    }


}

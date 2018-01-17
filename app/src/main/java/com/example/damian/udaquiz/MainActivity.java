package com.example.damian.udaquiz;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private boolean isBackBtnPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button cosmos_btn = (Button) findViewById(R.id.cosmos_btn);

        OnClickListener onClickListener = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), CosmosActivity.class);
                startActivity(intent);
            }
        };
        cosmos_btn.setOnClickListener(onClickListener);



    }


}

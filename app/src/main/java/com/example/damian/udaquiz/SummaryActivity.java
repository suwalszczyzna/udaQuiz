package com.example.damian.udaquiz;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SummaryActivity extends AppCompatActivity {

    public TextView summaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        String maxPoints;
        String points;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                maxPoints = "?";
                points = "?";
            } else {
                maxPoints = extras.getString("maxPointsString");
                points = extras.getString("pointsString");
            }
        } else {
            maxPoints = (String) savedInstanceState.getSerializable("maxPointsString");
            points = (String) savedInstanceState.getSerializable("pointsString");
        }
        summaryText =  findViewById(R.id.summary_text_sum);
        summaryText.setText(String.format("You've got\n%s / %s points!", points, maxPoints));


        Button resetButton = findViewById(R.id.reset_game_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SummaryActivity.this, MainActivity.class);
                finish();
                startActivity(i);
            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("summary_text", summaryText.getText().toString());

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        summaryText.setText(savedInstanceState.getString("summary_text"));
    }

}

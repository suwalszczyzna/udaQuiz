package com.example.damian.udaquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SummaryActivity extends AppCompatActivity {

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
        TextView summaryText = (TextView) findViewById(R.id.summary_text_sum);
        summaryText.setText(String.format("You've got\n%s / %s points!", points, maxPoints));


        Button resetButton = (Button) findViewById(R.id.reset_game_button);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SummaryActivity.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}

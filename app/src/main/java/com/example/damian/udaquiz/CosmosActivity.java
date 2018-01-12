package com.example.damian.udaquiz;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class CosmosActivity extends AppCompatActivity {

    private String name;
    private int points = 0;
    private int allPoints = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmos);

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(submitListener);

    }
    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
         submitAnswers();
        }
    };

    public void submitAnswers (){
        EditText myName = (EditText) findViewById(R.id.name_cosmos);

        CheckBox q2_check1 = (CheckBox) findViewById(R.id.q2_check1);
        CheckBox q2_check2 = (CheckBox) findViewById(R.id.q2_check2);
        CheckBox q2_check3 = (CheckBox) findViewById(R.id.q2_check3);
        CheckBox q2_check4 = (CheckBox) findViewById(R.id.q2_check4);

        RadioButton q3_radioButton1 = (RadioButton) findViewById(R.id.q3_radioButton1);
        RadioButton q3_radioButton2 = (RadioButton) findViewById(R.id.q3_radioButton2);
        RadioButton q3_radioButton3 = (RadioButton) findViewById(R.id.q3_radioButton3);
        RadioButton q3_radioButton4 = (RadioButton) findViewById(R.id.q3_radioButton4);

        RadioButton q4_radioButton1 = (RadioButton) findViewById(R.id.q4_radioButton1);
        RadioButton q4_radioButton2 = (RadioButton) findViewById(R.id.q4_radioButton2);
        RadioButton q4_radioButton3 = (RadioButton) findViewById(R.id.q4_radioButton3);
        RadioButton q4_radioButton4 = (RadioButton) findViewById(R.id.q4_radioButton4);

        name = String.valueOf(myName.getEditableText());
        if(q2_check2.isChecked()){
            points++;
        }
        if(q2_check3.isChecked()){
            points++;
        }
        if(q3_radioButton2.isChecked()){
            points++;
        }
        if(q4_radioButton4.isChecked()){
            points++;
        }



        Context context = getApplicationContext();
        CharSequence text = "You've got " + String.valueOf(points)+ " / "+String.valueOf(allPoints);
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

}

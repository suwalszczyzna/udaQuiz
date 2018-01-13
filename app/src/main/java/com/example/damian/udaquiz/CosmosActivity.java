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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmos);

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(submitListener);



        Question question1 = new Question(1, "To jest przykladowe pytanie",
                "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4",
                TYPE_OF_ANSWERS.CHECKBOX,"Odpowiedz 2");

        Question question2 = new Question(1, "To jest przykladowe pytanie",
                "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4",
                TYPE_OF_ANSWERS.CHECKBOX,"Odpowiedz 2");

    }

    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
            //submitAnswer();
        }
    };



}

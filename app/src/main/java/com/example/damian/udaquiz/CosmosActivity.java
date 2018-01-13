package com.example.damian.udaquiz;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class CosmosActivity extends AppCompatActivity {
    String currentLayout;
    Question[] questions = new Question[1];
    ConstraintLayout checkboxLayout = (ConstraintLayout) findViewById(R.id.checkboxLayout);
    ConstraintLayout radioLayout = (ConstraintLayout) findViewById(R.id.radioLayout);
    ConstraintLayout textLayout = (ConstraintLayout) findViewById(R.id.textLayout);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmos);

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(submitListener);

        makeQuestions();
        showQuestion(0);


    }


    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
            //submitAnswer();
        }
    };


    public void showQuestion(int numerOfQuestion){
        if (questions[numerOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.CHECKBOX){
            checkboxLayout.setVisibility(View.VISIBLE);
            currentLayout = "checkbox";

            TextView questionText = findViewById(R.id.questionTextChechkbox);
            CheckBox checkBox1 = findViewById(R.id.check_1);
            CheckBox checkBox2 = findViewById(R.id.check_2);
            CheckBox checkBox3 = findViewById(R.id.check_3);
            CheckBox checkBox4 = findViewById(R.id.check_4);

            questionText.setText(questions[numerOfQuestion].getQuestionText());
            checkBox1.setText(questions[numerOfQuestion].getFirstAnswer());
            checkBox2.setText(questions[numerOfQuestion].getSecondAnswer());
            checkBox3.setText(questions[numerOfQuestion].getThirdAnswer());
            checkBox4.setText(questions[numerOfQuestion].getFourthAnswer());

        }
    }

    public void makeQuestions(){
        questions[0] = new Question(1, "To jest przykladowe pytanie",
                "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4",
                TYPE_OF_ANSWERS.CHECKBOX,"Odpowiedz 2");


        questions[1] = new Question(2, "To jest przykladowe pytanie",
                "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4",
                TYPE_OF_ANSWERS.RADIO,"Odpowiedz 1");
    }



}

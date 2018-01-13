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
    public String currentLayout;
    public int numberOfQuestion = 0;
    public Question[] questions = new Question[10];
    public ConstraintLayout checkboxLayout;
    public ConstraintLayout radioLayout;
    public ConstraintLayout textLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmos);

        checkboxLayout = findViewById(R.id.checkboxLayout);
        radioLayout = findViewById(R.id.radioLayout);
        textLayout = findViewById(R.id.textLayout);

        Button submit = (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(submitListener);

        makeQuestions();
        showQuestion(numberOfQuestion);
    }


    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
            submitAnswer();
        }
    };

    private void submitAnswer() {
        numberOfQuestion++;
        showQuestion(numberOfQuestion);
    }

    public void makeQuestions(){
        questions[0] = new Question(1, "To jest przykladowe pytanie",
                "Odpowiedz 1", "Odpowiedz 2", "Odpowiedz 3", "Odpowiedz 4",
                TYPE_OF_ANSWERS.CHECKBOX,"Odpowiedz 2");


        questions[1] = new Question(2, "To jest przykladowe pytanie",
                "Odpowiedz radio", "Odpowiedz radio", "Odpowiedz radio", "Odpowiedz radio",
                TYPE_OF_ANSWERS.RADIO,"Odpowiedz radio");

        questions[2] = new Question("To jest pytanie otwarte", TYPE_OF_ANSWERS.TEXT, "Damian");
    }

    public void showQuestion(int numerOfQuestion){
        if (questions[numerOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.CHECKBOX){
            checkboxLayout.setVisibility(View.VISIBLE);
            radioLayout.setVisibility(View.GONE);
            textLayout.setVisibility(View.GONE);


            TextView questionText_checkbox = findViewById(R.id.questionTextChechkbox);
            CheckBox checkBox1 = findViewById(R.id.check_1);
            CheckBox checkBox2 = findViewById(R.id.check_2);
            CheckBox checkBox3 = findViewById(R.id.check_3);
            CheckBox checkBox4 = findViewById(R.id.check_4);

            questionText_checkbox.setText(questions[numerOfQuestion].getQuestionText());
            checkBox1.setText(questions[numerOfQuestion].getFirstAnswer());
            checkBox2.setText(questions[numerOfQuestion].getSecondAnswer());
            checkBox3.setText(questions[numerOfQuestion].getThirdAnswer());
            checkBox4.setText(questions[numerOfQuestion].getFourthAnswer());

        }
        if (questions[numerOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.RADIO){
            checkboxLayout.setVisibility(View.GONE);
            radioLayout.setVisibility(View.VISIBLE);
            textLayout.setVisibility(View.GONE);

            TextView questionText_radio = findViewById(R.id.questionText_radioLayout);
            RadioButton radioButton1 = findViewById(R.id.radio_1);
            RadioButton radioButton2 = findViewById(R.id.radio_2);
            RadioButton radioButton3 = findViewById(R.id.radio_3);
            RadioButton radioButton4 = findViewById(R.id.radio_4);

            questionText_radio.setText(questions[numerOfQuestion].getQuestionText());
            radioButton1.setText(questions[numerOfQuestion].getFirstAnswer());
            radioButton2.setText(questions[numerOfQuestion].getSecondAnswer());
            radioButton3.setText(questions[numerOfQuestion].getThirdAnswer());
            radioButton4.setText(questions[numerOfQuestion].getFourthAnswer());

        }
        if(questions[numerOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.TEXT){
            checkboxLayout.setVisibility(View.GONE);
            radioLayout.setVisibility(View.GONE);
            textLayout.setVisibility(View.VISIBLE);

            TextView questionText_text = findViewById(R.id.questionText_textLayout);

        }
    }





}

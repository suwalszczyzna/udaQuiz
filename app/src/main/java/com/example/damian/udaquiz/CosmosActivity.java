package com.example.damian.udaquiz;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CosmosActivity extends AppCompatActivity {
    private int points;
    private int numberOfQuestion;
    private Question[] questions = new Question[5];
    private int maxPoints = questions.length;
    private ConstraintLayout checkboxLayout;
    private ConstraintLayout radioLayout;
    private ConstraintLayout textLayout;
    private final int ANIM_DURATION = 800;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cosmos);



        points = 0;
        numberOfQuestion = 0;
        checkboxLayout = findViewById(R.id.checkboxLayout);
        radioLayout = findViewById(R.id.radioLayout);
        textLayout = findViewById(R.id.textLayout);

        checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
        radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
        textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);

        makeQuestions();
        showQuestion(numberOfQuestion);
        Button submit = findViewById(R.id.submit_button);
        submit.setOnClickListener(submitListener);
    }


    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
                    submitAnswer(numberOfQuestion);
                if (numberOfQuestion < (questions.length - 1)){
                     numberOfQuestion++;
                     showQuestion(numberOfQuestion);
                } else {

                    Intent i = new Intent(CosmosActivity.this, SummaryActivity.class);
                    String maxPointsString = String.valueOf(maxPoints);
                    String pointsString = String.valueOf(points);
                    i.putExtra("maxPointsString", maxPointsString);
                    i.putExtra("pointsString", pointsString);
                    startActivity(i);
                }
        }
    };


    public void makeQuestions(){
        questions[0] = new Question(
                "Which of these astronomical objects are planets?",
                "Earth",
                "Pluto",
                "Sun",
                "Jupiter",
                TYPE_OF_ANSWERS.CHECKBOX,
                "EarthJupiter");

        questions[1] = new Question(
                "How old is Earth?",
                "4.5 - 5 billions years old",
                "6.000 years old",
                "47 billions years old",
                "1 billion years old",
                TYPE_OF_ANSWERS.RADIO,
                "4.5 - 5 billions years old");

        questions[2] = new Question(
                "What is name of our galaxy?",
                TYPE_OF_ANSWERS.TEXT,
                "milky way"
        );
        questions[3] = new Question(
                "Answer to the Ultimate Question of Life, the Universe, and Everything",
                "What?!",
                "42",
                "Agent 00x",
                "God is the answer",
                TYPE_OF_ANSWERS.RADIO,
                "42");

        questions[4] = new Question(
                "Who wrote \"On the Revolutions of the Heavenly Spheres\" ?",
                "Johannes Kepler",
                "Edwin Hubble",
                "Nicolaus Copernicus",
                "Isaac Newton",
                TYPE_OF_ANSWERS.RADIO,
                "Nicolaus Copernicus");


    }

    public void showQuestion(int numberOfQuestion){
        if (questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.CHECKBOX){
            checkboxLayout.setVisibility(View.VISIBLE);
            checkboxLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);


            radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            radioLayout.setVisibility(View.GONE);

            textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.GONE);


            TextView questionText_checkbox = findViewById(R.id.questionTextChechkbox);
            CheckBox checkBox1 = findViewById(R.id.check_1);
            CheckBox checkBox2 = findViewById(R.id.check_2);
            CheckBox checkBox3 = findViewById(R.id.check_3);
            CheckBox checkBox4 = findViewById(R.id.check_4);

            questionText_checkbox.setText(questions[numberOfQuestion].getQuestionText());
            checkBox1.setText(questions[numberOfQuestion].getFirstAnswer());
            checkBox2.setText(questions[numberOfQuestion].getSecondAnswer());
            checkBox3.setText(questions[numberOfQuestion].getThirdAnswer());
            checkBox4.setText(questions[numberOfQuestion].getFourthAnswer());
        }
        if (questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.RADIO){

            checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            checkboxLayout.setVisibility(View.GONE);


            radioLayout.setVisibility(View.VISIBLE);
            radioLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);

            textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.GONE);

            TextView questionText_radio = findViewById(R.id.questionText_radioLayout);
            RadioButton radioButton1 = findViewById(R.id.radio_1);
            RadioButton radioButton2 = findViewById(R.id.radio_2);
            RadioButton radioButton3 = findViewById(R.id.radio_3);
            RadioButton radioButton4 = findViewById(R.id.radio_4);
            radioButton1.setChecked(false);
            radioButton2.setChecked(false);
            radioButton3.setChecked(false);
            radioButton4.setChecked(false);
            questionText_radio.setText(questions[numberOfQuestion].getQuestionText());

            radioButton1.setText(questions[numberOfQuestion].getFirstAnswer());
            radioButton2.setText(questions[numberOfQuestion].getSecondAnswer());
            radioButton3.setText(questions[numberOfQuestion].getThirdAnswer());
            radioButton4.setText(questions[numberOfQuestion].getFourthAnswer());

        }
        if(questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.TEXT){

            checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            checkboxLayout.setVisibility(View.GONE);
            radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            radioLayout.setVisibility(View.GONE);
            textLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.VISIBLE);

            TextView questionText_text = findViewById(R.id.questionText_textLayout);
            questionText_text.setText(questions[numberOfQuestion].getQuestionText());

        }
    }

    public void submitAnswer(int numberOfQuestion){

        if (questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.CHECKBOX){
            String answer = "";
            CheckBox[] checkBoxes = new CheckBox[4];
            checkBoxes[0] = findViewById(R.id.check_1);
            checkBoxes[1] = findViewById(R.id.check_2);
            checkBoxes[2] = findViewById(R.id.check_3);
            checkBoxes[3] = findViewById(R.id.check_4);

            for (int i = 0; i < 4; i++) {
                if(checkBoxes[i].isChecked()){
                    answer += String.valueOf(checkBoxes[i].getText());
                    questions[numberOfQuestion].setAnswer(answer);
                }
            }
            if (questions[numberOfQuestion].getCorrectAnswer().equals(answer)){
                points++;
            }


        }else if (questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.RADIO){
            String answer = "";
            RadioButton[] radioButtons = new RadioButton[4];
            radioButtons[0] = findViewById(R.id.radio_1);
            radioButtons[1] = findViewById(R.id.radio_2);
            radioButtons[2] = findViewById(R.id.radio_3);
            radioButtons[3] = findViewById(R.id.radio_4);


            for (int i = 0; i < 4; i++) {
                if(radioButtons[i].isChecked()){
                    answer += String.valueOf(radioButtons[i].getText());
                    questions[numberOfQuestion].setAnswer(answer);
                }
            }
            if (questions[numberOfQuestion].getCorrectAnswer().equals(answer)){
                points++;
            }


        }
        if(questions[numberOfQuestion].getTypeOfAnswers()==TYPE_OF_ANSWERS.TEXT){

            EditText editText = findViewById(R.id.editText);

            questions[numberOfQuestion].setAnswer(String.valueOf(editText.getText()));

            if (questions[numberOfQuestion].getCorrectAnswer().equals(questions[numberOfQuestion].getAnswer().toLowerCase())) {
                points++;
            }


        }


    }






}

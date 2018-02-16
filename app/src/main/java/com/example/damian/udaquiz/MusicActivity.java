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
import android.widget.RadioGroup;
import android.widget.TextView;

public class MusicActivity extends AppCompatActivity {
    private int points;
    private int numberOfQuestion;
    private Question[] questions = new Question[5];
    private CheckBox[] checkBoxes = new CheckBox[4];
    private RadioButton[] radioButtons = new RadioButton[4];
    private int maxPoints = questions.length;
    private ConstraintLayout checkboxLayout;
    private ConstraintLayout radioLayout;
    private ConstraintLayout textLayout;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private TextView questionText_checkbox, questionText_radio, questionText_text;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4;
    private RadioGroup radioGroup;
    private Button submit;

    private final int ANIM_DURATION = 800;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        makeViews();
        points = 0;
        numberOfQuestion = 0;
        checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
        radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
        textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
        makeQuestions();
        showQuestion(numberOfQuestion);

        submit.setOnClickListener(submitListener);
    }


    private View.OnClickListener submitListener = new View.OnClickListener() {
        public void onClick(View v) {
            submitAnswer(numberOfQuestion);
            if (numberOfQuestion < (questions.length - 1)) {
                numberOfQuestion++;
                showQuestion(numberOfQuestion);
            } else {

                Intent i = new Intent(MusicActivity.this, SummaryActivity.class);
                String maxPointsString = String.valueOf(maxPoints);
                String pointsString = String.valueOf(points);
                i.putExtra("maxPointsString", maxPointsString);
                i.putExtra("pointsString", pointsString);
                finish();
                startActivity(i);
            }
        }
    };


    public void makeViews() {
        questionText_checkbox = findViewById(R.id.questionTextChechkbox);
        checkBox1 = findViewById(R.id.check_1);
        checkBox2 = findViewById(R.id.check_2);
        checkBox3 = findViewById(R.id.check_3);
        checkBox4 = findViewById(R.id.check_4);
        questionText_radio = findViewById(R.id.questionText_radioLayout);
        radioButton1 = findViewById(R.id.radio_1);
        radioButton2 = findViewById(R.id.radio_2);
        radioButton3 = findViewById(R.id.radio_3);
        radioButton4 = findViewById(R.id.radio_4);
        radioGroup = findViewById(R.id.radioGroup);
        questionText_text = findViewById(R.id.questionText_textLayout);
        checkboxLayout = findViewById(R.id.checkboxLayout);
        radioLayout = findViewById(R.id.radioLayout);
        textLayout = findViewById(R.id.textLayout);
        submit = findViewById(R.id.submit_button);

    }

    public void makeQuestions() {
        questions[0] = new Question(
                "What kind of music is \"Kind of Blue\" music album?",
                "Pop music",
                "Classic music",
                "Jazz music",
                "Hip - hop music",
                TYPE_OF_ANSWERS.RADIO,
                "Jazz music");

        questions[1] = new Question(
                "Miles Davis was ...",
                "Trumpeter",
                "Composer",
                "Drummer",
                "Teacher",
                TYPE_OF_ANSWERS.CHECKBOX,
                "TrumpeterComposer");

        questions[2] = new Question(
                "What is really name of musician STING ?",
                "Gordon Sumner",
                "Gordon Ramsay",
                "Gordon Matthew Thomas Sumner",
                "Cosmo Duff Gordon",
                TYPE_OF_ANSWERS.RADIO,
                "Gordon Matthew Thomas Sumner");


        questions[3] = new Question(
                " \"Weather wise, it's such a lovely day\n" +
                        "Just say the words and we'll beat the birds down to Acapulco Bay\n" +
                        "It's perfect for a flying honeymoon, they say\n" +
                        "Come fly with me, let's fly, let's fly away\"\n" +
                        "\nWhich artist sang this song?",
                TYPE_OF_ANSWERS.TEXT,
                "frank sinatra");

        questions[4] = new Question(
                "Where is placed the Capitol Records?",
                "New York",
                "Los Angeles",
                "Seattle",
                "Orlando",
                TYPE_OF_ANSWERS.RADIO,
                "Los Angeles");


    }

    public void showQuestion(int numberOfQuestion) {
        if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.CHECKBOX) {
            checkboxLayout.setVisibility(View.VISIBLE);
            checkboxLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);
            radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            radioLayout.setVisibility(View.GONE);
            textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.GONE);
            questionText_checkbox.setText(questions[numberOfQuestion].getQuestionText());
            checkBox1.setText(questions[numberOfQuestion].getFirstAnswer());
            checkBox2.setText(questions[numberOfQuestion].getSecondAnswer());
            checkBox3.setText(questions[numberOfQuestion].getThirdAnswer());
            checkBox4.setText(questions[numberOfQuestion].getFourthAnswer());
        }
        if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.RADIO) {
            radioGroup.clearCheck();
            checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            checkboxLayout.setVisibility(View.GONE);
            radioLayout.setVisibility(View.VISIBLE);
            radioLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);
            textLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.GONE);
            questionText_radio.setText(questions[numberOfQuestion].getQuestionText());
            radioButton1.setText(questions[numberOfQuestion].getFirstAnswer());
            radioButton2.setText(questions[numberOfQuestion].getSecondAnswer());
            radioButton3.setText(questions[numberOfQuestion].getThirdAnswer());
            radioButton4.setText(questions[numberOfQuestion].getFourthAnswer());
        }
        if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.TEXT) {
            checkboxLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            checkboxLayout.setVisibility(View.GONE);
            radioLayout.animate().alpha(0.0f).setDuration(ANIM_DURATION);
            radioLayout.setVisibility(View.GONE);
            textLayout.animate().alpha(1.0f).setDuration(ANIM_DURATION);
            textLayout.setVisibility(View.VISIBLE);
            questionText_text.setText(questions[numberOfQuestion].getQuestionText());
        }
    }

    public void submitAnswer(int numberOfQuestion) {

        if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.CHECKBOX) {
            String answer = "";
            CheckBox[] checkBoxes = new CheckBox[4];
            checkBoxes[0] = findViewById(R.id.check_1);
            checkBoxes[1] = findViewById(R.id.check_2);
            checkBoxes[2] = findViewById(R.id.check_3);
            checkBoxes[3] = findViewById(R.id.check_4);

            for (int i = 0; i < 4; i++) {
                if (checkBoxes[i].isChecked()) {
                    answer += String.valueOf(checkBoxes[i].getText());
                    questions[numberOfQuestion].setAnswer(answer);
                }
            }
            if (questions[numberOfQuestion].getCorrectAnswer().equals(answer)) {
                points++;
            }


        } else if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.RADIO) {
            String answer = "";
            RadioButton[] radioButtons = new RadioButton[4];
            radioButtons[0] = findViewById(R.id.radio_1);
            radioButtons[1] = findViewById(R.id.radio_2);
            radioButtons[2] = findViewById(R.id.radio_3);
            radioButtons[3] = findViewById(R.id.radio_4);


            for (int i = 0; i < 4; i++) {
                if (radioButtons[i].isChecked()) {
                    answer += String.valueOf(radioButtons[i].getText());
                    questions[numberOfQuestion].setAnswer(answer);
                }
            }
            if (questions[numberOfQuestion].getCorrectAnswer().equals(answer)) {
                points++;
            }


        }
        if (questions[numberOfQuestion].getTypeOfAnswers() == TYPE_OF_ANSWERS.TEXT) {
            String answer;
            EditText editText = findViewById(R.id.editText);

            questions[numberOfQuestion].setAnswer(String.valueOf(editText.getText()).trim());
            answer = questions[numberOfQuestion].getAnswer();
            if (questions[numberOfQuestion].getCorrectAnswer().equalsIgnoreCase(answer)) {
                points++;
            }


        }


    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number_of_question", numberOfQuestion);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numberOfQuestion = savedInstanceState.getInt("number_of_question");
        showQuestion(numberOfQuestion);
    }


}

package edu.chapman.cpsc356.truefalse.activities;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import edu.chapman.cpsc356.truefalse.R;
import edu.chapman.cpsc356.truefalse.models.Question;

public class MainActivity extends AppCompatActivity
{
    private final String LOGTAG = "MainActivity";
    private final String KEY_QUESTION_IDX = "question_idx";

    public static final int REQUEST_CHEATED = 1000;

    private TextView questionTextView;
    private View mainView;

    private int questionIndex;

    private boolean cheated = false;

    private Question[] questions = new Question[] {
            new Question("Life is worth it", true),
            new Question("A tomato is a fruit", true),
            new Question("This class is cool", true),
            new Question("I am a communications major", false),
            new Question("Pizza is good 4u", false)
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.questionTextView = (TextView) findViewById(R.id.tv_question);
        this.mainView = findViewById(R.id.ll_main);

        if (savedInstanceState == null)
        {
            // Created for the first time
            questionIndex = new Random().nextInt(this.questions.length);
        }
        else
        {
            // Recreated after rotation
            questionIndex = savedInstanceState.getInt(KEY_QUESTION_IDX);
        }

        nextQuestion();

        Log.d(LOGTAG, "onCreate()");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CHEATED)
        {
            this.cheated = (resultCode == RESULT_OK);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        Log.d(LOGTAG, "onSavedInstanceState()");

        outState.putInt(KEY_QUESTION_IDX, this.questionIndex);
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        Log.d(LOGTAG, "onStart()");
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Log.d(LOGTAG, "onResume()");

    }

    @Override
    protected void onPause()
    {
        super.onPause();

        Log.d(LOGTAG, "onPause()");

    }

    @Override
    protected void onStop()
    {
        super.onStop();

        Log.d(LOGTAG, "onStop()");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.d(LOGTAG, "onDestroy()");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();

        Log.d(LOGTAG, "onRestart()");

    }

    public void falseTapped(View view)
    {
        answerTapped(false);
    }

    public void trueTapped(View view)
    {
        answerTapped(true);
    }

    public void nextTapped(View view)
    {
        questionIndex = new Random().nextInt(this.questions.length);
        nextQuestion();
    }

    public void cheatTapped(View view)
    {
        Question currentQuestion = this.questions[questionIndex];
        startActivityForResult(CheatActivity.GetIntent(currentQuestion, this), REQUEST_CHEATED);
    }

    private void answerTapped(boolean attemptedAnswer)
    {
        Question currentQuestion = this.questions[questionIndex];
        if (currentQuestion.getAnswer() == attemptedAnswer)
        {
            if (this.cheated)
            {
                Toast.makeText(this, R.string.correct_cheated, Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
            }

            this.mainView.setBackgroundColor(Color.GREEN);
        }
        else
        {
            if (this.cheated)
            {
                Toast.makeText(this, R.string.wrong_cheated, Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show();
            }

            this.mainView.setBackgroundColor(Color.RED);
        }
    }

    private void nextQuestion()
    {
        this.cheated = false;

        Question currentQuestion = this.questions[questionIndex];
        this.questionTextView.setText(currentQuestion.getText());

        this.mainView.setBackgroundColor(Color.WHITE);
    }


}

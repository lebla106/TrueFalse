package edu.chapman.cpsc356.truefalse.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import edu.chapman.cpsc356.truefalse.R;
import edu.chapman.cpsc356.truefalse.models.Question;

public class CheatActivity extends AppCompatActivity
{
    private static final String KEY_CHEAT_ANSWER = "cheat_answer";

    private final String LOGTAG = "CheatActivity";
    private TextView answerTextView;
    private boolean answer;
    private boolean cheated = false;

    public static Intent GetIntent(Question q, Context ctx)
    {
        Intent cheatIntent = new Intent(ctx, CheatActivity.class);
        cheatIntent.putExtra(KEY_CHEAT_ANSWER, q.getAnswer());

        return cheatIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

        this.answerTextView = (TextView) findViewById(R.id.tv_cheat_answer);

        Bundle extras = this.getIntent().getExtras();
        this.answer = extras.getBoolean(KEY_CHEAT_ANSWER);

        Log.d(LOGTAG, "onCreate()");
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

    public void backTapped(View view)
    {
        if (this.cheated == true)
        {
            setResult(RESULT_OK);
        }
        else
        {
            setResult(RESULT_CANCELED);
        }

        finish();
    }

    public void cheatTapped(View view)
    {
        this.cheated = true;

        if (this.answer == true)
        {
            this.answerTextView.setText(R.string.true_text);
        }
        else
        {
            this.answerTextView.setText(R.string.false_text);
        }

        this.answerTextView.setVisibility(View.VISIBLE);
    }
}

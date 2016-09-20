package edu.chapman.cpsc356.truefalse.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import edu.chapman.cpsc356.truefalse.R;

public class CheatActivity extends AppCompatActivity
{

    private final String LOGTAG = "CheatActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);

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
        finish();
    }
}

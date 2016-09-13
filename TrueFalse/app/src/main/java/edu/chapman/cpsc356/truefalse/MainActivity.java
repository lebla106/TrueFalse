package edu.chapman.cpsc356.truefalse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import edu.chapman.cpsc356.truefalse.models.Question;

public class MainActivity extends AppCompatActivity
{

    private TextView questionTextView;
    private Question theQuestion = new Question("Life is worth it", true);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.questionTextView = (TextView) findViewById(R.id.tv_question);
        this.questionTextView.setText(this.theQuestion.getText());
    }

    public void falseTapped(View view)
    {
        answerTapped(false);
    }

    public void trueTapped(View view)
    {
        answerTapped(true);
    }

    private void answerTapped(boolean attemptedAnswer)
    {
        if (this.theQuestion.getAnswer() == attemptedAnswer)
        {
            Toast.makeText(this, R.string.correct, Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, R.string.wrong, Toast.LENGTH_SHORT).show();
        }
    }
}

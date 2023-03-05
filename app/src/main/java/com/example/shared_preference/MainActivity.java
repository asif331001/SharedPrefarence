package com.example.shared_preference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView scoreTextView;
    private Button increaseButton, decreaseButton;

    private int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTextView = (TextView) findViewById(R.id.scoreTextViewId);
        increaseButton = (Button) findViewById(R.id.increaseButtonId);
        decreaseButton = (Button) findViewById(R.id.decreaseButtonId);

        if (loadScore()!=0) {
            scoreTextView.setText("Score: "+loadScore());
        }

        increaseButton.setOnClickListener(this);
        decreaseButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (view.getId()==R.id.increaseButtonId) {

            score = score + 10;
            scoreTextView.setText("Score: "+score);
            saveScore(score);

        }
        if (view.getId()==R.id.decreaseButtonId){

            score = score - 10;
            scoreTextView.setText("Score: "+score);
            saveScore(score);
        }
    }

    private void saveScore (int score){

        SharedPreferences sharedPreferences = getSharedPreferences("scoreKey", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("lastScore",score);
        editor.commit();
    }

    private int loadScore(){

        SharedPreferences sharedPreferences = getSharedPreferences("scoreKey", Context.MODE_PRIVATE);
        int score = sharedPreferences.getInt("lastScore",0);
        return score;
    }
}
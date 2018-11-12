package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.s164646.simonjohansen.aflevering01_s164646_simonjohansen.frag_galgeleg_game.getRightWord;
import static com.s164646.simonjohansen.aflevering01_s164646_simonjohansen.frag_galgeleg_game.getSolveTime;

public class frag_galgeleg_youWon extends AppCompatActivity implements View.OnClickListener {

    private TextView winnerInfo, winnerTime;
    private String winnerRightWord;
    private Button submitButton;
    private EditText usernameInput;
    private long winnerSolveTime;
    private InputMethodManager inputManager;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_galgeleg_you_won);

        usernameInput = (EditText) findViewById(R.id.input_name);
        winnerInfo = (TextView) findViewById(R.id.winner_info);
        winnerTime = (TextView) findViewById(R.id.winner_time);
        submitButton = (Button) findViewById(R.id.b_submitHighscore);
        submitButton.setOnClickListener(this);

        winnerRightWord = getRightWord();
        winnerSolveTime = getSolveTime();

        winnerTime.setText("Du klarede det på: " + winnerSolveTime + " sekunder!");
        winnerInfo.setText("Du gættede ordet: " + winnerRightWord);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_submitHighscore:
                if (counter != 0) {
                    //hides keyboard on click.
                    inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                    Toast.makeText(this, "Highscore Modtaget", Toast.LENGTH_SHORT);
                    counter++;
                    addToHighscoreList();
                } else {
                    Toast.makeText(this, "Kun én Highscore af gangen!", Toast.LENGTH_SHORT);
                }
        }
    }


    public void addToHighscoreList() {
        SharedPreferences sharedPref = getSharedPreferences("User Scores", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        String winnerSolveTimeString = Long.toString(winnerSolveTime);
        editor.putString(usernameInput.getText().toString(), winnerSolveTimeString + " sekunder");
        editor.commit();
    }
}

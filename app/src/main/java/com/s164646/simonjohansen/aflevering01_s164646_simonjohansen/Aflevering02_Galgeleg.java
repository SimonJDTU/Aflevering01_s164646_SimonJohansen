package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class Aflevering02_Galgeleg extends AppCompatActivity implements View.OnClickListener {

    private Button button_guessLetter, button_giveUp;
    private TextView guessLetterHint, gameInfo;
    private ImageView hangMan;
    private galgelegLogik logik;
    private EditText letterGuess;
    private InputMethodManager inputManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set default view til starting screen
        setContentView(R.layout.activity_galgeleg_game);

        //stackoverflow solution to hiding keyboard on buttonclick (https://stackoverflow.com/questions/3400028/close-virtual-keyboard-on-button-press)
        inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);

        logik = new galgelegLogik();
        logik.nulstil();

        hangMan=(ImageView) findViewById(R.id.hangMan);

        letterGuess = (EditText) findViewById(R.id.t_letterGuess);

        letterGuess = (EditText) findViewById(R.id.t_letterGuess);

        guessLetterHint = (TextView) findViewById(R.id.t_guessLetter);

        gameInfo = (TextView) findViewById(R.id.t_gameInfo);

        button_guessLetter = (Button) findViewById(R.id.b_guess_letter);
        button_guessLetter.setOnClickListener(this);

        button_giveUp = (Button) findViewById(R.id.b_give_up);
        button_giveUp.setOnClickListener(this);

        opdaterSkærm();

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_guess_letter:
                //hides keyboard on click.
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);

                String bogstav = letterGuess.getText().toString();
                if (bogstav.length() != 1) {
                    guessLetterHint.setText("Skriv præcis ét bogstav");
                    return;
                }
                logik.gætBogstav(bogstav);
                letterGuess.setText("");
                letterGuess.setError(null);
                opdaterSkærm();
                break;

            case R.id.b_give_up:
                //hides keyboard on click.
                inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                        InputMethodManager.HIDE_NOT_ALWAYS);
                finish();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void opdaterSkærm() {
        gameInfo.setText("Gæt ordet: " + logik.getSynligtOrd());
        gameInfo.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());

        if (logik.erSpilletVundet()) {
            gameInfo.append("\nDu har vundet");
        }
        if (logik.erSpilletTabt()) {
            gameInfo.setText("Du har tabt, ordet var : " + logik.getOrdet());
        }
        switch (logik.getAntalForkerteBogstaver()) {
            case 0:
                hangMan.setImageResource(R.drawable.galge);
                break;
            case 1:
                hangMan.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                hangMan.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                hangMan.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                hangMan.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                hangMan.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                hangMan.setImageResource(R.drawable.forkert6);
                break;
            case 7:
                Toast.makeText(this, "Du har desværre tabt", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
        }
    }
}

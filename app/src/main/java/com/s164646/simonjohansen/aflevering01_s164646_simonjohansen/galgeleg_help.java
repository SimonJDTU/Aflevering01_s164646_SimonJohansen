package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class galgeleg_help extends AppCompatActivity implements View.OnClickListener {

    private Button button_back, button_guess, button_guessWrong;
    private galgelegLogik logik;
    private int guessCounter, galgeCounter;
    private TextView gameInfo;
    private ImageView imageGalge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galgeleg_help);

        logik = new galgelegLogik();

        button_back = (Button) findViewById(R.id.b_help_back);
        button_back.setOnClickListener(this);

        button_guess = (Button) findViewById(R.id.b_help_guess);
        button_guess.setOnClickListener(this);

        button_guessWrong = (Button) findViewById(R.id.b_help_guessWrong);
        button_guessWrong.setOnClickListener(this);

        gameInfo = (TextView) findViewById(R.id.t_help_gameInfo);

        imageGalge = (ImageView) findViewById(R.id.i_help_galge);

        opdaterSkærm();
        opdaterGalge();
        updateGuess();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_help_back:
                finish();
                break;
            case R.id.b_help_guess:
                updateGuess();
                break;
            case R.id.b_help_guessWrong:
                opdaterGalge();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
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
    }

    private void opdaterGalge() {
        switch (galgeCounter) {
            case 0:
                imageGalge.setImageResource(R.drawable.galge);
                galgeCounter++;
                break;
            case 1:
                imageGalge.setImageResource(R.drawable.forkert1);
                galgeCounter++;
                break;
            case 2:
                imageGalge.setImageResource(R.drawable.forkert2);
                galgeCounter++;
                break;
            case 3:
                imageGalge.setImageResource(R.drawable.forkert3);
                galgeCounter++;
                break;
            case 4:
                imageGalge.setImageResource(R.drawable.forkert4);
                galgeCounter++;
                break;
            case 5:
                imageGalge.setImageResource(R.drawable.forkert5);
                galgeCounter++;
                break;
            case 6:
                imageGalge.setImageResource(R.drawable.forkert6);
                galgeCounter++;
                break;
            case 7:
                Toast.makeText(this, "Prøv at spille spillet :)", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateGuess() {
        switch (guessCounter) {
            case 0:
                guessCounter++;
                break;
            case 1:
                logik.gætBogstav("s");
                guessCounter++;
                opdaterSkærm();
                break;
            case 2:
                logik.gætBogstav("b");
                guessCounter++;
                opdaterSkærm();
                break;
            case 3:
                logik.gætBogstav("e");
                guessCounter++;
                opdaterSkærm();
                break;
            case 4:
                logik.gætBogstav("i");
                guessCounter++;
                opdaterSkærm();
                break;
            case 5:
                logik.gætBogstav("h");
                guessCounter++;
                opdaterSkærm();
                break;
            case 6:
                Toast.makeText(this, "Prøv at spille spillet :)", Toast.LENGTH_SHORT).show();
                opdaterSkærm();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
        }
    }
}
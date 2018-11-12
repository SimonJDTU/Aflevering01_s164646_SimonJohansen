package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class frag_galgeleg_game extends Fragment implements View.OnClickListener {

    private static long solveTime;
    private Button button_guessLetter, button_giveUp;
    private TextView guessLetterHint, gameInfo;
    private ImageView hangMan;
    private static galgelegLogik logik;
    private EditText letterGuess;
    private InputMethodManager inputManager;
    long timer1,timer2;

    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.fragment_galgeleg_game, container, false);

        //stackoverflow solution to hiding keyboard on buttonclick (https://stackoverflow.com/questions/3400028/close-virtual-keyboard-on-button-press)
        inputManager = (InputMethodManager)
              getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);

        logik = new galgelegLogik();
        logik.nulstil();

        hangMan = (ImageView) rod.findViewById(R.id.frag_hangMan);

        letterGuess = (EditText) rod.findViewById(R.id.t_frag_letterGuess);

        letterGuess = (EditText) rod.findViewById(R.id.t_frag_letterGuess);

        guessLetterHint = (TextView) rod.findViewById(R.id.t_frag_guessLetter);

        gameInfo = (TextView) rod.findViewById(R.id.t_frag_gameInfo);

        button_guessLetter = (Button) rod.findViewById(R.id.b_frag_guess_letter);
        button_guessLetter.setOnClickListener(this);

        button_giveUp = (Button) rod.findViewById(R.id.b_frag_give_up);
        button_giveUp.setOnClickListener(this);

        //used to check solvetime for highScore List
        timer1 = SystemClock.currentThreadTimeMillis();

        opdaterSkærm();

        return rod;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_frag_guess_letter:
                //hides keyboard on click.
                inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(),
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

            case R.id.b_frag_give_up:
                getFragmentManager().popBackStack();
                break;
            default:
                //cant toast in fragment.
                break;
        }
    }

    private void opdaterSkærm() {
        gameInfo.setText("Gæt ordet: " + logik.getSynligtOrd());
        gameInfo.append("\n\nDu har " + logik.getAntalForkerteBogstaver() + " forkerte:" + logik.getBrugteBogstaver());

        if (logik.erSpilletVundet()) {
            //used to check solvetime for highScore List
            timer2 = SystemClock.currentThreadTimeMillis();
            setSolveTime(timer1,timer2);

            button_giveUp.setText("Click her for hovedmenu");
            Intent won = new Intent(getActivity(), frag_galgeleg_youWon.class);
            startActivity(won);
        }
        if (logik.erSpilletTabt()) {
            button_giveUp.setText("Click her for hovedmenu");
            Intent lost = new Intent(getActivity(), frag_galgeleg_youLost.class);
            startActivity(lost);
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
                break;
            default:
        }
    }

    public static String getRightWord() {
        return logik.getOrdet();
    }

    public void setSolveTime(long d1, long d2){
        //setting solvetime to seconds
        solveTime=(d2-d1)/10;
    }

    public static long getSolveTime() {
        return solveTime;
    }
}
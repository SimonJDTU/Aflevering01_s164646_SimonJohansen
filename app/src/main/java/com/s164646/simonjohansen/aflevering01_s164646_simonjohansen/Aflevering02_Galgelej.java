package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Aflevering02_Galgelej extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2,button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set default view til starting screen
        setContentView(R.layout.activity_galgelej);

        button1 = (Button) findViewById(R.id.b_play_game);

        button2 = (Button) findViewById(R.id.b_guess_letter);
        button2.setVisibility(View.INVISIBLE);
        button3 = (Button) findViewById(R.id.b_give_up);
        button3.setVisibility(View.INVISIBLE);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_play_game:
                Toast.makeText(this, "Spil Startet", Toast.LENGTH_SHORT).show();
                galgeLeg();
                button1.setVisibility(View.GONE);
                button2.setVisibility(View.VISIBLE);
                button3.setVisibility(View.VISIBLE);
                break;
            case R.id.b_guess_letter:
                break;
            case R.id.b_give_up:
                button1.setVisibility(View.VISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
                break;

        }
    }

    public void galgeLeg(){
        boolean isPlaying=false;
        galgelegLogik game = new galgelegLogik();

        game.nulstil();
        while(isPlaying){

        game.gætBogstav("A");


        game.logStatus();
        }


    }

}


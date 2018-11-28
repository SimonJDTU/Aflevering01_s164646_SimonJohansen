package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FinalGalgeleg_MainMenu extends AppCompatActivity implements View.OnClickListener {

    Button playBtn, wordsBtn, exitBtn, scoreBtn, settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_galgeleg);

        playBtn = (Button) findViewById(R.id.finalPlayBtn);
        wordsBtn = (Button) findViewById(R.id.finalWordsBtn);
        exitBtn = (Button) findViewById(R.id.finalExitBtn);
        scoreBtn = (Button) findViewById(R.id.finalScoreBtn);
        settingsBtn = (Button) findViewById(R.id.finalHelpBtn);

    }

    @Override
    public void onClick(View v) {
        switch (v){

            case:
        }
    }
}

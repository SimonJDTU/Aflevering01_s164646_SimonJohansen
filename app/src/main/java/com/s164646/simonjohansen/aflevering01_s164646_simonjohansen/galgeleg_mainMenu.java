package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class galgeleg_mainMenu extends AppCompatActivity implements View.OnClickListener {

    Button button_help, button_playGame, button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galgeleg_main_menu);

        button_help = (Button) findViewById(R.id.b_help);
        button_help.setOnClickListener(this);

        button_playGame = (Button) findViewById(R.id.b_play_game);
        button_playGame.setOnClickListener(this);

        button_back = (Button) findViewById(R.id.b_back);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_help:
                Intent i = new Intent(this,galgeleg_help.class);
                startActivity(i);
                break;
            case R.id.b_play_game:
                Intent e = new Intent(this,Aflevering02_Galgeleg.class);
                startActivity(e);
                break;
            case R.id.b_back:
                finish();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
        }
    }
}

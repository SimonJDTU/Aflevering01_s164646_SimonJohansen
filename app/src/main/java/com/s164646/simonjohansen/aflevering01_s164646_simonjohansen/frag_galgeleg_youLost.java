package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.s164646.simonjohansen.aflevering01_s164646_simonjohansen.frag_galgeleg_game.getRightWord;

public class frag_galgeleg_youLost extends AppCompatActivity {

    private TextView loserInfo;
    private String tempString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag_galgeleg_you_lost);

        loserInfo = (TextView) findViewById(R.id.loser_info);

        tempString = getRightWord();

        loserInfo.setText("Det rigtige ord var: "+ tempString);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}

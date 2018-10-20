package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartingScreen extends AppCompatActivity implements View.OnClickListener {

    Button button1,button2;

    //TextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set default view til starting screen
        setContentView(R.layout.activity_starting_screen);

        button1 = (Button) findViewById(R.id.start_Aflevering_1);
        button2 = (Button) findViewById(R.id.start_Aflevering_2);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.start_Aflevering_1 :
                Intent i = new Intent(this,Aflevering01_GetStarted.class);
                startActivity(i);
                Toast.makeText(this, "Knap 1 klikket", Toast.LENGTH_SHORT).show();
                break;
            case R.id.start_Aflevering_2 :
                Intent e = new Intent(this,galgeleg_mainMenu.class);
                startActivity(e);
                Toast.makeText(this, "Knap 2 klikket", Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
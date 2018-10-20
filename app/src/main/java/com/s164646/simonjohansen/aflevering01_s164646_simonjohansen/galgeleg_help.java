package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class galgeleg_help extends AppCompatActivity implements View.OnClickListener{

    Button button_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galgeleg_help);

        button_back = (Button) findViewById(R.id.b_help_back);
        button_back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.b_help_back:
                finish();
                break;
                default:
                    Toast.makeText(this, "Default hit", Toast.LENGTH_SHORT).show();
        }
    }
}

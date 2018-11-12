package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;


public class frag_galgeleg_mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_galgeleg_main_menu);
    }

    //Go back one fragment. If we in mainMenu, close activity.
    @Override
    public void onBackPressed() {
        int count = getSupportFragmentManager().getBackStackEntryCount();
        if (count == 0) {
            finish();
        } else {
            getFragmentManager().popBackStackImmediate();
        }
    }
}

package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;


public class frag_galgeleg_mainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_galgeleg_main_menu);

        Fragment menuFragment = new frag_menuContent();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_content, menuFragment)
                .addToBackStack(null)
                .commit();

        Fragment topFragment = new frag_topMenu_content();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frag_topMenu, topFragment)
                .addToBackStack(null)
                .commit();


        }
}

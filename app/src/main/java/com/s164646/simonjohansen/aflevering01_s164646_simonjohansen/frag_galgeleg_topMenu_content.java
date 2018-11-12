package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;



public class frag_galgeleg_topMenu_content extends Fragment implements View.OnClickListener {

    private Button highScoreButton, helpButton, contactButton;

    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.fragment_top_menu_content, container, false);

        highScoreButton = rod.findViewById(R.id.b_frag_highScore);
        highScoreButton.setOnClickListener(this);

        helpButton = rod.findViewById(R.id.b_frag_help);
        helpButton.setOnClickListener(this);

        contactButton = rod.findViewById(R.id.b_frag_contact);
        contactButton.setOnClickListener(this);

        return rod;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_frag_highScore:
                Intent i = new Intent(getActivity(), galgeleg_highScore.class);
                startActivity(i);
                break;
            case R.id.b_frag_help:
                Intent e = new Intent(getActivity(), galgeleg_help.class);
                startActivity(e);
                break;
            case R.id.b_frag_contact:
                Intent f = new Intent(getActivity(), galgeleg_problems_and_thoughts.class);
                startActivity(f);
                break;
            default:
                String TAG = "frag_topMenu_content";
                Log.d(TAG,"Default hit");
                break;
        }
    }
}


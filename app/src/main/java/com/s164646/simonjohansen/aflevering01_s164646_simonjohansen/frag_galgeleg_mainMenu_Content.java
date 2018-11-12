package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import static android.content.ContentValues.TAG;

public class frag_galgeleg_mainMenu_Content extends Fragment implements View.OnClickListener {

    private Button playGameButton, tempButton, backButton;
    private Fragment gameFragment;

    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.fragment_main_menu_content, container, false);

        gameFragment = new frag_galgeleg_game();

        playGameButton = (Button) rod.findViewById(R.id.b_play_game);
        tempButton = (Button) rod.findViewById(R.id.b_show_words);
        backButton = (Button) rod.findViewById(R.id.b_back);

        playGameButton.setOnClickListener(this);
        tempButton.setOnClickListener(this);
        backButton.setOnClickListener(this);

        return rod;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.b_play_game:
                getFragmentManager().beginTransaction()
                        .replace(R.id.frag_content, gameFragment)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.b_show_words:
                Log.d(TAG,"Not Implemented");
                break;
            case R.id.b_back:
                getActivity().finish();
                break;
            default:
                Log.d(TAG,"Default hit");
                break;
        }
    }
}

package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class frag_menuContent extends Fragment {

    Button button1,button2,button3;



    public View onCreateView(LayoutInflater i, ViewGroup container, Bundle savedInstanceState) {
        View rod = i.inflate(R.layout.fragment_main_menu_content, container, false);




        return rod;
    }
}

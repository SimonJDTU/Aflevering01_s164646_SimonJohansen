package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Map;

import static java.sql.Types.NULL;

public class galgeleg_highScore extends AppCompatActivity {

    private ListView highScore;
    private TextView noInfo;
    private Map tempHashMap;
    private Object[] keys ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galgeleg_high_score);

        highScore = (ListView) findViewById(R.id.highScore_list);
        noInfo = (TextView) findViewById(R.id.frag_highScore_noInfo);
        createObject();
        createList();
    }

    public void createObject(){
        SharedPreferences sharedPref = getSharedPreferences("User Scores", Context.MODE_PRIVATE);
        tempHashMap = sharedPref.getAll();
        keys = tempHashMap.entrySet().toArray();
    }

    public void createList(){
        if(keys.length==NULL){
            noInfo.setText("Vind et spil for at komme på Highscorelisten!");
        }
        else {
            ListAdapter highScoreListAdapter = new ArrayAdapter<Object>(this, android.R.layout.simple_list_item_1, keys);
            highScore.setAdapter(highScoreListAdapter);
        }
    }
}

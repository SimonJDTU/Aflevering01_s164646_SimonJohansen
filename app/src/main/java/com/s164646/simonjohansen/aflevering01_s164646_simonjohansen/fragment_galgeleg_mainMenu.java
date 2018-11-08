package com.s164646.simonjohansen.aflevering01_s164646_simonjohansen;

        import android.os.Bundle;
        import android.support.v4.app.Fragment;
        import android.support.v7.app.AppCompatActivity;
        import android.view.MenuItem;

        import com.s164646.simonjohansen.aflevering01_s164646_simonjohansen.R;

public class fragment_galgeleg_mainMenu extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_galgeleg_main_menu);

        

        Fragment f = new Fragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragmentindhold, fragment)  // tom container i layout
                .commit();


        setTitle("Hovedaktivitet");
        // Man kan trykke på app-ikonet i øverste venstre hjørne
        // (og det betyder at brugeren vil navigere op i hierakiet)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // brugeren vil navigere op i hierakiet
        }
        return super.onOptionsItemSelected(item);
    }
}



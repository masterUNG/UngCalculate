package masterung.androidthai.in.th.ungcalculate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import masterung.androidthai.in.th.ungcalculate.fragment.MainFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Fragment to Activity
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentMainFragment, new MainFragment())
                    .commit();
        }



    }   // Main Method

    @Override
    public void onClick(View v) {

    }
}   // Main Class

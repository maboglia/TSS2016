package bogliaccino.it.myappboglia;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        ArrayAdapter<String> mioAdapter = new ArrayAdapter<String>(this, R.layout.listitem, R.id.listItemTextView);


        mioAdapter.add("Alessandro");
        mioAdapter.add("Luigi");
        mioAdapter.add("Luigi");
        mioAdapter.add("Gustavo");
        mioAdapter.add("Davide");


        mioAdapter.add("Alessandro");
        mioAdapter.add("Luigi");
        mioAdapter.add("Gustavo");
        mioAdapter.add("Davide");


        final Spinner spinner = (Spinner) findViewById(R.id.spAllievi);


        spinner.setAdapter(mioAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = (String) spinner.getSelectedItem();

                Toast.makeText(getApplicationContext(), "Hai cliccato" + item, Toast.LENGTH_SHORT).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

                Toast.makeText(getApplicationContext(), "Non hai selezionato"
                        , Toast.LENGTH_SHORT).show();


            }
        });


    }
}

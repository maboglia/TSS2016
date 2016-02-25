package bogliaccino.it.myappboglia;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.StringBuilder;

public class Skill extends ActionBarActivity {

    ListView lvSkill;
    String[] skill;
    Button showSkill;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skill);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lvSkill = (ListView) findViewById(R.id.lvSkill);
        skill   = getResources().getStringArray(R.array.skill);

        lvSkill.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lvSkill.setTextFilterEnabled(true);

        showSkill = (Button) findViewById(R.id.btnMostraSelezionati);
        showSkill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostraSelezionati(lvSkill);
            }
        });


        ArrayAdapter<String> mioAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_checked, skill);
        lvSkill.setAdapter(mioAdapter);
        lvSkill.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView) view;
                Toast.makeText(Skill.this, "Hai cliccato su: " + textView.getText() + " posizione: "+ position, Toast.LENGTH_SHORT).show();
                /*
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_WEB_SEARCH);
                intent.putExtra(SearchManager.QUERY, textView.getText());
                startActivity(intent);
                */
            }
        });


    }

    public void mostraSelezionati(ListView ls){
        StringBuilder item = new StringBuilder( "Hai selezionato: \n");
        for (int i = 0; i < ls.getCount(); i++) {
            if(ls.isItemChecked(i))
            {
                item.append(ls.getItemAtPosition(i) + "\n");
            }
        }
                Toast.makeText(this, item, Toast.LENGTH_LONG).show();
    }

}

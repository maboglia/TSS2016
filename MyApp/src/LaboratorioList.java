package bogliaccino.it.myappboglia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class LaboratorioList extends ActionBarActivity {
    Intent i;
    ListView miaListaAttivita;
    String[] mioArAttivita, mioArItemAttivita;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratorio_list);

        miaListaAttivita = (ListView) findViewById(R.id.lvLaboratorio);
        mioArAttivita = getResources().getStringArray(R.array.attivita);
        mioArItemAttivita = getResources().getStringArray(R.array.itemAttivita);


        Intent myIntent = getIntent();
        String messaggio = null;
        try {
            messaggio = myIntent.getStringExtra("NOME");
            if(messaggio.equals("mauro")) {
                TextView tv = (TextView) findViewById(R.id.titoloLab);
                tv.setText(getResources().getString(R.string.title_activity_laboratorio) + " \nyou are logged in as " + messaggio);
            }
        } catch (Exception e) {

            Log.d("errore","non ci sono extra");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mioArItemAttivita);

        miaListaAttivita.setAdapter(adapter);

        miaListaAttivita.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            String temp = mioArAttivita[position];

                try {
                    Class miaClasseDinamica = Class.forName("bogliaccino.it.myappboglia." + temp);
                    Intent i = new Intent(getApplicationContext(), miaClasseDinamica);
                    startActivity(i);

                } catch (ClassNotFoundException e) {
                    //String errore = e.printStackTrace();
                    Toast.makeText(getApplicationContext(),"Non ho trovato la classe " + temp +" errore: ", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

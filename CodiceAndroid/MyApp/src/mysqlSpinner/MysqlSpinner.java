package bogliaccino.it.myappboglia;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import bogliaccino.it.myappboglia.handlers.ServiceHandler;
import bogliaccino.it.myappboglia.model.Prodotti;

public class MysqlSpinner extends ActionBarActivity implements AdapterView.OnItemSelectedListener {

    private Button aggiungiProdotto;
    private TextView catProdotto;
    private Spinner spinnerProdotti;

    private ArrayList<Prodotti> prodottiList;
    ProgressDialog pDialog;

    private String URL_NEW_PRODUCT = "";
    //private String URL_PRODUCTS = "http://192.168.0.233/Prodotti/api_lista_prodotti.php";
    private String URL_PRODUCTS = "http://192.168.1.12/Prodotti/api_lista_prodotti.php";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mysql_spinner);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        aggiungiProdotto = (Button) findViewById(R.id.btnNuovoProdotto);

        spinnerProdotti = (Spinner) findViewById(R.id.spProdotti);

        catProdotto = (TextView) findViewById(R.id.tvSelProdotto);

        prodottiList = new ArrayList<Prodotti>();


        spinnerProdotti.setOnItemSelectedListener(this);



        new GetProdotti().execute();

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private class GetProdotti extends AsyncTask<Void,Void,Void>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            pDialog = new ProgressDialog(MysqlSpinner.this);
            pDialog.setMessage("Sto scaricando l'elenco dei prodotti");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            if(pDialog.isShowing())
                pDialog.dismiss();
            riempiSpinner();

        }

        @Override
        protected Void doInBackground(Void... params) {
            ServiceHandler jsonParser = new ServiceHandler();

            String json = jsonParser.makeServiceCall(URL_PRODUCTS, ServiceHandler.GET);

            Log.d("Risposta: ", "" + json);

            if(json != null){

                try {
                    JSONObject jsonObject = new JSONObject(json);
                    //boolean error = jsonObject.getBoolean("error");

                    if(jsonObject != null){

                        JSONArray products = jsonObject.getJSONArray("prodotti");

                        for (int i = 0; i < products.length(); i++) {
                            Log.d("Risposta: ", "ciclo array" + i);

                            JSONObject prObj = (JSONObject) products.get(i);
                            Prodotti prod = new Prodotti(prObj.getInt("ID"), prObj.getString("Prodotto"), prObj.getString("Descrizione"), prObj.getDouble("Prezzo"));

                            prodottiList.add(prod);
/**/
                        }

                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            } else {

                Log.e("JSON Data", "non ho ricevuto i dati");

            }




            return null;
        }
    }

    private void riempiSpinner() {
        List<String> labels = new ArrayList<String>();

        catProdotto.setText("");
        Log.d("Risposta: ","accedo a riempispinner");
        for (int i = 0; i < prodottiList.size(); i++) {
            Log.d("Risposta", "" + prodottiList.get(i).toString());
            labels.add(prodottiList.get(i).getProdotto());
        }

        // Creating adapter for spinner
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, labels);

        // Drop down layout style - list view with radio button
        spinnerAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerProdotti.setAdapter(spinnerAdapter);



    }


}

package bogliaccino.it.myappboglia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class NoteActivity extends ActionBarActivity {


    private LinearLayout linearLayout;
    TextView tvMostraNota;
    private Button btnNotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.visualizza_note);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        linearLayout = (LinearLayout) findViewById(R.id.llNotes);
        btnNotes = (Button) findViewById(R.id.btnCreaNota);
        tvMostraNota = (TextView) findViewById(R.id.tvMostraNota);

        readDisplayNotes();
        leggiFile("1459846614");
        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SaveNoteActivity.class);
                startActivity(i);
            }
        });



    }

    private void readDisplayNotes() {

        File dirFiles = getFilesDir();

        for (String strFile : dirFiles.list()){

            TextView miaTextView = new TextView(this);
            miaTextView.setText(strFile);

            miaTextView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT ));

            linearLayout.addView(miaTextView);



        }




    }

    private void leggiFile(String filename) {

        String text;
        Reader reader = null;

        try {
            reader = new InputStreamReader(openFileInput(filename));
         StringBuffer aux = new StringBuffer();
        char[] buf = new char[1024];
        int len;

        while ((len=reader.read(buf)) !=-1  ){
            aux.append(buf, 0, len);
        }
        text = aux.toString();
        Toast.makeText(getApplicationContext(),"Testo caricato",Toast.LENGTH_SHORT).show();


        } catch (FileNotFoundException e) {
            text = "";
            Toast.makeText(getApplicationContext(),"File non trovato",Toast.LENGTH_SHORT).show();

            //e.printStackTrace();
        } catch (IOException e) {
            text = "";
            Toast.makeText(getApplicationContext(),"Errore di input",Toast.LENGTH_SHORT).show();
            Log.e("Filedemo","impossibile aprire il file", e);
            //e.printStackTrace();
        }finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }



        }

        tvMostraNota.setText(text);


    }




}

package bogliaccino.it.myappboglia;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class SaveNoteActivity extends ActionBarActivity {


    private EditText etNote;
    private Button btnNotes;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        etNote =   (EditText) findViewById(R.id.etNote);
        btnNotes =   (Button) findViewById(R.id.btnNote);


        btnNotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long unixTime = System.currentTimeMillis() / 1000L;
                String nameFile = String.valueOf(unixTime);
                saveIntoFile(nameFile);

            }

            private void saveIntoFile(String nameFile) {

                try {
                    FileOutputStream outputStream = openFileOutput(nameFile, Context.MODE_PRIVATE);
                    outputStream.write(etNote.getText().toString().getBytes());
                    outputStream.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        });



    }
}

package bogliaccino.it.myappboglia;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MostraFacce extends ActionBarActivity {

    int[] mieiAllievi = {
            R.drawable.a_russo,
            R.drawable.a_dulanto,
            R.drawable.a_rea,
            R.drawable.a_soave,
            R.drawable.a_cimino,
            R.drawable.a_spandre,
            R.drawable.a_scarcia,
            R.drawable.a_calessi,
            R.drawable.a_kodra,
            R.drawable.a_franze,
            R.drawable.a_solia,
            R.drawable.a_migliaccio,
            R.drawable.a_sontacchi,
            R.drawable.a_allen,

    };

    int counter = 0;
    ImageView img;
    Button btn;
    TextView tvNomeAllievo;
    ProgressBar pgAllievi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostra_facce);

        img = (ImageView) findViewById(R.id.ivMostraFacce);
        img.setImageResource(mieiAllievi[0]);
        tvNomeAllievo = (TextView) findViewById(R.id.tvNomeAllievo);
        final String[] allievi = getResources().getStringArray(R.array.allievi);
        btn = (Button)  findViewById(R.id.btnNextFaccia);
        pgAllievi = (ProgressBar) findViewById(R.id.progressBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (counter == mieiAllievi.length){
                    counter = 0;
                }
                //Toast.makeText(MostraFacce.this,"prova" + counter, Toast.LENGTH_SHORT).show();
                tvNomeAllievo.setText(allievi[counter]);
                img.setImageResource(mieiAllievi[counter]);
                pgAllievi.setProgress(counter);
                counter++;
            }
        });
    }

}

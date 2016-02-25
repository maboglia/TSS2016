package bogliaccino.it.myappboglia;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class LanciaDadi extends ActionBarActivity {

    private Dado dado1;
    private Dado dado2;

    ImageView imgDado1, imgDado2;
    Button btnLancia;

    AnimationDrawable miaAnimazione;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lancia_dadi);

        imgDado1 = (ImageView) findViewById(R.id.dadoSx);
        imgDado2 = (ImageView) findViewById(R.id.dadoDx);

        miaAnimazione = (AnimationDrawable) imgDado1.getDrawable();

        btnLancia = (Button) findViewById(R.id.btnLanciaDadi);

        miaAnimazione.start();

        dado1 = new Dado();
        dado2 = new Dado();
    }

    public void lanciaDadi(View view) {


        dado1.lanciaDado();
        dado2.lanciaDado();

        int faccia1 = dado1.getFaccia();
        int faccia2 = dado2.getFaccia();

        Toast.makeText(this, "dado 1 vale " + faccia1 + "\ndado 2 vale "
                + faccia2, Toast.LENGTH_SHORT).show();

        imgDado1.setImageResource(trovaFaccia(dado1));
        imgDado2.setImageResource(trovaFaccia(dado2));

    }

    private int trovaFaccia(Dado d){

        switch (d.getFaccia()){

            case 1:
                return R.drawable.f1;
            case 2:
                return R.drawable.f2;
            case 3:
                return R.drawable.f3;
            case 4:
                return R.drawable.f4;
            case 5:
                return R.drawable.f5;
            case 6:
                return R.drawable.f6;
            default:
            return 0;
        }


    }



}

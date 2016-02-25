package bogliaccino.it.myappboglia;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;
import android.os.Handler;
import java.util.logging.LogRecord;

public class Musica extends ActionBarActivity {

    Button back, fwd, play,pause;
    ImageView copertinaBrano;
    SeekBar seekbar;
    TextView esecuzione, durata, titolo;
    Animation animRotation;
    MediaPlayer mediaPlayer;

    String titoloBrano = "Vasco Rossi - Divertimento";

    double startTime=0;
    double finalTime=0;
    int fwdTime = 5000;
    int bwdTime = 5000;

    public static int oneTime = 0;

    Handler mioHandler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //bottoni di gestione
        back = (Button) findViewById(R.id.btnBack);
        fwd = (Button) findViewById(R.id.btnFwd);
        play = (Button) findViewById(R.id.btnPlay);
        pause = (Button) findViewById(R.id.btnPause);

        //test informativi, titolo, durata, timing
        esecuzione = (TextView) findViewById(R.id.tvEsecuzione);
        durata = (TextView) findViewById(R.id.tvDurata);
        titolo = (TextView) findViewById(R.id.tvTitoloBrano);

        //mostra visivamente l'esecuzione della traccia
        seekbar = (SeekBar) findViewById(R.id.seekBrano);
        seekbar.setClickable(false);
        seekbar.setEnabled(false);


        copertinaBrano = (ImageView) findViewById(R.id.imgMusica);
        animRotation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotation);

        mediaPlayer = MediaPlayer.create(this, R.raw.divertimento);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "sta suonando " + titoloBrano, Toast.LENGTH_SHORT).show();

                titolo.setText(titoloBrano);

                copertinaBrano.startAnimation(animRotation);

                mediaPlayer.start();

                //memorizzo la durata del brano
                finalTime = mediaPlayer.getDuration();

                //rilevo la posizione corrente del brano
                startTime = mediaPlayer.getCurrentPosition();

                //setto il valore max della seekbar e impedisco il loop
                if(oneTime == 0)
                {
                    seekbar.setMax((int) finalTime);
                    oneTime=1;
                }

                esecuzione.setText(
                String.format("esecuzione: %d min , %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))

                        )

                );

                durata.setText(
                String.format("durata: %d min , %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) finalTime))

                        )

                );


                seekbar.setProgress((int) startTime);

                mioHandler.postDelayed(AggiornaBarra, 100);

                pause.setEnabled(true);
                play.setEnabled(false);

            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.pause();
                pause.setEnabled(false);
                play.setEnabled(true);
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp - bwdTime) >= 0 ) {
                    startTime = startTime - bwdTime;
                    mediaPlayer.seekTo((int) startTime);
                } else
                    Toast.makeText(getApplicationContext(), "NON SI PUO", Toast.LENGTH_SHORT).show();

            }
        });


        fwd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int temp = (int) startTime;

                if ((temp + fwdTime) <= finalTime ) {
                    startTime = startTime + fwdTime;
                    mediaPlayer.seekTo((int) startTime);
                } else
                    Toast.makeText(getApplicationContext(), "NON SI PUO", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private Runnable AggiornaBarra = new Runnable() {
        @Override
        public void run() {

            startTime = mediaPlayer.getCurrentPosition();
            esecuzione.setText(
                    String.format("esecuzione: %d min , %d sec",
                            TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                            TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                    TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long) startTime))

                    )

            );
            seekbar.setProgress((int) startTime);
            mioHandler.postDelayed(this, 100);

        }
    };

}

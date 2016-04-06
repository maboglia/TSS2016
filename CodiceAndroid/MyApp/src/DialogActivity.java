package it.bogliaccino.mypersonalwebapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.Toast;


public class DialogActivity extends Activity {

    final CharSequence[] items = {"Blue", "Red", "Green"};

    private ProgressDialog barProgressDialog;
    private Handler updateBarHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        updateBarHandler = new Handler();

        //showDialog();
        //showDialogWithList();
        //showDialogWithCheckBox();
        //showRingDialog();
        //showBarDialog();
        showCustomDialog();

    }

    private void showCustomDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        LayoutInflater inflater = getLayoutInflater();

        builder.setView(inflater.inflate(R.layout.custom_dialog, null))
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"ciao",Toast.LENGTH_SHORT).show();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();





    }

    private void showBarDialog() {

        barProgressDialog = new ProgressDialog(DialogActivity.this);

        barProgressDialog.setTitle("Speta na minuta");
        barProgressDialog.setMessage("Sto lavorando, signora!");
        barProgressDialog.setProgressStyle(barProgressDialog.STYLE_HORIZONTAL);
        barProgressDialog.setProgress(0);
        barProgressDialog.setMax(100);
        barProgressDialog.show();

        new Thread(new Runnable() {
            @Override
            public void run() {


                try {

                    while (barProgressDialog.getProgress() <= barProgressDialog.getMax()){

                        Thread.sleep(2000);
                        updateBarHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                barProgressDialog.incrementProgressBy(10);
                            }
                        });

                        if(barProgressDialog.getProgress() == barProgressDialog.getMax()){

                            barProgressDialog.dismiss();
                        }




                    }



                }catch (InterruptedException e){
                    e.printStackTrace();
                }



            }
        }).start();




    }

    private void showRingDialog() {

        final ProgressDialog ringProgressDialog = ProgressDialog.show(DialogActivity.this, "Speta na minuta", "Sto lavorando, signora!", true);

        ringProgressDialog.setCancelable(true);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            ringProgressDialog.dismiss();

            }
        }).start();


    }

    private void showDialogWithCheckBox() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Scegli un colore");
        builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();

    }

    private void showDialogWithList() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Scegli un colore");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), items[which], Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();





    }

    private void showDialog() {

        new AlertDialog.Builder(this)
                .setTitle("Mio dialog")
                .setMessage("Vuoi chiudere l'app")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d("MioDialog", "Allora continua pure");
                    }
                }).show();


    }

}

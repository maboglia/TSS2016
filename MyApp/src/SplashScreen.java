package bogliaccino.it.myappboglia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashScreen extends Activity {

    ImageView logo;
    Animation animFadeOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        logo = (ImageView) findViewById(R.id.imgSplash);
        animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        logo.startAnimation(animFadeOut);
    }

    public void goHomePage(View view) {

        //Intent i = new Intent(this, HomePage.class);
        //startActivity(i);

        Intent intent = new Intent();
        intent.setClassName("bogliaccino.it.myappboglia","bogliaccino.it.myappboglia.HomePage");

        startActivity(intent);


    }
}

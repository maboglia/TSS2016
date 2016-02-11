package bogliaccino.it.myappboglia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

public class About extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void goSkill(View view) {

        startActivity(new Intent(About.this, Skill.class));

    }

    public void goBio(View view) {
        startActivity(new Intent(About.this, Bio.class));

    }
}

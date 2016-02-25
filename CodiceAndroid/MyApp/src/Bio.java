package bogliaccino.it.myappboglia;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.webkit.WebView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Bio extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bio_html);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView mioTitolo = (TextView) findViewById(R.id.tvTitoloShortBio);

        WebView webview = (WebView) findViewById(R.id.wvMyShortBioPage);

        webview.loadData(leggiHtmlDalleRisorse(R.raw.short_bio), "text/html", "utf-8");

        mioTitolo.setText(Html.fromHtml("<a href=\"http://www.bogliaccino.it\">Go TO My Web Site</a>"));
        mioTitolo.setMovementMethod(LinkMovementMethod.getInstance());


    }

    private String leggiHtmlDalleRisorse(int short_bio) {

        InputStream raw = getResources().openRawResource(short_bio);

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        int i;

        try {
            i = raw.read();

            while(i!=-1){
                stream.write(i);
                i = raw.read();
            }

            raw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return stream.toString();

    }

}

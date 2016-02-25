package bogliaccino.it.myappboglia;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MyWebSite extends ActionBarActivity {

    WebView mioSitoWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_site);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mioSitoWeb = (WebView) findViewById(R.id.wvMyWebSite);
        mioSitoWeb.setWebViewClient(new MioWebClient());

        mioSitoWeb.getSettings().setJavaScriptEnabled(true);
        mioSitoWeb.getSettings().setUseWideViewPort(true);
        mioSitoWeb.getSettings().setLoadWithOverviewMode(true);

        mioSitoWeb.loadUrl("file:///android_asset/index.html");


    }

    private class MioWebClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }



}

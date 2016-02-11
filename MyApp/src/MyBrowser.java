package bogliaccino.it.myappboglia;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;


public class MyBrowser extends Activity {


    private WebView myWebView;
    private EditText myUrlBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_browser);

        myWebView = (WebView) findViewById(R.id.wvMyWebBrowser);
        myUrlBar = (EditText) findViewById(R.id.etUrl);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.getSettings().setUseWideViewPort(true);
        myWebView.getSettings().setLoadWithOverviewMode(true);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void btnVai(View view) {

        myWebView.loadUrl(myUrlBar.getText().toString());

    }

    public void btnBack(View view) {
        if(myWebView.canGoBack())
        myWebView.goBack();
    }

    public void btnFwd(View view) {
        if(myWebView.canGoForward())
        myWebView.goForward();
    }

    public void btnRld(View view) {
        myWebView.reload();
    }

    public void btnClr(View view) {
        myWebView.clearHistory();
    }
}

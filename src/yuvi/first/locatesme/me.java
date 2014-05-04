package yuvi.first.locatesme;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;



public class me extends Activity  {

	@Override
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	    setContentView(R.layout.me);
	   String path = getIntent().getExtras().getString("link");
	   
	   WebView browser =(WebView) findViewById(R.id.webview);

	   browser.loadUrl(path);
	    WebSettings webSettings = browser.getSettings();
	    webSettings.setJavaScriptEnabled(true);
	   browser.setWebViewClient(new WebViewClient());

	}
	
	
}

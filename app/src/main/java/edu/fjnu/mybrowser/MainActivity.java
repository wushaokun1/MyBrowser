package edu.fjnu.mybrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        Uri data = intent.getData();
        URL url = null;
        try{
            url = new URL(data.getScheme(),data.getHost(),data.getPath());

        }catch (Exception e){
            e.printStackTrace();
        }
        startBrowser(url);
    }

    private void startBrowser(URL url){
        WebView webView = findViewById(R.id.webView);
        //加载web资源
        webView.loadUrl(url.toString());
        //覆盖webview默认第三方或者系统默认有拉起打开网页得行为
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
    }
}

package com.example.sti;


import android.webkit.WebView;
import android.webkit.WebViewClient;

// class is extended to WebViewClient to access the WebView
public class WebViewController extends WebViewClient {
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {

        // loadurl function will load the
        // url we will provide to our webview
        view.loadUrl(url);
        return true;
    }
}
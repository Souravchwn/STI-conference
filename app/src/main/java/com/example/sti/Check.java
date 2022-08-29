package com.example.sti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Check extends AppCompatActivity {
    private static final String TAG = "Check";
    String[] idsToHide = { "intro", "about", "publication" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        final WebView webView = (WebView) findViewById(R.id.webview);
        webView.getSettings().setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // TODO Auto-generated method stub
                super.onPageFinished(view, url);

                //run 'disableSection' for all divs to hide/disable
                for (String s : idsToHide) {
                    String surveyId = s;
                    view.loadUrl("javascript:disableSection('" + surveyId + "'), null;");
                    view.loadUrl("javascript:document.getElementById(' "+ surveyId + "').setAttribute(\"style\",\"display:none;\");");
                    view.loadUrl("javascript:document.getElementsByClassName(' "+ surveyId + "').setAttribute(\"style\",\"display:none;\");");
                    view.loadUrl("javascript:document.getElementsByClassName(' "+ surveyId + "').setAttribute(\"style\",\"display:none;\");");
                    view.loadUrl("javascript:document.getElementById(' "+ surveyId + "').setAttribute(style,display:none;);");
                }
            }
        });
        //load webpage from assets
        webView.loadUrl("https://fse.green.edu.bd/sti-2021");
    }

/*
        String[] idsToHide = { "intro", "about", "publication" };


        String url="https://fse.green.edu.bd/sti-2021";

        Document doc = null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements ele = doc.select("div#intro");
        webView.loadData(ele.toString(), "text/html", "utf-8");

        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
        webView.setScrollbarFadingEnabled(false);

       webView.evaluateJavascript("document.getElementsByTagName('header')[0].style.display = 'none';", null);
        webView.evaluateJavascript("document.getElementsByTagName('footer')[0].style.display = 'none';", null);
        webView.evaluateJavascript("document.getElementsByTagName('globalfooter')[0].style.display = 'none';", null);
        webView.evaluateJavascript("document.getElementsByClassName('intro-container wow fadeIn')[0].style.display = 'none';", null);
        webView.evaluateJavascript("document.getElementsByTagName('intro')[0].style.display = 'none';", null);


        webView.evaluateJavascript("document.getElementById('intro')[0].style.display = 'none';", null);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onLoadResource(WebView view, String url) {
                super.onLoadResource(view, url);
                Log.d(TAG, "onLoadResource: " + url);
            }
            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:({ " +
                        "document.getElementByTagName('intro')[0].innerHTML"+
                        "document.getElementByTagName('about').style.display='none';"+
                        "document.getElementById('counter')[0].style.display='none';"+
                        "document.getElementById('intro')[0].style.display='none';"+
                        "document.getElementById('about')[0].style.display='none';"+
                        "})()");

            }
            final MyWebClient myWebViewClient = new MyWebClient();
mWebView.setWebViewClient(myWebViewClient);


             */
    }

        /* class MyWebClient extends WebViewClient {

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                view.loadUrl("javascript:(function() { " +
                        "document.getElementsByClassName('header_wrapper')[0].style.display='none'; " +
                        "document.getElementsByClassName('footer-contact')[0].style.display='none'; "+
                        "document.getElementsByClassName('navbar-header')[0].style.display='none'; "+
                        "document.getElementsByClassName('footer-social')[0].style.display='none'; "+
                        "document.getElementById('intro').style.display='none'; "+
                        "document.getElementById('about').style.display='none'; , null"+
                        "document.getElementById('core_mobile_menu').style.display='none'; "+
                        "document.getElementById('catapult-cookie-bar').style.display='none'; "+
                        "})()"
                );
            }
        }

    }
}

         */

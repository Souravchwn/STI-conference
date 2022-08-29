package com.example.sti;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

public class view_pdf extends AppCompatActivity {
    private int i = 0;

    private WebView pdfView;
    private ProgressBar progress;
    String urls;
    private String removePdfTopIcon = "javascript:(function() {" + "document.querySelector('[role=\"toolbar\"]').remove();})()";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.red));
        }
        pdfView= findViewById(R.id.view_pdf);
        progress=findViewById(R.id.progress);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            urls = bundle.getString("url");
        }
        showPdfFile(urls);

    }

    private void showPdfFile(String url) {
        showProgress();
        pdfView.getSettings().setSupportZoom(true);
        pdfView.getSettings().setJavaScriptEnabled(true);
        pdfView.loadUrl(url);

        pdfView.setWebViewClient(new WebViewClient() {
            boolean checkOnPageStartedCalled = false;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                checkOnPageStartedCalled = true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                if (checkOnPageStartedCalled) {
                    pdfView.loadUrl(removePdfTopIcon);
                    hideProgress();
                } else {
                    showPdfFile(url);
                }
            }
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Intent i = new Intent(Intent.ACTION_VIEW, request.getUrl());
                startActivity(i);
                return true;
            }
        });
    }

    private void showProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    private void hideProgress() {
        progress.setVisibility(View.GONE);
    }
}


        /*

        // Firstly we are showing the progress
        // dialog when we are loading the pdf
        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading..");
        dialog.show();

        htmltags= "iframe src='http://docs.google.com/viewer?embedded=true&url=https://drive.google.com/file/d/19GQI9bxsSeGtYVVv_x9zH8F3AHOXjg52/view?usp=sharing'></iframe>";
        setWebViewProperty();
        if (checkNetworkStatus(view_pdf.this))
        {//check internet connection if true
            webview.loadData(htmltags, "text/html", "UTF-8");
        }else {// else show error toast
            Toast.makeText(this, "internet connection problem !", Toast.LENGTH_SHORT).show();
        }

        // getting url of pdf using getItentExtra
        urls = getIntent().getStringExtra("url");

        webview=findViewById(R.id.view_pdf);
        webview.setWebViewClient(new WebViewClient());
        //webview.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url="+"http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf");
        dialog.dismiss();
    }
    private void setWebViewProperty() { webview.getSettings().setJavaScriptEnabled(true); webview.getSettings().setAllowFileAccess(true); webview.getSettings().setPluginState(WebSettings.PluginState.ON); webview.getSettings().setLoadsImagesAutomatically(true); webview.getSettings().setJavaScriptEnabled(true); webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); webview.setInitialScale(1); webview.getSettings().setBuiltInZoomControls(true); webview.getSettings().setUseWideViewPort(true);
    }
    public boolean checkNetworkStatus(Context context) {
        boolean HaveConnectedWifi = false;
        boolean HaveConnectedMobile = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) context .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo[] netInfo = cm.getAllNetworkInfo();
            for (NetworkInfo ni : netInfo) {
                if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                    if (ni.isConnected()) HaveConnectedWifi = true;
                if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                    if (ni.isConnected()) HaveConnectedMobile = true;
            }
        } catch (Exception e) { e.printStackTrace();
        }
        return HaveConnectedWifi || HaveConnectedMobile;
    }*/

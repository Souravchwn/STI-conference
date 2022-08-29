package com.example.sti.ui.call;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.sti.R;
import com.example.sti.*;
import com.example.sti.ui.*;
import com.example.sti.ui.about.AboutStiViewModel;

public class callforpaper extends Fragment {

    private  CallforpaperViewModel callforpaper;
    private WebView webView;
    public String fileName = "call for paper.html";

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        callforpaper =
                ViewModelProviders.of(this).get(CallforpaperViewModel.class);

        View root = inflater.inflate(R.layout.callforpaper_fragment, container, false);
        WebView webView = root.findViewById(R.id.callforpaper_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}

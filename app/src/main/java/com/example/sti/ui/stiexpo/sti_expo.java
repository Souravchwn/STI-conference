package com.example.sti.ui.stiexpo;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.sti.R;
import com.example.sti.WebViewController;
import com.example.sti.ui.call.CallforpaperViewModel;

public class sti_expo extends Fragment {

    private StiExpoViewModel stiExpoViewModel;
    private WebView webView;
    public String fileName = "STI expo.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        stiExpoViewModel =
                ViewModelProviders.of(this).get(StiExpoViewModel.class);
        View root = inflater.inflate(R.layout.sti_expo_fragment, container, false);
        WebView webView = root.findViewById(R.id.stiexpo_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }

}

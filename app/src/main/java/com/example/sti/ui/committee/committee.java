package com.example.sti.ui.committee;

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
import com.example.sti.ui.dates.DatesViewModel;

public class committee extends Fragment {

    private CommitteeViewModel committeeViewModel;

    private WebView webView;
    public String fileName = "committe.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        committeeViewModel =
                ViewModelProviders.of(this).get(CommitteeViewModel.class);
        View root = inflater.inflate(R.layout.committee_fragment, container, false);
        WebView webView = root.findViewById(R.id.committee_webview);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;

    }

}

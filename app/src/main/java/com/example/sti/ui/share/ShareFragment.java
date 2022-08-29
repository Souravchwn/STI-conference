package com.example.sti.ui.share;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.sti.R;
import com.example.sti.*;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;
    public String fileName = "SPONSORS.html";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
        WebView webView = root.findViewById(R.id.sponsor_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);
        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}
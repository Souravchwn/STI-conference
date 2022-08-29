package com.example.sti.ui.publication;

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
import com.example.sti.*;


public class publication extends Fragment {

    private PublicationViewModel publicationViewModel;

    private WebView webView;
    public String fileName = "publication.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        publicationViewModel =
                ViewModelProviders.of(this).get(PublicationViewModel.class);
        View root = inflater.inflate(R.layout.publication_fragment, container, false);
        WebView webView = root.findViewById(R.id.publication_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}

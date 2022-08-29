package com.example.sti.ui.about;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.sti.R;
import com.example.sti.*;

import com.example.sti.ui.call.CallforpaperViewModel;

public class about_sti extends Fragment {

    private AboutStiViewModel aboutStiViewModel;
    private WebView webView;
    public String fileName = "about.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        aboutStiViewModel =
                ViewModelProviders.of(this).get(AboutStiViewModel.class);
        View root = inflater.inflate(R.layout.about_sti_fragment, container, false);
        WebView webView = root.findViewById(R.id.about_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }

}

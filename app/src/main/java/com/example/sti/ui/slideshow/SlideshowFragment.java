package com.example.sti.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sti.R;
import com.example.sti.WebViewController;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private WebView webView;
    public String fileName = "speakerUpdate.html";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        WebView webView = root.findViewById(R.id.speaker_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}
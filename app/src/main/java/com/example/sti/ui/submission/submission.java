package com.example.sti.ui.submission;

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

public class submission extends Fragment {

    private SubmissionViewModel submissionViewModel;

    private WebView webView;
    public String fileName = "submission.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        submissionViewModel =
                ViewModelProviders.of(this).get(SubmissionViewModel.class);
        View root = inflater.inflate(R.layout.submission_fragment, container, false);
        WebView webView = root.findViewById(R.id.submission_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }

}

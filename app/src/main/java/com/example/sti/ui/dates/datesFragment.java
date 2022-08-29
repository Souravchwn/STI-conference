package com.example.sti.ui.dates;

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
import com.example.sti.WebViewController;
import com.example.sti.ui.gallery.GalleryViewModel;

public class datesFragment extends Fragment {

    private DatesViewModel datesViewModel;
    private WebView webView;
    public String fileName = "important dates.html";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        datesViewModel =
                ViewModelProviders.of(this).get(DatesViewModel.class);
        View root = inflater.inflate(R.layout.dates_fragment, container, false);
        WebView webView = root.findViewById(R.id.date_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);

        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;

    }
}

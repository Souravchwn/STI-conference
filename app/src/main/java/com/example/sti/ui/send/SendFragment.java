package com.example.sti.ui.send;

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
import com.example.sti.*;

public class SendFragment extends Fragment {

    private SendViewModel sendViewModel;
    public String fileName = "contract.html";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(SendViewModel.class);
        View root = inflater.inflate(R.layout.fragment_send, container, false);
        WebView webView = root.findViewById(R.id.contract_w);

        // Url of website is passed here
        webView.loadUrl("file:///android_asset/" + fileName);
        // WebViewController is used
        webView.setWebViewClient(new WebViewController());
        return root;
    }
}
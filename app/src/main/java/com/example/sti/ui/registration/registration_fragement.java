package com.example.sti.ui.registration;

import androidx.lifecycle.ViewModelProviders;

import android.app.ProgressDialog;
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

import com.example.sti.login_registration.SignUpActivity;
import com.example.sti.ui.send.SendViewModel;

public class registration_fragement extends Fragment {

    private RegistrationFragementViewModel registrationFragementViewModel;
    public String fileName = "SPONSORS.html";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        registrationFragementViewModel =
                ViewModelProviders.of(this).get(RegistrationFragementViewModel.class);
        View root = inflater.inflate(R.layout.registration_fragement_fragment, container, false);
        WebView webView = root.findViewById(R.id.registration_w);
        ProgressDialog dialog=new ProgressDialog(getContext());
        dialog.setMessage("Please Wait.....");
        dialog.setCancelable(false);
        dialog.setInverseBackgroundForced(false);
        dialog.show();
        // Url of website is passed here


        webView.loadUrl("http://fse.green.edu.bd/sti-2020/registration");
        // WebViewController is used
        dialog.dismiss();
        webView.setWebViewClient(new WebViewController());
        return root;
    }

}

package com.example.sti.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.sti.R;
import com.example.sti.eventview;
import com.example.sti.login_registration.SignInActivity;
import com.example.sti.notepad.notepad_sti;
import com.example.sti.paid_link;
import com.example.sti.paid_notice_board;
import com.example.sti.sti_web;
import com.example.sti.ui.about.about_sti;
import com.example.sti.ui.committee.committee;
import com.example.sti.ui.dates.datesFragment;
import com.example.sti.ui.event.event;
import com.example.sti.ui.gallery.GalleryFragment;
import com.example.sti.ui.share.ShareFragment;
import com.example.sti.ui.slideshow.SlideshowFragment;
import com.example.sti.view_pdf;

;import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private WebView webView;
    public String fileName = "intro.html";
    private CardView cardview,cardview1,cardview2,cardview3,cardview4,cardview5,cardview6,cardview7,cardview8,cardview9,cardview10,cardview11,cardview12,cardview13,cardview14,cardview15;
    private Fragment fragment;
    private ImageView login;
    private TextView stiweb,stiweb1;
    private TextView current1,current2,current3,current4,next1,next2,next3,next4;
    private Handler mHandler = new Handler();
    private TextView time1,time2,time3,time4;
    private  String time_pass1,time_pass2,time_pass3,time_pass4;

    private CardView cardview16,cardview17,cardview18,cardview19;

    String zoom_link_pass,zoom_link_pass2,zoom_link_pass3,zoom_link_pass4,text_view_pass1,text_view_pass2,text_view_pass3,text_view_pass4,text_view_pass5,text_view_pass6,text_view_pass7,text_view_pass8;
    String name_view_pass1,name_view_pass2,name_view_pass3,name_view_pass4;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //identify cards with root for fragment.
        cardview= root.findViewById(R.id.firstcard);
        cardview1=root.findViewById(R.id.secondcard);
        cardview2=root.findViewById(R.id.card3);
        cardview3=root.findViewById(R.id.card4);
        cardview4=root.findViewById(R.id.card5);
        cardview5=root.findViewById(R.id.card6);
        login=root.findViewById(R.id.imageView2);
        stiweb=root.findViewById(R.id.textView1);
        stiweb1=root.findViewById(R.id.textView22);
        return root;
}



    public void onViewCreated(View view,Bundle saveInstanceState){
        super.onViewCreated(view,saveInstanceState);
        stiweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), sti_web.class);
                startActivity(intent);
            }
        });
        stiweb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), sti_web.class);
                startActivity(intent);
            }
        });


        cardview.setOnClickListener(new View.OnClickListener() {          //sti about card
            @Override
            public void onClick(View view) {
                fragment= new GalleryFragment();
                FragmentManager fm= getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fm.beginTransaction();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new about_sti();
                FragmentManager fm= getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fragment);
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new SlideshowFragment();
                FragmentManager fm= getActivity().getSupportFragmentManager();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new committee();
                FragmentManager fm= getActivity().getSupportFragmentManager();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragment= new datesFragment();
                FragmentManager fm= getActivity().getSupportFragmentManager();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        cardview5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fragment= new ShareFragment();
                FragmentManager fm= getActivity().getSupportFragmentManager();
                fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                FragmentTransaction transaction = fm.beginTransaction();
                transaction.replace(R.id.nav_host_fragment, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
                /*
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);*/
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SignInActivity.class);
                startActivity(intent);
            }
        });

        /*
        cardview6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if(zoom_link_pass!=null)
                {
                    String a = zoom_link_pass;
                    if(a.contains("No link"))
                    {
                        Toast.makeText(getContext(),"Sorry! "+ a,Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(getContext(),"Joining "+ a,Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(a));
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(getContext(),"Sorry! No event is ongoing",Toast.LENGTH_LONG).show();
                }

            }
        });
        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= zoom_link_pass2;

                if(a.contains("No link"))
                {
                    Toast.makeText(getContext(),"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Joining "+ a,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(a));
                    startActivity(intent);
                }

            }
        });
        cardview8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= zoom_link_pass3;

                if(a.contains("No link"))
                {
                    Toast.makeText(getContext(),"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Joining "+ a,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(a));
                    startActivity(intent);
                }
            }
        });
        cardview9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= zoom_link_pass4;

                if(a.contains("No link"))
                {
                    Toast.makeText(getContext(),"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getContext(),"Joining "+ a,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(a));
                    startActivity(intent);
                }
            }
        });
        cardview14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), eventview.class);
                startActivity(intent);
            }
        });
        cardview17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), notepad_sti.class);
                startActivity(intent);
            }
        });
        cardview18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), paid_notice_board.class);
                startActivity(intent);
            }
        });
        */
    }
    public void onDestory()
    {
        super.onDestroy();

    }
    @RequiresApi(api = Build.VERSION_CODES.O)

    public void timer()
    {

    }
}

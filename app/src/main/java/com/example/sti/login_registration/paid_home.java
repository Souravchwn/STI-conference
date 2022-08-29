package com.example.sti.login_registration;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sti.R;
import com.example.sti.eventview;
import com.example.sti.notepad.notepad_sti;
import com.example.sti.paid_link;
import com.example.sti.paid_notice_board;
import com.example.sti.ui.home.HomeViewModel;
import com.example.sti.user_profile;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class paid_home extends AppCompatActivity {

    private CardView cardview, cardview1, cardview2, cardview3, cardview4, cardview5, cardview6;
    TextView text1, text2, text3;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference, user_nameref, user_nameref1;
    String Registered_user_count;
    int count = 0, total_registered = 214;

    private HomeViewModel homeViewModel;
    private WebView webView;
    public String fileName = "intro.html";
    private CardView cardview7,cardview8,cardview9,cardview10,cardview11,cardview12,cardview13,cardview14,cardview15;
    private Fragment fragment;
    private TextView current1,current2,current3,current4,next1,next2,next3,next4;
    private Handler mHandler = new Handler();
    private TextView time1,time2,time3,time4;
    private  String time_pass1,time_pass2,time_pass3,time_pass4;

    private CardView cardview16,cardview17,cardview18,cardview19;

    String zoom_link_pass,zoom_link_pass2,zoom_link_pass3,zoom_link_pass4,text_view_pass1,text_view_pass2,text_view_pass3,text_view_pass4,text_view_pass5,text_view_pass6,text_view_pass7,text_view_pass8;
    String name_view_pass1,name_view_pass2,name_view_pass3,name_view_pass4;

    public String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_home);


        cardview = findViewById(R.id.card1);
        cardview1 = findViewById(R.id.card2);
        cardview2 = findViewById(R.id.card3);
        cardview3 = findViewById(R.id.card4);
        text1 = findViewById(R.id.reg_counter);
        text2 = findViewById(R.id.Total_counter);
        text3 = findViewById(R.id.loggedin);

        time1=findViewById(R.id.time1);
        time2=findViewById(R.id.time2);
        time3=findViewById(R.id.time3);
        time4=findViewById(R.id.time4);




        cardview6=findViewById(R.id.cs1);
        cardview7=findViewById(R.id.cs2);
        cardview8=findViewById(R.id.cs3);
        cardview9=findViewById(R.id.cs4);

        cardview10=findViewById(R.id.ns1);
        cardview11=findViewById(R.id.ns2);
        cardview12=findViewById(R.id.ns3);
        cardview13=findViewById(R.id.ns4);

        current1=findViewById(R.id.cs_text1);
        current2=findViewById(R.id.cs_text2);
        current3=findViewById(R.id.cs_text3);
        current4=findViewById(R.id.cs_text4);

        cardview14=findViewById(R.id.eventdetails);

        next1=findViewById(R.id.ns_text1);
        next2=findViewById(R.id.ns_text2);
        next3=findViewById(R.id.ns_text3);
        next4=findViewById(R.id.ns_text4);

        current1.setSelected(true);
        current2.setSelected(true);
        current3.setSelected(true);
        current4.setSelected(true);

        next1.setSelected(true);
        next2.setSelected(true);
        next3.setSelected(true);
        next4.setSelected(true);

        cardview7.setVisibility(View.INVISIBLE);
        cardview8.setVisibility(View.INVISIBLE);
        cardview9.setVisibility(View.INVISIBLE);

        cardview11.setVisibility(View.INVISIBLE);
        cardview12.setVisibility(View.INVISIBLE);
        cardview13.setVisibility(View.INVISIBLE);

        mRunnable.run();


        text2.setText("Total registered Attendees of STI conference:-" + total_registered);
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.red));
        }

        //Count people on firebase

        firebaseDatabase = FirebaseDatabase.getInstance();
        uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        System.out.println("sourav---" + uid);
        databaseReference = firebaseDatabase.getReference("User ID (Registered users");
        databaseReference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // Retrieving Data from firebase
                count = (int) dataSnapshot.getChildrenCount();

                text1.setText("Total application user:- " + Integer.toString(count));

                System.out.println("Sourav user - " + count);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {


            }
        });
        firebaseDatabase = FirebaseDatabase.getInstance();
        user_nameref = firebaseDatabase.getInstance().getReference("User").child(uid);

        user_nameref1 = user_nameref.child(uid);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        user_nameref.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String names = "" + dataSnapshot.child("firstName").getValue();
                // setting data to our text view

                text3.setText("Welcome " + names + ".");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


        cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(paid_home.this, eventview.class);
                startActivity(intent);
            }
        });
        cardview1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(paid_home.this, notepad_sti.class);
                startActivity(intent);
            }
        });

        cardview2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(paid_home.this, user_profile.class);
                startActivity(intent);
            }
        });
        cardview3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(paid_home.this, paid_notice_board.class);
                startActivity(intent);
            }
        });
        cardview14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(paid_home.this, eventview.class);
                startActivity(intent);
            }
        });
        cardview6.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                if(zoom_link_pass!=null)
                {
                    String a = zoom_link_pass;
                    if(a.contains("No link"))
                    {
                        Toast.makeText(paid_home.this,"Sorry! "+ a,Toast.LENGTH_LONG).show();
                    }
                    else{
                        Toast.makeText(paid_home.this,"Joining "+ a,Toast.LENGTH_SHORT).show();

                        Intent intent = new Intent();
                        intent.setAction(Intent.ACTION_VIEW);
                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
                        intent.setData(Uri.parse(a));
                        startActivity(intent);
                    }
                }
                else
                {
                    Toast.makeText(paid_home.this,"Sorry! No event is ongoing",Toast.LENGTH_LONG).show();
                }

            }
        });
        cardview7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String a= zoom_link_pass2;

                if(a.contains("No link"))
                {
                    Toast.makeText(paid_home.this,"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(paid_home.this,"Joining "+ a,Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(paid_home.this,"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(paid_home.this,"Joining "+ a,Toast.LENGTH_SHORT).show();

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
                    Toast.makeText(paid_home.this,"Sorry! "+ a,Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(paid_home.this,"Joining "+ a,Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(a));
                    startActivity(intent);
                }
            }
        });


    }

    public void onDestory() {
        super.onDestroy();

    }

    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            List<String> list = new ArrayList<String>();
            list.add("08:30 AM - 09:30 AM");
            list.add("09:30 AM - 10:15 AM");
            list.add("10:15 AM - 11:00 AM");
            list.add("11:00 AM - 11:15 AM");
            list.add("11:15 AM - 12:00 PM");
            list.add("12:00 PM - 01:00 PM");
            list.add("12:00 PM - 01:00 PM");
            list.add("12:00 PM - 01:00 PM");
            list.add("01:00 PM - 02:00 PM");
            list.add("02:00 PM - 02:45 PM");
            list.add("02:45 PM - 03:30 PM");
            list.add("03:30 PM - 04:30 PM");
            list.add("03:30 PM - 04:45 PM");
            list.add("03:30 PM - 04:45 PM");
            list.add("03:30 PM - 04:45 PM");
            list.add("04:45 PM - 05:15 PM");
            list.add("05:15 PM - 05:45 PM");
            list.add("05:45 PM - 06:15 PM");
            list.add("06:15 PM - 07:00 PM");

            List<String> demo = new ArrayList<String>();
            demo.add("01:25 PM - 01:27 PM");
            demo.add("01:27 PM - 01:29 PM");
            demo.add("01:29 PM - 01:31 PM");
            demo.add("01:31 PM - 01:33 PM");
            demo.add("01:33 PM - 01:35 PM");
            demo.add("01:35 PM - 01:37 PM");
            demo.add("01:37 PM - 01:39 PM");
            demo.add("01:39 PM - 01:41 PM");
            demo.add("01:41 PM - 01:43 PM");
            demo.add("01:43 PM - 01:45 PM");
            demo.add("01:45 PM - 01:47 PM");
            demo.add("01:47 PM - 01:49 PM");
            demo.add("01:49 PM - 01:51 PM");
            demo.add("01:51 PM - 01:53 PM");
            demo.add("01:53 PM - 01:55 PM");


            List<String> nextlist = new ArrayList<String>();
            nextlist.add("08:30 AM - 09:00 AM");
            nextlist.add("09:00 AM - 09:45 AM");
            nextlist.add("09:45 AM - 10:30 AM");
            nextlist.add("10:30 AM - 10:45 AM");
            nextlist.add("10:45 AM - 12:00 PM");
            nextlist.add("10:45 AM - 12:00 PM");
            nextlist.add("10:45 AM - 12:00 PM");
            nextlist.add("10:45 AM - 12:00 PM");
            nextlist.add("12:00 PM - 01:15 PM");
            nextlist.add("12:00 PM - 01:15 PM");
            nextlist.add("12:00 PM - 01:15 PM");
            nextlist.add("12:00 PM - 01:15 PM");
            nextlist.add("01:15 PM - 02:00 PM");
            nextlist.add("02:00 PM - 05:00 PM");
            nextlist.add("02:00 PM - 03:30 PM");
            nextlist.add("03:30 PM - 04:15 PM");
            nextlist.add("04:15 PM - 04:30 PM");
            nextlist.add("04:30 PM - 05:15 PM");
            nextlist.add("05:15 PM - 06:30 PM");
            nextlist.add("06:30 PM - 07:30 PM");

            List<String> linklist = new ArrayList<String>();

            linklist.add("No link");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("No link");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("https://bdren.zoom.us/j/65935378694");
            linklist.add("https://bdren.zoom.us/j/62801855917");
            linklist.add("https://bdren.zoom.us/j/67158201124");
            linklist.add("No link");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("https://bdren.zoom.us/j/61614171981");
            linklist.add("https://bdren.zoom.us/j/67666027328");
            linklist.add("https://bdren.zoom.us/j/67749203976");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("No link");
            linklist.add("https://zoom.us/j/6511121930");
            linklist.add("No link");
            linklist.add("No link");

            List<String> nlinklist = new ArrayList<String>();
            nlinklist.add("No link");
            nlinklist.add("https://zoom.us/j/6511121930");
            nlinklist.add("https://zoom.us/j/6511121930");
            nlinklist.add("No link");
            nlinklist.add("https://bdren.zoom.us/j/61734889690");
            nlinklist.add("https://bdren.zoom.us/j/67313954161");
            nlinklist.add("https://bdren.zoom.us/j/67370813880");
            nlinklist.add("https://bdren.zoom.us/j/68818793374");

            nlinklist.add("https://bdren.zoom.us/j/62277318121");
            nlinklist.add("https://bdren.zoom.us/j/65634636348");
            nlinklist.add("https://bdren.zoom.us/j/62501062127");
            nlinklist.add("https://bdren.zoom.us/j/65509603175");
            nlinklist.add("No link");
            nlinklist.add("https://bdren.zoom.us/j/64246365526");
            nlinklist.add("https://bdren.zoom.us/j/68184109978");
            nlinklist.add("https://zoom.us/j/6511121930");
            nlinklist.add("No link");
            nlinklist.add("https://zoom.us/j/6511121930");
            nlinklist.add("No link");
            nlinklist.add("https://zoom.us/j/6511121930");
            nlinklist.add("No link");

            List<String> namelist = new ArrayList<String>();
            namelist.add("Conference Highlights and Greeting Exchanges");
            namelist.add("Inaugural Session");
            namelist.add("Keynote 01:Securing Cyber-Physical and IoT Systems in Smart Living Environments");
            namelist.add("Health Break");
            namelist.add("Keynote 02:Clone detection and Benchmarking in Big Code");
            namelist.add("Parallel Session 1: Computer Vision and Pattern Recognition");
            namelist.add("Parallel Session 2: Computational Linguistic and Natural Language ");
            namelist.add("Parallel Session 3: Advances in device and sensor technology");
            namelist.add("Prayer and Lunch Break");
            namelist.add("Keynote 03: Electrification in the Aerospace Industry");
            namelist.add("Keynote 04: Challenges and opportunities of Solar PV integrations to national grid");
            namelist.add("STI EXPO 2021: Required Technological Transition to Achieve Sustainable Development for Emerging Economy");
            namelist.add("Parallel Session 1: Artificial Intelligence and Machine Learning  ");
            namelist.add("Parallel Session 2: Deep Learning, Image Processing, Medical Imaging");
            namelist.add("Parallel Session 3: Systems & Security");
            namelist.add("Keynote 05: Silica composite microcapsules for functional finishing of textiles: encapsulation and release properties");
            namelist.add("Prayer and Health Break");
            namelist.add("Invited Talk 01: Functionalisation of fibre-reinforced plastic composites.");
            namelist.add("Advisory and Organizing");
            namelist.add("End of the day");

            List<String> n_namelist = new ArrayList<String>();

            n_namelist.add("Conference Highlights and Greeting Exchanges");
            n_namelist.add("Keynote 06:Challenges in Real-time Edge AI");
            n_namelist.add("Keynote 07:Reliable Sensing with Unreliable Sensors: Reimaging the Possibilities and Redefining the Limits");
            n_namelist.add("Health Break");
            n_namelist.add("Parallel Session 1: Wireless and Mobile Networking  ");
            n_namelist.add("Parallel Session 2: Signal processing applications for Industry 4.0");
            n_namelist.add("Parallel Session 3: Efficient design in Control and Power Systems ");
            n_namelist.add("Parallel Session 4: Power Electronics for smart applications");
            n_namelist.add("Parallel Session 1: HCI, Algorithms, and Blockchain");
            n_namelist.add("Parallel Session 2: IoT and Cloud Computing:   ");
            n_namelist.add("Parallel Session 3: Renewable Energy & Sustainability ");
            n_namelist.add("Parallel Session 4: Textile Engineering Applications");
            n_namelist.add("Prayer and Health Break");
            n_namelist.add("Workshop on Healthcare Challenges based IoT Sensors & Video");
            n_namelist.add("Interactive Poster Session");
            n_namelist.add("Keynote 08:Pushing Intelligence to the Edge of Internet of Things: A new Paradigm enabling Next-Generation Smart Systems of Systems");
            n_namelist.add("Health Break");
            n_namelist.add("Keynote 09: Edge Intelligence for B5G/6G and IoT");
            n_namelist.add("Prayer Break and Socialization");
            n_namelist.add("Award Giving Ceremony ");
            n_namelist.add("STI 2021 ended!!! No upcoming event");


            Boolean nextday = false;
            SimpleDateFormat sdfd = new SimpleDateFormat("d");
            String date = sdfd.format(new Date());
            int match_time;
            int match_time_next;


            if (date.contains("18")) {
                //System.out.println("hell yeah i did it");
                System.out.println(list.get(5));

                int count = 0;
                Boolean parallel = false;
                for (String i : list) {
                    String start = i.substring(0, 8);
                    String end = i.substring(11, 19);

                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                    String currentDateandTime = sdf.format(new Date());


                    try {
                        //
                        String string1 = start;
                        Date time1 = new SimpleDateFormat("hh:mm a").parse(string1);
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.setTime(time1);
                        calendar1.add(Calendar.DATE, 1);


                        String string2 = end;
                        Date time2 = new SimpleDateFormat("hh:mm a").parse(string2);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time2);
                        calendar2.add(Calendar.DATE, 1);

                        String someRandomTime = currentDateandTime;
                        //String someRandomTime = "06:16 PM";
                        Date d = new SimpleDateFormat("hh:mm a").parse(someRandomTime);
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.setTime(d);
                        calendar3.add(Calendar.DATE, 1);

                        Date x = calendar3.getTime();
                        if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                            //checkes whether the current time is between
                            match_time = list.indexOf(i);
                            // match_time+=1;
                            System.out.println("This is in time" + match_time);
                            System.out.println(linklist.get(match_time));
                            System.out.println(namelist.get(match_time));
                            System.out.println(namelist.get(6));
                            System.out.println(namelist.get(6));

                            System.out.println(namelist.get(7));
                            System.out.println(namelist.get(8));
                            System.out.println(namelist.get(9));
                            System.out.println(namelist.get(10));
                            System.out.println(namelist.get(11));
                            System.out.println(namelist.get(12));


                            if (match_time >= 0 && match_time < 4) {
                                //current
                                name_view_pass1 = namelist.get(match_time);
                                //next session
                                text_view_pass1 = namelist.get(match_time + 1);
                                //zoom links pass
                                zoom_link_pass = linklist.get(match_time);
                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);
                            } else if (match_time == 4) {
                                name_view_pass1 = namelist.get(match_time);
                                zoom_link_pass = linklist.get(match_time);

                                cardview11.setVisibility(View.VISIBLE);
                                cardview12.setVisibility(View.VISIBLE);

                                text_view_pass1 = namelist.get(match_time + 1);
                                text_view_pass2 = namelist.get(match_time + 2);
                                text_view_pass3 = namelist.get(match_time + 3);

                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);
                            } else if (match_time == 5) {

                                cardview7.setVisibility(View.VISIBLE);
                                cardview8.setVisibility(View.VISIBLE);

                                cardview11.setVisibility(View.INVISIBLE);
                                cardview12.setVisibility(View.INVISIBLE);
                                cardview13.setVisibility(View.INVISIBLE);

                                name_view_pass1 = namelist.get(match_time);
                                name_view_pass2 = namelist.get(match_time + 1);
                                name_view_pass3 = namelist.get(match_time + 2);

                                zoom_link_pass = linklist.get(match_time);
                                zoom_link_pass2 = linklist.get(match_time + 1);
                                zoom_link_pass3 = linklist.get(match_time + 2);

                                text_view_pass1 = namelist.get(match_time + 3);

                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);

                            } else if (match_time >= 8 && match_time < 10) {
                                //current
                                name_view_pass1 = namelist.get(match_time);
                                //next session
                                text_view_pass1 = namelist.get(match_time + 1);
                                //zoom links pass
                                zoom_link_pass = linklist.get(match_time);

                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);

                                cardview7.setVisibility(View.INVISIBLE);
                                cardview8.setVisibility(View.INVISIBLE);
                                cardview9.setVisibility(View.INVISIBLE);
                            } else if (match_time == 10) {
                                name_view_pass1 = namelist.get(match_time);
                                zoom_link_pass = linklist.get(match_time);

                                cardview11.setVisibility(View.VISIBLE);
                                cardview12.setVisibility(View.VISIBLE);
                                cardview13.setVisibility(View.VISIBLE);

                                text_view_pass1 = namelist.get(match_time + 1);
                                text_view_pass2 = namelist.get(match_time + 2);
                                text_view_pass3 = namelist.get(match_time + 3);
                                text_view_pass4 = namelist.get(match_time + 4);

                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);
                            } else if (match_time == 11) {

                                cardview7.setVisibility(View.VISIBLE);
                                cardview9.setVisibility(View.VISIBLE);
                                cardview8.setVisibility(View.VISIBLE);

                                cardview11.setVisibility(View.INVISIBLE);
                                cardview12.setVisibility(View.INVISIBLE);
                                cardview13.setVisibility(View.INVISIBLE);

                                name_view_pass1 = namelist.get(match_time);
                                name_view_pass2 = namelist.get(match_time + 1);
                                name_view_pass3 = namelist.get(match_time + 2);
                                name_view_pass4 = namelist.get(match_time + 3);

                                zoom_link_pass = linklist.get(match_time);
                                zoom_link_pass2 = linklist.get(match_time + 1);
                                zoom_link_pass3 = linklist.get(match_time + 2);
                                zoom_link_pass4 = linklist.get(match_time + 3);

                                text_view_pass1 = namelist.get(match_time + 4);

                                time_pass1 = list.get(match_time);
                                time_pass2 = list.get(match_time + 1);
                                time_pass3 = list.get(match_time + 2);
                                time_pass4 = list.get(match_time + 3);
                            } else if (match_time >= 14 && match_time < 19) {

                                //current
                                name_view_pass1 = namelist.get(match_time);
                                //next session
                                text_view_pass1 = namelist.get(match_time + 1);
                                //zoom links pass
                                zoom_link_pass = linklist.get(match_time);

                                cardview7.setVisibility(View.INVISIBLE);
                                cardview8.setVisibility(View.INVISIBLE);
                                cardview9.setVisibility(View.INVISIBLE);

                                time_pass1 = list.get(match_time);

                            }
                            break;
                        }


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }


            } else if (date.contains("9")) {
                for (String i : nextlist) {
                    String start = i.substring(0, 8);
                    String end = i.substring(11, 19);

                    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm a");
                    String currentDateandTime = sdf.format(new Date());


                    try {
                        //
                        String string1 = start;
                        Date time1 = new SimpleDateFormat("hh:mm a").parse(string1);
                        Calendar calendar1 = Calendar.getInstance();
                        calendar1.setTime(time1);
                        calendar1.add(Calendar.DATE, 1);


                        String string2 = end;
                        Date time2 = new SimpleDateFormat("hh:mm a").parse(string2);
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTime(time2);
                        calendar2.add(Calendar.DATE, 1);

                       // String someRandomTime = currentDateandTime;
                        String someRandomTime = "10:47 AM";
                        Date d = new SimpleDateFormat("hh:mm a").parse(someRandomTime);
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.setTime(d);
                        calendar3.add(Calendar.DATE, 1);

                        Date x = calendar3.getTime();
                        if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) {
                            //checkes whether the current time is between
                            match_time = nextlist.indexOf(i);
                            // match_time+=1;
                            System.out.println("This is in time" + match_time);
                            System.out.println(n_namelist.get(match_time));
                            System.out.println(namelist.get(match_time));
                            System.out.println(namelist.get(6));
                            System.out.println(namelist.get(6));

                            System.out.println(namelist.get(7));
                            System.out.println(namelist.get(8));
                            System.out.println(namelist.get(9));
                            System.out.println(namelist.get(10));
                            System.out.println(namelist.get(11));
                            System.out.println(namelist.get(12));


                            if (match_time >= 0 && match_time < 3) {
                                //current
                                name_view_pass1 = n_namelist.get(match_time);
                                //next session
                                text_view_pass1 = n_namelist.get(match_time + 1);
                                //zoom links pass
                                zoom_link_pass = nlinklist.get(match_time);
                                time_pass1 = nextlist.get(match_time);
                                time_pass2 = nextlist.get(match_time + 1);
                                time_pass3 = nextlist.get(match_time + 2);
                                time_pass4 = nextlist.get(match_time + 3);
                            } else if (match_time == 3) {
                                name_view_pass1 = n_namelist.get(match_time);
                                zoom_link_pass = nlinklist.get(match_time);

                                cardview11.setVisibility(View.VISIBLE);
                                cardview12.setVisibility(View.VISIBLE);
                                cardview13.setVisibility(View.VISIBLE);


                                text_view_pass1 = n_namelist.get(match_time + 1);
                                text_view_pass2 = n_namelist.get(match_time + 2);
                                text_view_pass3 = n_namelist.get(match_time + 3);
                                text_view_pass4 = n_namelist.get(match_time + 4);

                                time_pass1 = nextlist.get(match_time);
                                time_pass2 = nextlist.get(match_time + 1);
                                time_pass3 = nextlist.get(match_time + 2);
                                time_pass4 = nextlist.get(match_time + 3);
                            } else if (match_time == 4) {

                                cardview7.setVisibility(View.VISIBLE);
                                cardview9.setVisibility(View.VISIBLE);
                                cardview8.setVisibility(View.VISIBLE);

                                cardview11.setVisibility(View.VISIBLE);
                                cardview12.setVisibility(View.VISIBLE);
                                cardview13.setVisibility(View.VISIBLE);

                                name_view_pass1 = n_namelist.get(match_time);
                                name_view_pass2 = n_namelist.get(match_time + 1);
                                name_view_pass3 = n_namelist.get(match_time + 2);
                                name_view_pass4 = n_namelist.get(match_time + 3);

                                text_view_pass1 = n_namelist.get(match_time + 4);
                                text_view_pass2 = n_namelist.get(match_time + 5);
                                text_view_pass3 = n_namelist.get(match_time + 6);
                                text_view_pass4 = n_namelist.get(match_time + 7);

                                zoom_link_pass = nlinklist.get(match_time);
                                zoom_link_pass2 = nlinklist.get(match_time + 1);
                                zoom_link_pass3 = nlinklist.get(match_time + 2);
                                zoom_link_pass4 = nlinklist.get(match_time + 3);

                                time_pass1 = nextlist.get(match_time);
                                time_pass2 = nextlist.get(match_time + 1);
                                time_pass3 = nextlist.get(match_time + 2);
                                time_pass4 = nextlist.get(match_time + 3);

                            } else if (match_time == 8) {

                                cardview11.setVisibility(View.INVISIBLE);
                                cardview12.setVisibility(View.INVISIBLE);
                                cardview13.setVisibility(View.INVISIBLE);
                                //current session

                                name_view_pass1 = n_namelist.get(match_time);
                                name_view_pass2 = n_namelist.get(match_time + 1);
                                name_view_pass3 = n_namelist.get(match_time + 2);
                                name_view_pass4 = n_namelist.get(match_time + 3);
                                //next session
                                text_view_pass1 = n_namelist.get(match_time + 4);

                                zoom_link_pass = nlinklist.get(match_time);
                                zoom_link_pass2 = nlinklist.get(match_time + 1);
                                zoom_link_pass3 = nlinklist.get(match_time + 2);
                                zoom_link_pass4 = nlinklist.get(match_time + 3);

                                time_pass1 = nextlist.get(match_time);
                                time_pass2 = nextlist.get(match_time + 1);
                                time_pass3 = nextlist.get(match_time + 2);
                                time_pass4 = nextlist.get(match_time + 3);
                            } else if (match_time >= 12 && match_time <= 20) {
                                //current
                                name_view_pass1 = n_namelist.get(match_time);
                                //next session
                                text_view_pass1 = n_namelist.get(match_time + 1);
                                //zoom links pass
                                zoom_link_pass = nlinklist.get(match_time);

                                time_pass1 = nextlist.get(match_time);


                                cardview7.setVisibility(View.INVISIBLE);
                                cardview9.setVisibility(View.INVISIBLE);
                                cardview8.setVisibility(View.INVISIBLE);

                                cardview11.setVisibility(View.INVISIBLE);
                                cardview12.setVisibility(View.INVISIBLE);
                                cardview13.setVisibility(View.INVISIBLE);
                            }

                            break;
                        }


                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                }
            }

            current1.setText(name_view_pass1);
            current2.setText(name_view_pass2);
            current3.setText(name_view_pass3);
            current4.setText(name_view_pass4);

            next1.setText(text_view_pass1);
            next2.setText(text_view_pass2);
            next3.setText(text_view_pass3);
            next4.setText(text_view_pass4);

            time1.setText(time_pass1);
            time2.setText(time_pass2);
            time3.setText(time_pass3);
            time4.setText(time_pass4);


            //time1.setText();
            mHandler.postDelayed(this, 100000);
        }
    };
}


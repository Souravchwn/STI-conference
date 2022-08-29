package com.example.sti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

import com.example.sti.login_registration.SignInActivity;
import com.example.sti.ui.about.about_sti;
import com.example.sti.ui.committee.committee;
import com.example.sti.ui.gallery.GalleryFragment;
import com.example.sti.ui.slideshow.SlideshowFragment;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class paid_notice_board extends AppCompatActivity {
    private WebView webView;
    private CardView cardview1,cardview2,cardview3,cardview4,cardview5,cardview6;
    TextView textView1,textView2,textView3,textView4;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    public String note1,note2,note3,note4;
    public int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paid_notice_board);
        cardview1=findViewById(R.id.firstcard);
        cardview2=findViewById(R.id.card2);
        cardview3=findViewById(R.id.card3);
        cardview4=findViewById(R.id.card4);



        textView1=findViewById(R.id.textView1);
        textView2=findViewById(R.id.textView2);
        textView3=findViewById(R.id.textView3);
        textView4=findViewById(R.id.textView4);


        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.primaryDark));
        }
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Notice");
        databaseReference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    // Retrieving Data from firebase

                    String notice1 = "" + dataSnapshot1.child("Notice1").getValue();
                    System.out.println("Sourav"+notice1);
                    String notice2 = "" + dataSnapshot1.child("Notice2").getValue();
                    System.out.println("Sourav-2"+notice2);
                    String notice3 = "" + dataSnapshot1.child("Notice3").getValue();
                    System.out.println("Sourav-3"+notice3);
                    String notice4 = "" + dataSnapshot1.child("Notice4").getValue();
                    System.out.println("Sourav-4"+notice4);
                    String name1= "" + dataSnapshot1.child("Name1").getValue();
                    String name2= "" + dataSnapshot1.child("Name2").getValue();
                    String name3= "" + dataSnapshot1.child("Name3").getValue();
                    String name4= "" + dataSnapshot1.child("Name4").getValue();
                    // setting data to our text view

                    textView1.setText(name1);
                    textView2.setText(name2);
                    textView3.setText(name3);
                    textView4.setText(name4);

                    if(i==0)
                    {
                        note1=notice1;
                        note2=notice2;
                        note3=notice3;
                        note4=notice4;

                        System.out.println("Sourav inside int"+note1);
                        System.out.println("Sourav inside int-2"+note2);
                        System.out.println("Sourav inside int-3"+note3);
                        System.out.println("Sourav inside int-4"+note4);
                    }
                    i=1;
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        cardview1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(paid_notice_board.this, view_pdf.class);
                intent.putExtra("url", note1);
                System.out.println("Sourav-InsideIntent"+note1);
                startActivity(intent);
            }
        });
        cardview2.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent = new Intent(paid_notice_board.this, view_pdf.class);
                    intent.putExtra("url", note2);
                    startActivity(intent);
                }
        });

        cardview3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(paid_notice_board.this, view_pdf.class);
                intent.putExtra("url", note3);
                startActivity(intent);
            }
        });
        cardview4.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                    Intent intent = new Intent(paid_notice_board.this, view_pdf.class);
                    intent.putExtra("url", note4);
                    startActivity(intent);
                }
        });
    }

}

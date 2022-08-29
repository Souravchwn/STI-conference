package com.example.sti;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class user_profile extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    FirebaseUser firebaseUser;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    TextView name,address,phone,email,add;

    public String mail,uid_no;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        uid_no = FirebaseAuth.getInstance().getCurrentUser().getUid();

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("User").child(uid_no);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.primaryDark));
        }
        name = findViewById(R.id.tv_name);
        address = findViewById(R.id.tv_address);
        phone = findViewById(R.id.pphone);
        email = findViewById(R.id.pmail);
        add = findViewById(R.id.paddress);


        databaseReference.addValueEventListener(new ValueEventListener() {
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    // Retrieving Data from firebase
                    String names = "" + dataSnapshot.child("firstName").getValue();
                    String number = "" + dataSnapshot.child("lastName").getValue();
                    String adds = "" + dataSnapshot.child("address").getValue();
                    // setting data to our text view
                    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                    if (user != null) {
                        String userEmail = user.getEmail();
                        mail=userEmail;
                        uid_no=user.getUid();;
                    }
                     else {
                        // No user is signed in
                    }
                    email.setText(mail);
                    name.setText(names);
                    address.setText(adds);
                    add.setText(adds);
                    phone.setText(number);
                    }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}

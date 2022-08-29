package com.example.sti.login_registration;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.sti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class registration_sti extends AppCompatActivity {

    EditText emailId, firstName, phone, address, password;
    Button btnSignUp;
    Button tvSignIn;

    FirebaseAuth mFirebaseAuth;
    FirebaseDatabase firebaseDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_sti);

    /*    emailId = findViewById(R.id.etRegGmail);
        firstName = findViewById(R.id.etRegName);
        phone = findViewById(R.id.etRegPhone);
        address = findViewById(R.id.address);
        password = findViewById(R.id.etRegPassword);
        btnSignUp = findViewById(R.id.btnRegLogin);
        tvSignIn = findViewById(R.id.btnGotoLogin);

        mFirebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.primaryDark));
        }

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = emailId.getText().toString();
                final String fName = firstName.getText().toString();
                final String lName = phone.getText().toString();
                final String add = address.getText().toString();
                final String pwd = password.getText().toString();

                if (email.isEmpty()) {
                    emailId.setError("Please provide email id");
                    emailId.requestFocus();
                } else if (fName.isEmpty()) {
                    firstName.setError("Please provide your full name");
                    firstName.requestFocus();
                } else if (lName.isEmpty()) {
                    phone.setError("Please provide your Phone number");
                    phone.requestFocus();
                } else if (add.isEmpty()) {
                    address.setError("Please provide your address");
                    address.requestFocus();
                } else if (pwd.isEmpty()) {
                    password.setError("Please provide password");
                    password.requestFocus();
                } else if (!(email.isEmpty() && pwd.isEmpty())) {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, pwd).addOnCompleteListener(registration_sti.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if (!task.isSuccessful()) {
                                        CustomToast.createToast(registration_sti.this, "SignUp Unsuccessful, Plaese Try Again!"
                                                + task.getException().getMessage(), true);
                                    } else {
                                        UserDetail userDetail = new UserDetail(fName, lName, add);
                                        String uid = task.getResult().getUser().getUid();
                                        firebaseDatabase.getReference(uid).setValue(userDetail)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void aVoid) {
                                                        Intent intent = new Intent(registration_sti.this,
                                                                HomeActivity.class);
                                                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                                                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                                        intent.putExtra("name", fName + " " + lName);
                                                        startActivity(intent);
                                                    }
                                                });
                                    }

                                }
                            });
                } else {
                    CustomToast.createToast(registration_sti.this, "Error Occurred !", true);
                }
            }
        });
        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(registration_sti.this, login.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });
    }
}*/
    }}
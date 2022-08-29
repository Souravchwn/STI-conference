package com.example.sti.login_registration;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.sti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class SignUpActivity extends AppCompatActivity {


    private static final String TAG = "SignUpActivity";
    public FirebaseAuth mAuth;
    Button signUpButton;
    EditText signUpEmailTextInput;
    EditText signUpPasswordTextInput;
    CheckBox agreementCheckBox;
    TextView errorView;
    EditText emailId, firstName, phone, address, password;
    private DatabaseReference databaseReference,uidnodatabase;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_sti);

        firstName = findViewById(R.id.etRegName);
        phone = findViewById(R.id.etRegPhone);
        address = findViewById(R.id.address);

        mAuth = FirebaseAuth.getInstance();

        signUpEmailTextInput = findViewById(R.id.signUpEmailTextInput);
        signUpPasswordTextInput = findViewById(R.id.signUpPasswordTextInput);
        signUpButton = findViewById(R.id.signUpButton);
        agreementCheckBox = findViewById(R.id.agreementCheckbox);
        errorView = findViewById(R.id.signUpErrorView);
        errorView.setVisibility(View.INVISIBLE);

        List<String> mail_list = new ArrayList<>();
        mail_list.add("souravchowhan31@gmail.com");
        mail_list.add("wahidfarjana0@gmail.com");
        mail_list.add("jikrul@eee.green.edu.bd");
        mail_list.add("sumaiya@cse.green.edu.bd");
        mail_list.add("shakhawat.co@green.edu.bd");
        mail_list.add("asiful@eee.green.edu.bd");
        mail_list.add("mizanur@eee.green.edu.bd");
        mail_list.add("naznin@eee.green.edu.bd");
        mail_list.add("shemul@eee.green.edu.bd");
        mail_list.add("atik@cse.green.edu.bd");
        mail_list.add("barua@eee.green.edu.bd");
        mail_list.add("imamul@eee.green.edu.bd");
        mail_list.add("habiba@cse.green.edu.bd");
        mail_list.add("monzur@eee.green.edu.bd");
        mail_list.add("humayun@cse.green.edu.bd");
        mail_list.add("tamim@cse.green.edu.bd");
        mail_list.add("ashiqur@eee.green.edu.bd");
        mail_list.add("kiran@eee.green.edu.bd");
        mail_list.add("shifatara@cse.green.edu.bd");
        mail_list.add("kiran@eee.green.edu.bd");
        mail_list.add("parvez.ar@green.edu.bd");
        mail_list.add("arif.sc@green.edu.bd");
        mail_list.add("suraiya.jo.cse@green.edu.bd");
        mail_list.add("sujaul.jo@green.edu.bd");
        mail_list.add("shahela@eee.green.edu.bd");
        mail_list.add("syda@eee.green.edu.bd");
        mail_list.add("subrata@tex.green.edu.bd");
        mail_list.add("faisal@cse.green.edu.bd");
        mail_list.add("tanveer@eee.green.edu.bd");
        mail_list.add("iqbal@cse.green.edu.bd");
        mail_list.add("farzana@eee.green.edu.bd");
        mail_list.add("aminur@cse.green.edu.bd");
        mail_list.add("shabbir@cse.green.edu.bd");
        mail_list.add("ehsan@cse.green.edu.bd");
        mail_list.add("parvez@cse.green.edu.bd");
        mail_list.add("habib@cse.green.edu.bd");
        mail_list.add("parvin.do.cse@green.edu.bd");
        mail_list.add("jikrul@eee.green.edu.bd");
        mail_list.add("rajibul@cse.green.edu.bd");
        mail_list.add("afsana@eee.green.edu.bd");
        mail_list.add("meherun@eee.green.edu.bd");
        mail_list.add("gulzar@cse.green.edu.bd");
        mail_list.add("sultanul@cse.green.edu.bd");
        mail_list.add("maruf@eee.green.edu.bd");
        mail_list.add("saaduzzaman@eee.green.edu.bd");
        mail_list.add("ahad@eee.green.edu.bd");
        mail_list.add("khair@eee.green.edu.bd");
        mail_list.add("Naushad@eee.green.Eid.bd");
        mail_list.add("shahabuddin@eee.green.edu.bd");
        mail_list.add("nusratjahanece15@gmail.com");
        mail_list.add("ismail@tex.green.edu.bd");
        mail_list.add("abrar@eee.green.edu.bd");
        mail_list.add("rukhshana@eee.green.edu.bd");
        mail_list.add("shafia@eee.green.edu.bd");
        mail_list.add("ferdousy@eee.green.edu.bd");
        mail_list.add("nima@eee.green.edu.bd");
        mail_list.add("moshiur@cse.green.edu.bd");
        mail_list.add("amit@cse.green.edu.bd");
        mail_list.add("jbiswas@tex.green.edu.bd");
        mail_list.add("nahian@eee.green.edu.bd");
        mail_list.add("himon@eee.green.edu.bd");
        mail_list.add("monoshi@cse.green.edu.bd");
        mail_list.add("aurthi018@gmail.com");
        mail_list.add("tariqul@eee.green.edu.bd");
        mail_list.add("mutasim@tex.green.edu.bd");
        mail_list.add("tariqul@eee.green.edu.bd");
        mail_list.add("puja@eee.green.edu.bd");
        mail_list.add("rafe@tex.green.edu.bd");
        mail_list.add("kabir@eee.green.edu.bd");
        mail_list.add("mostafijur@cse.green.edu.bd");
        mail_list.add("eusha@cse.green.edu.bd");
        mail_list.add("sahashourav@gmail.com");
        mail_list.add("jahidul.jnucse@gmail.com");
        mail_list.add("prianka@eee.green.edu.bd");
        mail_list.add("shamima_akter@cse.green.edu.bd");
        mail_list.add("biswajit@eee.green.edu.bd");
        mail_list.add("tarafder@cse.green.edu.bd");
        mail_list.add("atikahamed@cse.green.edu.bd");
        mail_list.add("biplob.ccd@green.edu.bd");
        mail_list.add("khorshed.af@green.edu.bd");
        mail_list.add("motiur.pro@greeen.edu.bd");
        mail_list.add("shahin.ar@green.edu.bd");
        mail_list.add("mazhar@green.edu.bd");
        mail_list.add("shawon.it@green.edu.bd");
        mail_list.add("kabir@cse.green.edu.bd");
        mail_list.add("tarek.exams@green.edu.bd");
        mail_list.add("tanpia@cse.green.edu.bd");
        mail_list.add("mehrab@cse.green.edu.bd");
        mail_list.add("najmul@eee.green.edu.bd");
        mail_list.add("librarian@green.edu.bd");
        mail_list.add("mahmud.deputy@green.edu.bd");
        mail_list.add("humayan@cse.green.edu.bd");
        mail_list.add("tanoy@cse.green.edu.bd");
        mail_list.add("quader@cse.green.edu.bd");
        mail_list.add("montaser@cse.green.edu.bd");
        mail_list.add("rabu@eee.green.edu.bd");
        mail_list.add("hasibul@eee.green.edu.bd");
        mail_list.add("naiemur@eee.green.edu.bd");
        mail_list.add("shamima21akter11@gmail.com");
        mail_list.add("mdkk.1602@gmail.com");
        mail_list.add("ahmed@eee.green.edu.bd");
        mail_list.add("jahin@eee.green.edu.bd");
        mail_list.add("rokeya@cse.green.edu.bd");
        mail_list.add("nafiz@eee.green.edu.bd");
        mail_list.add("jakia@cse.green.edu.bd");
        mail_list.add("zahid@cse.green.edu.bd");
        mail_list.add("feroza@cse.green.edu.bd");
        mail_list.add("samiha@cse.green.edu.bd");
        mail_list.add("mansur@eee.green.edu.bd");
        mail_list.add("shamima@cse.green.edu.bd");
        mail_list.add("deputy.reg@green.edu.bd");
        mail_list.add("sharmin@cse.green.edu.bd");
        mail_list.add("shamsul@eee.green.edu.bd");
        mail_list.add("nazmus@eee.green.edu.bd");
        mail_list.add("babe@cse.green.edu.bd");
        mail_list.add("nafis@eee.green.edu.bd");
        mail_list.add("tanzila@cse.green.edu.bd");
        mail_list.add("shariful@tex.green.edu.bd");
        mail_list.add("jamil@cse.green.edu.bd");
        mail_list.add("robiul@cse.green.edu.bd");
        mail_list.add("farhana@cse.green.edu.bd");
        mail_list.add("mobin@eee.green.edu.bd");
        mail_list.add("monirul@cse.green.edu.bd");
        mail_list.add("abdullah@cse.green.edu.bd");
        mail_list.add("bibekananda@eee.green.edu.bd");
        mail_list.add("arpita@cse.green.edu");
        mail_list.add("jargis@cse.green.edu.bd");
        mail_list.add("ruman@cse.green.edu.bd");
        mail_list.add("Kaikobad@tex.green.edu.bd");
        mail_list.add("nusrat@tex.green.edu.bd");
        mail_list.add("mehnaz@tex.green.edu.bd");
        mail_list.add("mahbub@tex.green.edu.bd");
        mail_list.add("dishat@tex.green.edu.bd");
        mail_list.add("alamin@tex.green.edu.bd");
        mail_list.add("monirultalha@gmail.com");
        mail_list.add("faruque@tex.green.edu.bd");
        mail_list.add("shakil@tex.green.edu.bd");
        mail_list.add("director.af@green.edu.bd");
        mail_list.add("chairman@tex.green.edu.bd");
        mail_list.add("amena@cse.green.edu.bd");
        mail_list.add("shuvraprokash@gmail.com");
        mail_list.add("arifulislam.nahid.du@gmail.com");
        mail_list.add("sachins@nec.edu.np");
        mail_list.add("abir.bd@gmail.com");
        mail_list.add("eftekhar78@gmail.com");
        mail_list.add("fahim@cse.green.edu.bd");
        mail_list.add("ananya108543@gmail.com");
        mail_list.add("aurna31@gmail.com");
        mail_list.add("miti_ete_ruet@yahoo.com");
        mail_list.add("falam@pu.edu.bd");
        mail_list.add("solaiman@cse.green.edu.bd");
        mail_list.add("quanbh@vaa.edu.vn");
        mail_list.add("wasifarahman@iut-dhaka.edu");
        mail_list.add("anikarahman6623@gmail.com");
        mail_list.add("arifulislam.nahid.du@gmail.com");
        mail_list.add("cb008276@students.apiit.lk");
        mail_list.add("rizwan.hasan486@gmail.com");
        mail_list.add("mmokhles@gmail.com");
        mail_list.add("anwarul@cse.green.edu.bd");
        mail_list.add("hossain.jsr2016@gmail.com");
        mail_list.add("pollen.eee@gmail.com");
        mail_list.add("ahsanul@eee.green.edu.bd");
        mail_list.add("jahan@eee.green.edu.bd");
        mail_list.add("marouf.cse@duet.ac.bd");
        mail_list.add("nasir.hridoy44@gmail.com");
        mail_list.add("mostakim.mec.eee@gmail.com");
        mail_list.add("drfayzur@eee.green.edu.bd");
        mail_list.add("pushpa.ahmed21@gmail.com");
        mail_list.add("fatema@cse.green.edu.bd");
        mail_list.add("alnoman619@gmail.com");
        mail_list.add("nayeema2014@yahoo.com");
        mail_list.add("sumaya@duet.ac.bd");
        mail_list.add("mojammel.jisan@gmail.com");
        mail_list.add("mocarramhossain@gmail.com");
        mail_list.add("sanzanatabassum@iut-dhaka.edu");
        mail_list.add("mamun12368@gmail.com");
        mail_list.add("zeseya15@gmail.com");
        mail_list.add("ratualam14@cse.pstu.ac.bd");
        mail_list.add("mazharul@tex.green.edu.bd");
        mail_list.add("saiful@cse.green.edu.bd");
        mail_list.add("shihav@eee.green.edu.bd");
        mail_list.add("mhossain173066@bscse.uiu.ac.bd");
        mail_list.add("mahtabbonny@gmail.com");
        mail_list.add("sakibapon7@gmail.com");
        mail_list.add("akiduljoy@gmail.com");
        mail_list.add("habiba.cse1.bu@gmail.com");
        mail_list.add("kamrozzaman@eee.green.edu.bd");
        mail_list.add("messut.imamsharif@gmail.com");
        mail_list.add("hafija14@cse.pstu.ac.bd");
        mail_list.add("shahjalal.csegub@gmail.com");
        mail_list.add("razzaque@green.edu.bd");
        mail_list.add("razzaque@green.edu.bd");
        mail_list.add("palash@cse.green.edu.bd");
        mail_list.add("sabikunnahartanha6@gmail.com");
        mail_list.add("sowpnaakter67@gmail.com");
        mail_list.add("rusmitachaity171@gmail.com");
        mail_list.add("aryan1999@gmail.com");
        mail_list.add("aminur.wg@gmail.com");
        mail_list.add("mushficarueteee@gmail.com");
        mail_list.add("nabilamoumy@gmail.com");
        mail_list.add("aminur.wg@gmail.com");
        mail_list.add("tabassum.haque31@gmail.com");
        mail_list.add("Tarazul.gce@gmail.com");
        mail_list.add("aminur.wg@gmail.com");
        mail_list.add("tanvir.181002196@green.ac.bd");
        mail_list.add("afsana.sinthi@gmail.com");
        mail_list.add("ahsan.habib.tareq@gmail.com");
        mail_list.add("liza14@cse.pstu.ac.bd");
        mail_list.add("sajidahmed696@gmail.com");
        mail_list.add("rajankarmakersristy@gmail.com");
        mail_list.add("ratil.eee05@gmail.com");
        mail_list.add("monir@tex.green.edu.bd");
        mail_list.add("avijeet@tex.green.edu.bd");
        mail_list.add("jannat@tex.green.edu.bd");
        mail_list.add("ayesha@cse.green.edu.bd");
        mail_list.add("ismail@tex.green.edu.bd");



        View parentLayout = findViewById(android.R.id.content);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.primaryDark));
        }
        databaseReference = FirebaseDatabase.getInstance().getReference("User");

        uidnodatabase= FirebaseDatabase.getInstance().getReference("User ID (Registered users");


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (signUpEmailTextInput.getText().toString().contentEquals("")) {


                    errorView.setText("Email cannot be empty");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Email cannot be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    signUpEmailTextInput.setError("Email can't be empty");
                    signUpEmailTextInput.requestFocus();


                } else if (signUpPasswordTextInput.getText().toString().contentEquals("")) {


                    errorView.setText("Password cannot be empty");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Password cannot be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    signUpPasswordTextInput.setError("Password can't be empty");
                    signUpPasswordTextInput.requestFocus();




                }
                else if (firstName.getText().toString().contentEquals("")){
                    errorView.setText("Name cannot be empty");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Name cannot be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    firstName.setError("Must provide your full name");
                    firstName.requestFocus();
                } else if (phone.getText().toString().contentEquals("")){
                    errorView.setText("Phone number cannot be empty");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Phone number cannot be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    phone.setError("Please,give phone number");
                    phone.requestFocus();
                } else if (address.getText().toString().contentEquals("")) {
                    errorView.setText("Please provide your address");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Please provide your address", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    address.setError("Give your full address");
                    address.requestFocus();}

                    else if (!agreementCheckBox.isChecked()) {

                    errorView.setText("Please agree to terms and Condition");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Check the terms and condition", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    agreementCheckBox.setError("Please agree to terms and Condition");
                    agreementCheckBox.requestFocus();


                } else {

                        String  mailtext= signUpEmailTextInput.getText().toString();

                    if (mail_list.contains(mailtext))
                    {
                        ProgressDialog dialog=new ProgressDialog(SignUpActivity.this);
                        dialog.setMessage("Please Wait.....");
                        dialog.setCancelable(false);
                        dialog.setInverseBackgroundForced(false);
                        dialog.show();
                        mAuth.createUserWithEmailAndPassword(signUpEmailTextInput.getText().toString(), signUpPasswordTextInput.getText().toString()).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {

                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();

                                    String name = firstName.getText().toString();
                                    String phoneno = phone.getText().toString();
                                    String add = address.getText().toString();
                                    UserDetail userinfo = new UserDetail(name, phoneno, add);

                                    databaseReference.child(user.getUid()).setValue(userinfo);

                                    try {
                                        if (user != null)
                                            user.sendEmailVerification()
                                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if (task.isSuccessful()) {
                                                                Log.d(TAG, "Email sent.");
                                                                dialog.dismiss();

                                                                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                                                                        SignUpActivity.this);

                                                                // set title
                                                                alertDialogBuilder.setTitle("Please Verify Your EmailID");

                                                                // set dialog message
                                                                alertDialogBuilder
                                                                        .setMessage("A verification Email Is Sent To Your Registered EmailID, please click on the link and Sign in again!")
                                                                        .setCancelable(false)
                                                                        .setPositiveButton("Sign In", new DialogInterface.OnClickListener() {
                                                                            public void onClick(DialogInterface dialog, int id) {

                                                                                Intent signInIntent = new Intent(SignUpActivity.this, SignInActivity.class);
                                                                                startActivity(signInIntent);
                                                                                SignUpActivity.this.finish();
                                                                            }
                                                                        });

                                                                // create alert dialog
                                                                AlertDialog alertDialog = alertDialogBuilder.create();

                                                                // show it
                                                                alertDialog.show();


                                                            }
                                                        }
                                                    });

                                    } catch (Exception e) {
                                        errorView.setVisibility(View.VISIBLE);
                                        errorView.setText(e.getMessage());
                                    }
                                } else {
                                    dialog.dismiss();
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                    if (task.getException() != null) {
                                        dialog.dismiss();
                                        errorView.setVisibility(View.VISIBLE);
                                        errorView.setText(task.getException().getMessage());
                                    }

                                }
                                dialog.dismiss();
                            }
                        });
                    }
                        else
                        {
                            errorView.setText("Sorry you are not registered user");
                            Snackbar snackbar = Snackbar.make(parentLayout, "You're not registered user", Snackbar.LENGTH_LONG);
                            snackbar.show();
                            signUpEmailTextInput.setError("Sorry you are not registered user");
                            signUpEmailTextInput.requestFocus();
                    }
                }

            }
        });



    }

}

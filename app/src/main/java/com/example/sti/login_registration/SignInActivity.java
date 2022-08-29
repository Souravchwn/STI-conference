package com.example.sti.login_registration;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.snackbar.Snackbar;

import com.example.sti.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

public class SignInActivity extends AppCompatActivity {

    private static final String TAG = "SignInActivity";
    public FirebaseAuth mAuth;
    EditText emailTextInput;
    EditText passwordTextInput;
    Button signInButton;
    Button forgotPasswordButton;
    Button sendVerifyMailAgainButton;
    TextView errorView;

    public int check=0;

    private DatabaseReference data;

    CoordinatorLayout layout;


    TextView signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        data = FirebaseDatabase.getInstance().getReference("User ID (Registered users");

        emailTextInput = findViewById(R.id.signInEmailTextInput);
        passwordTextInput = findViewById(R.id.signInPasswordTextInput);
        signInButton = findViewById(R.id.signInButton);
        forgotPasswordButton = findViewById(R.id.forgotPasswordButton);
        sendVerifyMailAgainButton = findViewById(R.id.verifyEmailAgainButton);
        errorView = findViewById(R.id.signInErrorView);

        errorView.setVisibility(View.INVISIBLE);

        signup=findViewById(R.id.tvRegister);

        View parentLayout = findViewById(android.R.id.content);

        sendVerifyMailAgainButton.setVisibility(View.INVISIBLE);
        forgotPasswordButton.setVisibility(View.INVISIBLE);

        mAuth = FirebaseAuth.getInstance();
        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.primaryDark));
        }


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intSignUp = new Intent(SignInActivity.this, SignUpActivity.class);
                startActivity(intSignUp);

            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (emailTextInput.getText().toString().contentEquals("")) {
                    errorView.setVisibility(View.VISIBLE);
                    errorView.setText("Email cant be empty");

                    Snackbar snackbar= Snackbar.make(parentLayout, "Email cant be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    emailTextInput.setError("Please provide email id");
                    emailTextInput.requestFocus();


                } else if (passwordTextInput.getText().toString().contentEquals("")) {

                    errorView.setVisibility(View.VISIBLE);
                    errorView.setText("Password cant be empty");
                    Snackbar snackbar= Snackbar.make(parentLayout, "Password can't be empty", Snackbar.LENGTH_LONG);
                    snackbar.show();
                    passwordTextInput.setError("Password can not be empty");
                    passwordTextInput.requestFocus();

                } else {
                    ProgressDialog dialog=new ProgressDialog(SignInActivity.this);
                    dialog.setMessage("Please Wait.....");
                    dialog.setCancelable(false);
                    dialog.setInverseBackgroundForced(false);
                    dialog.show();


                    mAuth.signInWithEmailAndPassword(emailTextInput.getText().toString(), passwordTextInput.getText().toString())
                            .addOnCompleteListener(SignInActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "signInWithEmail:success");

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        if (user != null) {
                                            if (user.isEmailVerified()) {

                                                
                                                System.out.println("Email Verified : " + user.isEmailVerified());
                                                dialog.dismiss();
                                                Intent HomeActivity = new Intent(SignInActivity.this, paid_home.class);

                                                if(check!=1) {
                                                    String uidno = user.getUid();
                                                    data.child(user.getUid()).setValue(uidno);
                                                    check=1;
                                                }
                                                setResult(RESULT_OK, null);
                                                startActivity(HomeActivity);
                                                SignInActivity.this.finish();


                                            } else {
                                                dialog.dismiss();


                                                forgotPasswordButton.setVisibility(View.VISIBLE);
                                                sendVerifyMailAgainButton.setVisibility(View.VISIBLE);
                                                errorView.setVisibility(View.VISIBLE);
                                                errorView.setText("Please Verify your EmailID and SignIn");
                                                Snackbar snackbar= Snackbar.make(parentLayout, "Please Verify your EmailID and SignIn", Snackbar.LENGTH_LONG);
                                                snackbar.show();


                                            }
                                        }

                                    } else {
                                        // If sign in fails, display a message to the user.
                                        dialog.dismiss();
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(SignInActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        if (task.getException() != null) {
                                            dialog.dismiss();
                                            errorView.setVisibility(View.VISIBLE);
                                            errorView.setText(task.getException().getMessage());
                                        }

                                    }

                                }
                            });



                }


            }
        });


        forgotPasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent forgotPasswordActivity = new Intent(SignInActivity.this, ForgotPasswordActivity.class);
                startActivity(forgotPasswordActivity);
                SignInActivity.this.finish();

            }
        });


    }
    public void timer(int a)
    {

    }
}

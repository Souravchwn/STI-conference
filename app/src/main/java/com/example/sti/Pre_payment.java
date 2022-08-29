package com.example.sti;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Pre_payment extends AppCompatActivity {

    EditText name,adress,city,zip,country,number,mail;
    Button sslpay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_payment);

        final int amount=1000;
        name = findViewById(R.id.name);
        adress= findViewById(R.id.address);
        city= findViewById(R.id.city);
        zip = findViewById(R.id.zip);
        country= findViewById(R.id.country);
        number= findViewById(R.id.number);
        mail=findViewById(R.id.email);

        sslpay= findViewById(R.id.ssl);
        sslpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pay = new Intent(Pre_payment.this,MainActivity.class);
                pay.putExtra("Name", name.toString());
                pay.putExtra("mail", mail.toString());
                pay.putExtra("Adress", adress.toString());
                pay.putExtra("city", city.toString());
                pay.putExtra("zip", zip.toString());
                pay.putExtra("Country", country.toString());
                pay.putExtra("number", number.toString());
                pay.putExtra("amount",amount);
                startActivity(pay);
            }
        });

    }
}

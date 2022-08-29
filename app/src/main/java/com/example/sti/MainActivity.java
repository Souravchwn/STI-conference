package com.example.sti;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCCustomerInfoInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCProductInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCShipmentInfoInitializer;
import com.sslwireless.sslcommerzlibrary.model.initializer.SSLCommerzInitialization;
import com.sslwireless.sslcommerzlibrary.model.response.SSLCTransactionInfoModel;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCCurrencyType;
import com.sslwireless.sslcommerzlibrary.model.util.SSLCSdkType;
import com.sslwireless.sslcommerzlibrary.view.singleton.IntegrateSSLCommerz;
import com.sslwireless.sslcommerzlibrary.viewmodel.listener.SSLCTransactionResponseListener;


public class MainActivity extends AppCompatActivity implements SSLCTransactionResponseListener {

    TextView success,fail,cancel,paid_a;
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        success=  findViewById(R.id.success);
        fail= findViewById(R.id.fail);
        cancel= findViewById(R.id.cancel);
        paid_a = findViewById(R.id.paid_amount);

        Intent intent= getIntent();
        String Name  = intent.getStringExtra("Name");
        String Mail  = intent.getStringExtra("mail");
        String adress  = intent.getStringExtra("Adress");
        String city  = intent.getStringExtra("city");
        String zip  = intent.getStringExtra("zip");
        String country  = intent.getStringExtra("Country");
        String Number  = intent.getStringExtra("number");
        total =  intent.getIntExtra("amount",0);

        final SSLCommerzInitialization sslCommerzInitialization = new SSLCommerzInitialization ("payme60c39865bfc6e","payme60c39865bfc6e@ssl",
                total , SSLCCurrencyType.BDT,"123456789098765", "STI_payment", SSLCSdkType.TESTBOX);

        IntegrateSSLCommerz
                .getInstance(this)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .buildApiCall(MainActivity.this);

        final SSLCCustomerInfoInitializer customerInfoInitializer = new SSLCCustomerInfoInitializer(Name, Mail,adress,city,zip,country,Number);

        final SSLCProductInitializer productInitializer = new SSLCProductInitializer ("food", "food",
                new SSLCProductInitializer.ProductProfile.TravelVertical("Travel", "10",
                        "A", "12", "Dhk-Syl"));
        final SSLCShipmentInfoInitializer shipmentInfoInitializer = new SSLCShipmentInfoInitializer ("Courier",
                2, new SSLCShipmentInfoInitializer.ShipmentDetails("AA","Address 1",
                "Dhaka","1000","BD"));

        IntegrateSSLCommerz
                .getInstance(MainActivity.this)
                .addSSLCommerzInitialization(sslCommerzInitialization)
                .addCustomerInfoInitializer(customerInfoInitializer)
                .addProductInitializer(productInitializer)
                .buildApiCall(MainActivity.this);




    }

    @Override
    public void transactionSuccess(SSLCTransactionInfoModel sslcTransactionInfoModel) {
    success.setText(sslcTransactionInfoModel.getAPIConnect()+".........."+sslcTransactionInfoModel.getStatus());

    String paid = sslcTransactionInfoModel.getAmount();
     paid_a.setText("you paid "+ paid +"to STI conferneces! Thanks for being with us");
    }

    @Override
    public void transactionFail(String s) {
        fail.setText(s);
    }

    @Override
    public void merchantValidationError(String s) {
        cancel.setText(s);
    }
}

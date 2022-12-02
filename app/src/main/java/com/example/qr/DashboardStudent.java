package com.example.qr;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class DashboardStudent extends AppCompatActivity {


    CardView scanbtn;
    public static TextView scantext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_student);

        scantext = (TextView) findViewById(R.id.scantext);
        scanbtn = (CardView) findViewById(R.id.scanbtn);
    }


    public void onClick(View view) {
        startActivity(new Intent(this,scannerView.class));
    }

}


package com.example.qr;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DashboardTeacher extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_teacher);


    }


    public void onClick(View view) {
        startActivity(new Intent(this,QrGenerator.class));
    }
    public void onClick1(View view){
        startActivity(new Intent(this,Profil.class));
    }

    @Override
    public void onBackPressed() {
        Intent HomeIntent = new Intent(Intent.ACTION_MAIN);
        HomeIntent.addCategory(Intent.CATEGORY_HOME);
        HomeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(HomeIntent);
    }
}
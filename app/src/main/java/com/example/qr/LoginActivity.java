package com.example.qr;




import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class LoginActivity extends AppCompatActivity {

     Button btnLogin ;
     EditText password,email;
     FirebaseAuth mauth ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for changing status bar icon colors
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.cirLoginButton);
        password = (EditText) findViewById(R.id.Password);
        email = (EditText) findViewById(R.id.Email);
        mauth = FirebaseAuth.getInstance();




    }

    public void onLoginClick(View View) {
        startActivity(new Intent(this, RegisterActivity.class));
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void onClick(View view) {
      btnLogin.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              LoginUse();
          }

          private void LoginUse() {

              String Email = email.getText().toString().trim();
              String Password = password.getText().toString().trim();



              if(Email.isEmpty()){
                  email.setError("email is required");
                  email.requestFocus();
                  return;
              }
              if(Password.isEmpty()){
                  password.setError("Password is required");
                  password.requestFocus();
                  return;
              }
              mauth.signInWithEmailAndPassword(Email,Password)
                      .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                          @Override
                          public void onComplete(@NonNull Task<AuthResult> task) {
                              if(task.isSuccessful()){
                                  SendToDash();
                                  Toast.makeText(LoginActivity.this, "Welcome to our Application", Toast.LENGTH_LONG).show();
                              }
                              else {
                                  Toast.makeText(LoginActivity.this, "Email or Password incorrect", Toast.LENGTH_LONG).show();
                              }
                          }
                      });
          }
      });
    }

    private void SendToDash() {
        Intent intent = new Intent(LoginActivity.this,DashboardTeacher.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


}

package com.example.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
        private FirebaseAuth mAuth;
        private Button login;
        private EditText email , password;
        private TextView forgotpassword , signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        forgotpassword = findViewById(R.id.forgotpassword);
        signup = findViewById(R.id.signup);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String username = email.getText().toString();
            String Password = password.getText().toString();
            if (TextUtils.isEmpty(username)){
                email.setError("Field required");
            }
            if (TextUtils.isEmpty(Password)){
                email.setError("Field required");
            }
            else{
                signin(username,Password);
            }

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });

        forgotpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,forgotPassword.class));
            }
        });

    }


public void signin(String a , String b){
    mAuth = FirebaseAuth.getInstance();
mAuth.signInWithEmailAndPassword(a,b).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
    @Override
    public void onSuccess(AuthResult authResult) {
        Toast.makeText(MainActivity.this, "Hello And Welcome", Toast.LENGTH_LONG).show();
        startActivity(new Intent(MainActivity.this,MainActivity2.class));
    }
}).addOnFailureListener(new OnFailureListener() {
    @Override
    public void onFailure(@NonNull @org.jetbrains.annotations.NotNull Exception e) {
        Toast.makeText(MainActivity.this, "Invalid Username OR password", Toast.LENGTH_SHORT).show();
    }
});
}
}
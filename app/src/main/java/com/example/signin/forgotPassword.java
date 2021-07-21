package com.example.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class forgotPassword extends AppCompatActivity {
    private EditText resetmail;
    private Button sub;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

    resetmail = findViewById(R.id.resetmail);
    sub = findViewById(R.id.sub);

    sub.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String email = resetmail.getText().toString().trim();
            if (TextUtils.isEmpty(email)){
                resetmail.setError("Email required");
            }
            auth = FirebaseAuth.getInstance();
            auth.sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void unused) {
                    Toast.makeText(forgotPassword.this, "password link has been sent to your registered email", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull @NotNull Exception e) {
                    Toast.makeText(forgotPassword.this, "Something went wrong"+e, Toast.LENGTH_SHORT).show();
                }
            });

        }
    });
    }


}
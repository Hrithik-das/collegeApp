package com.example.signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {
    private EditText enteremail , enterpassword , enternumber , enteridnumber , entername;
    private Button register;
    private Spinner enterbranch;
    private FirebaseFirestore data;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        enteremail = findViewById(R.id.enteremail);
        enterpassword = findViewById(R.id.enterpassword);
        enternumber = findViewById(R.id.enternumber);
        enteridnumber = findViewById(R.id.enteridnumber);
        register = findViewById(R.id.register);
        enterbranch = findViewById(R.id.enterbranch);
        entername = findViewById(R.id.entername);




        String [] branch = new String[]{"Mechanical.engg" , "Elcetrical.engg" , "Bsc.IT" , "Bsc.cs" , "BMM", "BMS" ,"B.ARCH", "Bsc"};


        ArrayAdapter<String> bra = new ArrayAdapter<String>(signup.this, android.R.layout.simple_spinner_dropdown_item,branch);
        bra.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        enterbranch.setAdapter(bra);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mail = enteremail.getText().toString();
                String pass = enterpassword.getText().toString();
                String phoneNumber = enternumber.getText().toString();
                String idNumber = enteridnumber.getText().toString();
                String section = enterbranch.getSelectedItem().toString();
                String naam = entername.getText().toString();



                if (TextUtils.isEmpty(mail)){
                    enteremail.setError("Name required");
                }

                if (TextUtils.isEmpty(pass)){
                    enterpassword.setError("Set Password");
                }

                if (TextUtils.isEmpty(phoneNumber)){
                    enternumber.setError("Phone number cannot be empty");
                }

                if (TextUtils.isEmpty(idNumber)){
                    enteridnumber.setError("College ID required");
                }

                if (TextUtils.isEmpty(naam)){
                    entername.setError("Name required");
                }
                if(phoneNumber.length()!=10){
                    enternumber.setError("Enter a valid phone number");
                }

                else{
                    register(naam ,mail,pass,idNumber,phoneNumber,section);
                }



            }
        });
    }

    public void register(String name , String email , String password , String id , String number , String branch){
        mAuth = FirebaseAuth.getInstance();
        data = FirebaseFirestore.getInstance();
        mAuth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Map<String , Object> user = new HashMap<>();
                user.put("name", name);
                user.put("email" , email);
                user.put("password", password);
                user.put("id",id);
                user.put("number", number);
                user.put("branch", branch);
                data.collection("college datastore").document(id).set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(signup.this, "Signup Successfull", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(signup.this,MainActivity.class));
                    }
                });
                Toast.makeText(signup.this, "You have successfully registered", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull @NotNull Exception e) {
                Toast.makeText(signup.this, "Registration Failed Because user allready Exists", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
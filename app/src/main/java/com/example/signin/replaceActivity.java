package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class replaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_replace);
        Bundle bundle = getIntent().getExtras();
        int value = bundle.getInt("something");
        String value2 = bundle.getString("something");


        if (value == 1){
            replacefrag(new yourProfileFragment());

        }
        if (value == 2){
            replacefrag(new calanderFrag());
        }

        if(value == 3){
            replacefrag(new contactfrag());
        }
        if(value == 4){
            replacefrag(new contactfrag());
        }
        if(value == 5){
            replacefrag(new contactfrag());
        }
        if(value == 6){
            replacefrag(new contactfrag());
        }
        if(value == 7){
            replacefrag(new contactfrag());
        }
        if(value == 8){
            replacefrag(new contactfrag());
        }


    }

    private void replacefrag(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameid,fragment);
        fragmentTransaction.commit();
    }
}
package com.example.signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;

public class MainActivity2 extends AppCompatActivity {
    private CardView profile_card,calender_card,contact_card,help_card,setting_card,bug_card,logout_card,paper_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        profile_card = findViewById(R.id.profile_card);
        calender_card = findViewById(R.id.calender_card);
        contact_card = findViewById(R.id.contact_card);
        help_card = findViewById(R.id.help_card);
        setting_card = findViewById(R.id.setting_card);
        bug_card = findViewById(R.id.bug_card);
        logout_card = findViewById(R.id.logout_card);
        paper_card = findViewById(R.id.paper_card);


        profile_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
package com.carlisle.android.aca.qckweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{
    private FirebaseAuth mFirebaseAuth;

    TextView txtUserEmail;
    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // initializing firebase authentication object
        mFirebaseAuth = FirebaseAuth.getInstance();

        if (mFirebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, WelcomeActivity.class));
        }
        // getting current user
        FirebaseUser user = mFirebaseAuth.getCurrentUser();

        txtUserEmail = (TextView) findViewById(R.id.txtUserEmail);
        btnLogout = (Button) findViewById(R.id.btnLogout);

        txtUserEmail.setText("Welcome " + user.getEmail());

        btnLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // if Logout is pressed
        if (v == btnLogout){
            mFirebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, WelcomeActivity.class));
        }
    }
}

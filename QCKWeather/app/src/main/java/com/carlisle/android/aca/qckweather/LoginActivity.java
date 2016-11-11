package com.carlisle.android.aca.qckweather;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static com.carlisle.android.aca.qckweather.R.id.buttonSignin;
import static com.carlisle.android.aca.qckweather.R.id.txtEnterEmail;
import static com.carlisle.android.aca.qckweather.R.id.txtEnterPassword;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButtonSignin;
    private EditText mTxtEnterEmail;
    private EditText mTxtEnterPassword;
    private TextView mTextViewSignup;

    private FirebaseAuth mFirebaseAuth;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mFirebaseAuth = FirebaseAuth.getInstance();

        if (mFirebaseAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
        }
        mTxtEnterEmail = (EditText) findViewById(txtEnterEmail);
        mTxtEnterPassword = (EditText) findViewById(txtEnterPassword);
        mButtonSignin = (Button) findViewById(buttonSignin);
        mTextViewSignup = (TextView) findViewById(R.id.textViewSignUp);

        mProgressDialog = new ProgressDialog(this);

        mButtonSignin.setOnClickListener(this);
        mTextViewSignup.setOnClickListener(this);
    }
    private void userLogin(){
        String email = mTxtEnterEmail.getText().toString().trim();
        String password = mTxtEnterPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        mProgressDialog.setMessage("Registering. Please Wait..");
        mProgressDialog.show();

        mFirebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        mProgressDialog.dismiss();
                        if (task.isSuccessful()){
                            finish();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                    }
                });
    }

    @Override
    public void onClick(View v) {
        if (v == mButtonSignin){
            userLogin();
        }
        if (v == mTextViewSignup){
            finish();
            startActivity(new Intent(this, WelcomeActivity.class));
        }
    }
}

package com.example.chillpill;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.auth.User;


import java.util.Objects;

public class SignUp extends AppCompatActivity {
    Intent redirect, signIn;
    Button suButton;
    EditText suEmail;
    EditText suName;
    EditText suPassword1;
    EditText suPassword2;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        suName = findViewById(R.id.suName);
        suEmail = findViewById(R.id.suEmail);
        suPassword1 = findViewById(R.id.suPassword1);
        suPassword2 = findViewById(R.id.suPassword2);
        redirect = new Intent(getApplicationContext(), MainActivity.class);
        signIn = new Intent(getApplicationContext(), SignIn.class);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Sign Up");
        suButton = findViewById(R.id.suButton);
        suButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String suNameText = suName.getText().toString();
                String suEmailText = suEmail.getText().toString();
                String suPassword1Text = suPassword1.getText().toString();
                String suPassword2Text = suPassword2.getText().toString();
                if (suNameText.matches("") || suEmailText.matches("") || suPassword1Text.matches("") || suPassword2Text.matches("") ) {
                    Toast.makeText(getApplicationContext(), "Please enter all the details", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (suPassword1Text.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Password should be at least 6 characters", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!suPassword1Text.equals(suPassword2Text)) {
                    Toast.makeText(getApplicationContext(), "The passwords do not match", Toast.LENGTH_SHORT).show();
                    return;
                }
                Configs.getmAuth().createUserWithEmailAndPassword(suEmailText, suPassword1Text).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Sign Up successful", Toast.LENGTH_LONG).show();
                            startActivity(redirect);
                            finish();
                            return;
                        }
                        else {
                            if (task.getException().toString().matches(".*The email address is already in use by another account")) {
                                Toast.makeText(getApplicationContext(), "Sign Up failed! E-mail ID is already registered", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(getApplicationContext(), "Sign Up failed!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                });

            }
        });
    }
    public void siIntent(View view) {
        startActivity(this.signIn);
        finish();
    }
}
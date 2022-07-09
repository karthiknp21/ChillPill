package com.example.chillpill;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class Configs extends MainActivity {
    public static FirebaseUser fUser;
    public static FirebaseAuth mAuth;

    public static FirebaseAuth getmAuth() {
        mAuth = FirebaseAuth.getInstance();
        return mAuth;
    }

    public static FirebaseUser getUser() {
        fUser = FirebaseAuth.getInstance().getCurrentUser();
        return fUser;
    }

}
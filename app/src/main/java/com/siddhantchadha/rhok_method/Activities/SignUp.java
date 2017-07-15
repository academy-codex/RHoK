package com.siddhantchadha.rhok_method.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.siddhantchadha.rhok_method.R;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        if (getSupportActionBar()!=null)
            getSupportActionBar().hide();


    }
}

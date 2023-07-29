package com.example.adaptit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;

import android.os.Bundle;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private TextView email;
    private TextView password;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.emailtxt);
        password = findViewById(R.id.passwordtxt);



        // firebase login


    }
}
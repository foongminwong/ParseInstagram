package com.example.parseinstagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseUser;

import java.text.ParseException;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;
    Button btnRegister;

    private static final String TAG = "LoginActivity";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "onClick");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                login(username, password);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }




    private void login(String username, String password) {
       // navigate to new activity if the user has signed properly
        Log.i(TAG, "login method called");
        ParseUser.logInInBackground(username, password, new LogInCallback() {

            @Override
            public void done(ParseUser user, com.parse.ParseException e) {
                if (e != null) {
                    Log.d(TAG, "Issue with login");
                    e.printStackTrace();
                    return;
                }
                Log.i(TAG, "Going to main activity");
                goMainActivity();
            }
        });
    }

    private void goMainActivity() {
        Log.i(TAG, "Navigating to Main Activity");
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }

    private void register() {
        Log.d(TAG, "Navigating to Register Activity");
        Intent i = new Intent(this, RegisterActivity.class);
        startActivity(i);

    }
}

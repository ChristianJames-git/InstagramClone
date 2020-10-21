package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    public static final String TAG = "SignUpActivity";
    private EditText etUsername;
    private EditText etPassword;
    private EditText etEmail;
    private Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        etEmail = findViewById(R.id.etEmail);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().equals(""))
                    Toast.makeText(SignUpActivity.this, "Please Enter a Username", Toast.LENGTH_SHORT).show();
                else if (etPassword.getText().toString().equals(""))
                    Toast.makeText(SignUpActivity.this, "Please Enter a Password", Toast.LENGTH_SHORT).show();
                else
                    createUser(etUsername, etPassword, etEmail);
            }
        });
    }

    public void createUser(EditText username, EditText password, EditText email) {
        ParseUser user = new ParseUser();
        user.setUsername(username.getText().toString());
        user.setPassword(password.getText().toString());
        user.setEmail(email.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            public void done(ParseException e) {
                if (e == null) {
                    Toast.makeText(SignUpActivity.this, "Welcome to InstaClone!", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Log.i(TAG, "Error: " + e);
                    Toast.makeText(SignUpActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    etUsername.setText("");
                    etPassword.setText("");
                    etEmail.setText("");
                }
            }
        });
    }
}
package com.shnoble.android.autofill.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StandardSignInActivity extends AppCompatActivity {

    private static final String TAG = StandardSignInActivity.class.getSimpleName();

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mUsernameEditText = (EditText) findViewById(R.id.usernameField);
        mPasswordEditText = (EditText) findViewById(R.id.passwordField);
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        findViewById(R.id.clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetFields();
            }
        });
    }

    private void login() {
        String username = mUsernameEditText.getText().toString();
        String password = mPasswordEditText.getText().toString();

        Log.d(TAG, "User Name: " + username);
        Log.d(TAG, "Password: " + password);

        boolean valid = isValidCredentials(username, password);
        if (valid) {
            Toast.makeText(this, "WELCOME", Toast.LENGTH_SHORT).show();
            //finish();
        } else {
            Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidCredentials(String username, String password) {
        return username != null && password != null && !username.equals(password);
    }

    private void resetFields() {
        mUsernameEditText.setText("");
        mPasswordEditText.setText("");
    }
}

package com.mc.ca2.ryanshirley.college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mc.ca2.ryanshirley.college.model.Model;
import com.mc.ca2.ryanshirley.college.model.User;
import com.mc.ca2.ryanshirley.college.model.api.AbstractAPIListener;

/**
 * This class is the first activity that is launched in this application.
 * It is responsible for logging in a user
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText emailField = findViewById(R.id.emailText);
        final EditText passwordField = findViewById(R.id.passwordText);
        Button loginBtn = findViewById(R.id.loginBtn);

        // Create event listener for click on login button
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                final Model model = Model.getInstance(LoginActivity.this.getApplication());

                // Pass email and password values to the model to login the user and create
                // an instance of the AbstractAPIListener with onLogin method that is executed when login is successful.
                model.login(email, password, new AbstractAPIListener() {
                    @Override
                    public void onLogin(User user) {
                        model.setUser(user);
                        Intent intent = new Intent(LoginActivity.this, EnrolmentsActivity.class);
                        startActivity(intent); 
                    }
                });
            }
        });
    }
}

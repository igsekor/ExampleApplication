package com.example.igorkorovchenko.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private EditText loginField;
    private EditText passwordField;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        this.setupViews();
    }

    private void setupViews() {
        this.loginField = findViewById(R.id.main_login_edit_text);
        this.passwordField = findViewById(R.id.main_password_edit_text);
        this.resetLoginField();
        this.resetPasswordField();
        this.setupLoginButton();
    }

    private boolean checkLoginAndPassword(String login, String password) {
        // TODO: Checking login and password
        return false;
    }

    private void wrongLoginOrPassword() {
        AlertDialog.Builder builder;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            builder = new AlertDialog.Builder(this, android.R.style.Theme_Material_Dialog_Alert);
        } else {
            builder = new AlertDialog.Builder(this);
        }

        builder.setTitle(R.string.login_alert_dialog_title)
                .setMessage(R.string.login_alert_dialog_message)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO: actions for request new password
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        loginField.setTextColor(getResources().getColor(R.color.colorAccent));
                        passwordField.setTextColor(getResources().getColor(R.color.colorAccent));
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    private void setupLoginButton() {
        ((Button) findViewById(R.id.main_login_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = loginField.getText().toString();
                String password = passwordField.getText().toString();
                if (!checkLoginAndPassword(login, password)) {
                    wrongLoginOrPassword();
                } else {
                    // TODO: Next screen
                }
            }
        });
    }

    private void resetPasswordField() {
        passwordField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                passwordField.setText("");
                passwordField.setTextColor(R.color.default_text_color);
            }
        });
    }

    private void resetLoginField() {
        loginField.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                loginField.setTextColor(R.color.default_text_color);
            }
        });
    }
}
package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName;
    EditText password;
    //Regex used from https://stackoverflow.com/questions/8204680/java-regex-email
    public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    public LoginActivity(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        userName=(EditText)findViewById(R.id.edtUsername);
        password=(EditText)findViewById(R.id.edtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateUsername(userName.getText().toString());
                validate(userName.getText().toString(),password.getText().toString());
            }
        });
    }
    public LoginActivity(Context context){

    }

    public String validate(String userName, String password)
    {
        if(userName.equals("admin") && password.equals("admin")) {
            return "Login was successful";
        }
        else{
            return "Invalid login!";
        }
    }

    public String validateUsername(String userName) {
        Matcher matcher = EMAIL_REGEX.matcher(userName);
        if (matcher.find()) {
            return "Valid username";
        }

        else {
            return "Invalid username";
        }
    }

}
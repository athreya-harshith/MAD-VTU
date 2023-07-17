package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText sun,sp;
    String regex = "^(?=.*[A-Z])(?=.*[a=z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sun = findViewById(R.id.sun);
        sp = findViewById(R.id.sp);
    }

    public  void signUp(View v)
    {
        String uname = sun.getText().toString();
        String upass = sp.getText().toString();
        if(validatePassword(upass))
        {
            Bundle bundle = new Bundle();
            bundle.putString("Uname", uname);
            bundle.putString("Pass", upass);
            Intent it = new Intent(MainActivity.this, loginActivity.class);
            it.putExtras(bundle);
            startActivity(it);
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Invalid Password",Toast.LENGTH_SHORT).show();
        }
    }
    public  boolean validatePassword(String pass)
    {
        Pattern pat = Pattern.compile(regex);
        Matcher mat = pat.matcher(pass);
        return  mat.matches();
    }
}
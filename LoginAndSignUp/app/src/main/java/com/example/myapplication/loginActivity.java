package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {

    EditText lun,lp;
    Bundle bundle;
    int cnt =0;
    Button lbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lun = findViewById(R.id.lun);
        lp = findViewById(R.id.lp);
        bundle = getIntent().getExtras();
        lbtn = findViewById(R.id.lbtn);
    }
    public  void login(View v)
    {
        String eun = bundle.getString("Uname");
        String ep = bundle.getString("Pass");

        String un = lun.getText().toString();
        String p = lp.getText().toString();

        Toast.makeText(getApplicationContext(),"Passowrd "+ep+"User Name "+eun,Toast.LENGTH_SHORT).show();
        if(un.equals(eun) && p.equals(ep))
        {
            Toast.makeText(getApplicationContext(),"Logged In successfully",Toast.LENGTH_SHORT).show();
        }
        else
        {
            cnt++;
            if(cnt == 3)
            {
                lbtn.setEnabled(false);
            }
        }
    }
}
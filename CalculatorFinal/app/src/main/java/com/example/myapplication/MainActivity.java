package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    String op1="",op2="";
    String operator;
    int opcnt=0, sec;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt = findViewById(R.id.res);
    }
    public void append(View v)
    {
        String s = txt.getText().toString();
        s+=v.getTag().toString();
        txt.setText(s);
    }

    public void opappend(View v)
    {
        opcnt++;
        String c = v.getTag().toString();
        if(opcnt>=2)
        {
            Toast.makeText(getApplicationContext(),"Invalid Expression",Toast.LENGTH_SHORT).show();
            return;
        }
        operator = c;
        String s = txt.getText().toString();
        if(opcnt == 1)
            op1 = s;
        sec = s.length();
        s+=c;
        txt.setText(s);

    }

    public  void calculate(View v)
    {
        String s = txt.getText().toString();
        op2 = s.substring(sec+1,s.length());
        Double l = Double.parseDouble(op1);
        Double r = Double.parseDouble(op2);
        Toast.makeText(getApplicationContext(),"The operator is "+operator+"The l value"+l+"The R value"+r,Toast.LENGTH_SHORT).show();
        Double res =0.0;
        if(operator.equals("+") )
        {
            res = l+r;
        }
        else if(operator.equals("-"))
        {
            res = l-r;
        }
        else if(operator.equals("*"))
        {
            res = l*r;
        }
        else if(operator.equals("/"))
        {
            try {
                res = l/r;
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Invalid Operator"+r,Toast.LENGTH_SHORT).show();
            }

        }
        txt.setText(""+res);
    }
    public  void clear (View v)
    {
        txt.setText("");
        opcnt =0;
        op1 = "";
        op2 = "";
    }

}
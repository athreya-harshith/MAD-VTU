package com.example.caller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText phno;
    Button call;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phno =(EditText) findViewById(R.id.phno);
        call = (Button)findViewById(R.id.call);
    }

    public void save(View v)
    {
        Intent contactIntent= new Intent
                (ContactsContract.Intents.Insert.ACTION);
        contactIntent.setType
                (ContactsContract.RawContacts.CONTENT_TYPE);
        contactIntent
                .putExtra(ContactsContract.Intents.Insert.NAME,"Unknown");
        contactIntent.putExtra(ContactsContract.Intents.Insert.PHONE,
                phno.getText().toString());
        startActivity(contactIntent);
    }
    public void del(View v)
    {
        String data=phno.getText().toString();
        if(data.length()>0)
        {
            phno.setText
                    (data.substring(0,data.length()-1));
        }
        else
        {
            phno.setText("");
        }
    }
    public void append(View v)
    {
        String s = phno.getText().toString();
        s+=v.getTag().toString();
        phno.setText(s);
    }

    public void call(View v)
    {
        String data = phno.getText().toString();
        Intent intent=new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+ data));
        startActivity(intent);
    }
}
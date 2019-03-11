package com.example.user.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.os.Message;
import android.os.Messenger;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View.OnClickListener;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    EditText Login;
    EditText Password;
    TextView Label;
    Button Auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login = (EditText) findViewById(R.id.editText);
        Password = (EditText) findViewById(R.id.editText2);
        Label = (TextView) findViewById(R.id.textView);
        Auth = (Button) findViewById(R.id.button);

        OnClickListener AuthClick = new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Main2 = new Intent(MainActivity.this, Main2Activity.class);

                Main2.putExtra("tlogin", Login.getText().toString());
                Main2.putExtra("tpass", Password.getText().toString());
                startActivity(Main2);
            }
        };

        Auth.setOnClickListener(AuthClick);
    }
}

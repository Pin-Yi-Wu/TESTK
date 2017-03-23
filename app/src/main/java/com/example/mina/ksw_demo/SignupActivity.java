package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {
    Button btnsignup2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        btnsignup2 = (Button)findViewById(R.id.btnsignup2);
    btnsignup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(SignupActivity.this,MainActivity.class);
                startActivity(intent);
                SignupActivity.this.finish();
            }
        });
    }
}

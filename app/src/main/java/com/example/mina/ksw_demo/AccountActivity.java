package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Mina on 2017/4/20.
 */

public class AccountActivity extends BaseActivity {

    LinearLayout dynamicContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        View wizard = getLayoutInflater().inflate(R.layout.activity_account, null);
        dynamicContent.addView(wizard);
        FrameLayout btnlogout =(FrameLayout)findViewById(R.id.btnlogout);
        ImageButton btneditpassword =(ImageButton)findViewById(R.id.btneditpassword);
        ImageButton btnedit =(ImageButton)findViewById(R.id.btnedit);
        ImageButton btnbindemail =(ImageButton)findViewById(R.id.btnbindemail);
        TextView btnbindphone =(TextView)findViewById(R.id.btnbindphone);
        ImageButton btnbindcard =(ImageButton)findViewById(R.id.btnbindcard);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Inflater inflater = new Inflater();
        TextView title=(TextView)toolbar.findViewById(R.id.title) ;
        title.setText("帐户信息");
        toolbar.setNavigationIcon(R.mipmap.nav_customer_icon);          //在這邊可以用drawable改變不同的返回icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MyActivity.class));        //表示點擊後Intent的頁面
            }
        });
        btnedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Edit_Account.class);
                startActivity(intent);
                finish();
            }
        });

        btnlogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btneditpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Edit_Password.class);
                startActivity(intent);
                finish();
            }
        });
        btnbindemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Bind_Email.class);
                startActivity(intent);
                finish();
            }
        });
        btnbindphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Bind_Phone.class);
                startActivity(intent);
                finish();
            }
        });
        btnbindcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Bind_Card.class);
                startActivity(intent);
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.help:
                Intent intent = new Intent();
                intent.setClass(AccountActivity.this,Customer_Service.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
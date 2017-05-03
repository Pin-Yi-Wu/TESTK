package com.example.mina.ksw_demo;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Mina on 2017/4/20.
 */

public class MyActivity extends BaseActivity {

    LinearLayout dynamicContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        View wizard = getLayoutInflater().inflate(R.layout.activity_my, null);
        dynamicContent.addView(wizard);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.listing);
        rb.setCompoundDrawablesWithIntrinsicBounds( 0,R.mipmap.member_touch_icon, 0,0);
        rb.setTextColor(Color.parseColor("#D8A86B"));
        ImageButton img7=(ImageButton)findViewById(R.id.img7);
        ImageButton btnbalance=(ImageButton)findViewById(R.id.btnbalance);
        ImageButton btndeposit=(ImageButton)findViewById(R.id.btndeposit);
        ImageButton btntransfer=(ImageButton)findViewById(R.id.btntransfer);
        ImageButton btndebit=(ImageButton)findViewById(R.id.btndebit);
        TextView tvaccountName = (TextView)findViewById(R.id.tvaccountName);
        FrameLayout frgdesposite = (FrameLayout)findViewById(R.id.frgdesposite);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Inflater inflater = new Inflater();
        TextView title=(TextView)toolbar.findViewById(R.id.title) ;
        title.setText("我的");
        toolbar.setNavigationIcon(R.mipmap.nav_customer_icon);          //在這邊可以用drawable改變不同的返回icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));        //表示點擊後Intent的頁面
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,AccountActivity.class);
                startActivity(intent);
                finish();
            }
        });
        btnbalance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,Balance_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        frgdesposite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,DepositActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btntransfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,Transfer_Activity.class);
                startActivity(intent);
                finish();
            }
        });
        btndebit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MyActivity.this,Debit_Activity.class);
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
                intent.setClass(MyActivity.this,Customer_Service.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
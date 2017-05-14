package com.example.mina.ksw_demo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by Mina on 2017/4/20.
 */

public class My_VIP extends BaseActivity {

    LinearLayout dynamicContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        View wizard = getLayoutInflater().inflate(R.layout.my_vip, null);
        dynamicContent.addView(wizard);
        RadioGroup rg=(RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton rb=(RadioButton)findViewById(R.id.listing);
        rb.setCompoundDrawablesWithIntrinsicBounds( 0,R.mipmap.member_touch_icon, 0,0);
        rb.setTextColor(Color.parseColor("#D8A86B"));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final Inflater inflater = new Inflater();
        TextView title=(TextView)toolbar.findViewById(R.id.title) ;
        title.setText("VIP会所");
        toolbar.setNavigationIcon(R.mipmap.nav_customer_icon);          //在這邊可以用drawable改變不同的返回icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));        //表示點擊後Intent的頁面
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
                intent.setClass(My_VIP.this,Customer_Service.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Find_Account extends AppCompatActivity {
    Button btnlogin3,btnbacklogin3;
    RadioButton rb_password,rb_account;
    RadioGroup rb_group;
    TextView tv_hint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_account);
        btnbacklogin3 = (Button)findViewById(R.id.btnbacklogin3);
        btnlogin3=(Button)findViewById(R.id.btnlogin3) ;
        rb_account=(RadioButton)findViewById(R.id.rb_account) ;
        rb_password=(RadioButton)findViewById(R.id.rb_password);
        rb_group=(RadioGroup)findViewById(R.id.rb_group);
        tv_hint=(TextView)findViewById(R.id.tv_hint);
        //rb_account.setOnCheckedChangeListener(mOnCheckedChangeListener);
       // rb_password.setOnCheckedChangeListener(mOnCheckedChangeListener);
        btnbacklogin3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Find_Account.this,MainActivity.class);
                startActivity(intent);
            }
        });
        //toolbar source
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Inflater inflater = new Inflater();
        TextView title=(TextView)toolbar.findViewById(R.id.title) ;
        title.setText("帐号恢复");
        toolbar.setNavigationIcon(R.mipmap.nav_customer_icon);          //在這邊可以用drawable改變不同的返回icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));        //表示點擊後Intent的頁面
            }
        });

        rb_group.setOnCheckedChangeListener(mOnchange);
    }

    private RadioGroup.OnCheckedChangeListener mOnchange = new
            RadioGroup.OnCheckedChangeListener()
            {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId)
                {
                    // TODO Auto-generated method stub
                    if(checkedId==rb_account.getId())
                    {
        /*把mRadio1的內容傳到mTextView1*/
                        tv_hint.setText("请联系[在线客服]进行获取您的游戏帐号");
                        btnlogin3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setClass(Find_Account.this,Customer_Service.class);
                                startActivity(intent);
                            }
                        });

                    }
                    else if(checkedId==rb_password.getId())
                    {
        /*把mRadio2的內容傳到mTextView1*/
                        btnlogin3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent intent = new Intent();
                                intent.setClass(Find_Account.this,Find_Password.class);
                                startActivity(intent);
                            }
                        });
                        tv_hint.setText(" ");
                    }
                }
            };


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
                intent.setClass(Find_Account.this,Customer_Service_Nologin.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

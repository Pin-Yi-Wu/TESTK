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
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

public class Edit_Password extends BaseActivity {
    LinearLayout dynamicContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dynamicContent = (LinearLayout) findViewById(R.id.dynamicContent);
        View wizard = getLayoutInflater().inflate(R.layout.edit_password, null);
        dynamicContent.addView(wizard);

        EditText editOpass = (EditText)findViewById(R.id.editOpass);
        editOpass.setBackgroundDrawable(null);
        EditText editNpass = (EditText)findViewById(R.id.editNpass);
        editNpass.setBackgroundDrawable(null);
        EditText editNpass2 = (EditText)findViewById(R.id.editNpass2);
        editNpass2.setBackgroundDrawable(null);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Inflater inflater = new Inflater();
        TextView title=(TextView)toolbar.findViewById(R.id.title) ;
        Button btnok2 = (Button)findViewById(R.id.btnok2) ;
        title.setText("修改登录密码");
        toolbar.setNavigationIcon(R.mipmap.nav_customer_icon);          //在這邊可以用drawable改變不同的返回icon
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AccountActivity.class));        //表示點擊後Intent的頁面
            }
        });
btnok2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        intent.setClass(Edit_Password.this,SuccessFPActivity.class);
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
                intent.setClass(Edit_Password.this,Customer_Service_Nologin.class);
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnlogin,btnsignup,btnforget;
    EditText edtlogin1,edtpassword2;
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnlogin = (Button)findViewById(R.id.btnlogin);
        btnsignup = (Button)findViewById(R.id.btnsignup2);
        btnforget = (Button)findViewById(R.id.btnforget);
        edtlogin1 = (EditText)findViewById(R.id.edtlogin1);
        edtpassword2 = (EditText)findViewById(R.id.edtpassword2);
        img1 = (ImageView)findViewById(R.id.img1);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String[] account = {"Amy","Tom"};
                String[] password = {"123","456"};
                for (int i = 0; i < account.length; i++) { // 用一個迴圈把帳號跟密碼從陣列取出
                    if (edtlogin1.getText().toString().equals(account[i])
                            && edtpassword2.getText().toString().equals(password[i])) {
                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, HallActivity.class);
                        startActivity(intent);
                        MainActivity.this.finish();

                        break;//一定要break,否則會無法判斷第二組
                    } else {
                        Toast.makeText(MainActivity.this,"輸入錯誤，請重新輸入",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, SignupActivity.class);
                startActivity(intent);
                MainActivity.this.finish();
            }
        });

       /* btnforget.setOnClickListener(new View.OnClickListener() {
            public  void  onClick(View v){
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SuccessActivity.class);
                startActivity(intent);
                MainActivity.this.finish();

            }
        });*/
    }
}

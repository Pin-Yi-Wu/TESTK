package com.example.mina.ksw_demo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    Button btnlogin, btnsignup, btnforget,btnhelp;
    EditText edtlogin1, edtpassword2;
    ImageView img1;
    CheckBox hide01;
    Toast toast;
    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9#_~!$&'()*+,;=:.\"(),:;<>@\\[\\]\\\\]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*$";
    private Pattern pattern = Pattern.compile(EMAIL_PATTERN);
    private Matcher matcher;
    private void hideKeyboard() {
        View view = getCurrentFocus();
        if (view != null) {
            ((InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)).
                    hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextInputLayout usernameWrapper = (TextInputLayout) findViewById(R.id.usernameWrapper);
        final TextInputLayout passwordWrapper = (TextInputLayout) findViewById(R.id.passwordWrapper);
       // usernameWrapper.setHint("用户名");
        passwordWrapper.setHint("密码");

        //toolbar source
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Inflater inflater = new Inflater();

        btnlogin = (Button) findViewById(R.id.btnlogin);
        btnsignup = (Button) findViewById(R.id.btnsignup2);
        btnforget = (Button) findViewById(R.id.btnforget);
        btnhelp = (Button)findViewById(R.id.btnhelp) ;
        edtlogin1 = (EditText) findViewById(R.id.edtlogin1);
        edtpassword2 = (EditText) findViewById(R.id.edtnumber);
        img1 = (ImageView) findViewById(R.id.img1);
        ImageButton imgsignup = (ImageButton)findViewById(R.id.imgsignup1);
        ImageButton imgforget = (ImageButton)findViewById(R.id.imgforget1);
        ImageButton imghelp = (ImageButton)findViewById(R.id.imghelp);
      //因使用"InputType-textpassword"因此就不需要在用其他按鈕實現密碼隱藏  hide01 = (CheckBox) findViewById(R.id.hide01);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideKeyboard();
                String username = usernameWrapper.getEditText().getText().toString();
                String passwordwrapper = passwordWrapper.getEditText().getText().toString();
               String md5 =  convertPassMd5.convertPassMd5(username);
                Log.d("md5",md5);
                if (!validateEmail(username)) {
                    usernameWrapper.setError("信箱格式不正确！");
                } else if (!validatePassword(passwordwrapper)) {
                    passwordWrapper.setError("密码错误！");
                } else {
                    usernameWrapper.setErrorEnabled(false);
                    passwordWrapper.setErrorEnabled(false);
                    doLogin();

                }
            }
        });
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
        imgsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,SignupActivity.class);
                startActivity(intent);
            }
        });
                 /*   因使用"InputType-textpassword"因此就不需要在用其他按鈕實現密碼隱藏
                                hide01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                    @Override
                                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                        if (hide01.isChecked()) {
                                            edtpassword2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                                        } else {
                                            edtpassword2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                                        } }});*/
        btnforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Find_Account.class);
                startActivity(intent);
            }
        });
        imgforget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Find_Account.class);
                startActivity(intent);
            }
        });
        btnhelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,HallActivity.class);           //CUSTOMER_SERVICE
                startActivity(intent);
            }
        });
        imghelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this,Customer_Service_Nologin.class);           //CUSTOMER_SERVICE
                startActivity(intent);
            }
        });

}
    public boolean validateEmail(String email) {
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean validatePassword(String password) {
        return password.length() > 5;
    }
    public void doLogin() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, HallActivity.class);
        startActivity(intent);
        // TODO: login procedure; not within the scope of this tutorial.
    }
}
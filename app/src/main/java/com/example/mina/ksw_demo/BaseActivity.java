package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.zip.Inflater;

public class BaseActivity extends AppCompatActivity {


    RadioGroup radioGroup1;
    RadioButton deals;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity);

        radioGroup1=(RadioGroup)findViewById(R.id.radioGroup1);
        deals = (RadioButton)findViewById(R.id.deals);
        radioGroup1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                Intent in;
                Log.i("matching", "matching inside1 bro" + checkedId);
                switch (checkedId)
                {
                    case R.id.matching:
                        Log.i("matching", "matching inside1 matching" +  checkedId);
                        in=new Intent(getBaseContext(),HallActivity.class);
                        startActivity(in);
                        finish();
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.watchList:
                        Log.i("matching", "matching inside1 watchlistAdapter" + checkedId);

                        in = new Intent(getBaseContext(), LiveActivity.class);
                        startActivity(in);
                        finish();
                        overridePendingTransition(0, 0);

                        break;
                    case R.id.rates:
                        Log.i("matching", "matching inside1 rate" + checkedId);
                        in = new Intent(getBaseContext(),SlotActivity.class);
                        startActivity(in);
                        finish();
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.deals:
                        Log.i("matching", "matching inside1 deals" + checkedId);
                        in = new Intent(getBaseContext(), GamesActivity.class);
                        startActivity(in);
                        finish();
                        overridePendingTransition(0, 0);
                        break;

                    case R.id.listing:
                        Log.i("matching", "matching inside1 listing" + checkedId);
                        in = new Intent(getBaseContext(), MyActivity.class);
                        startActivity(in);
                        finish();
                        overridePendingTransition(0, 0);
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
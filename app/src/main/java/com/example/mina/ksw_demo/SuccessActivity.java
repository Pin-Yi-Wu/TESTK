package com.example.mina.ksw_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

public class SuccessActivity extends AppCompatActivity {

    private TextView infoTextView;              //ToolBarSource
    private BottomNavigationView bottomNavigationView;            //ToolBarSource

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        //toolbar source
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Inflater inflater = new Inflater();

        infoTextView = (TextView) findViewById(R.id.infoTextView);        //ToolBarSource

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavigationView);        //ToolBarSource

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.inicioItem) {
                    infoTextView.setText(R.string.inicio);
                } else if (item.getItemId() == R.id.buscarItem) {
                    infoTextView.setText(R.string.buscar);
                } else if (item.getItemId() == R.id.camaraItem) {
                    infoTextView.setText(R.string.camara);
                } else if (item.getItemId() == R.id.favoritosItem) {
                    infoTextView.setText(R.string.favoritos);
                } else if (item.getItemId() == R.id.perfilItem) {
                    infoTextView.setText(R.string.perfil);
                }

                return false;
            }
        });                             //ToolBarSource

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
                intent.setClass(SuccessActivity.this,Customer_Service.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
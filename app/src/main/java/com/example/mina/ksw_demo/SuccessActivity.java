package com.example.mina.ksw_demo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class SuccessActivity extends AppCompatActivity {

    private TextView infoTextView;              //ToolBarSource
    private BottomNavigationView bottomNavigationView;            //ToolBarSource

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

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

    }}
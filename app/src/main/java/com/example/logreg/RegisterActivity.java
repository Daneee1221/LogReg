package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText  Email,Felhasz,Jelszo,Teljesnev;
    Button regisztracio,vissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();

        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = Email.getText().toString();
                String felhasz = Felhasz.getText().toString();
                String jelszo = Jelszo.getText().toString();
                String teljesnev = Teljesnev.getText().toString();
                if (email.isEmpty() || felhasz.isEmpty() || jelszo.isEmpty() || teljesnev.isEmpty()){
                    Toast.makeText(RegisterActivity.this,
                            "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
                    return;
                }
                adatFelvetel(email, felhasz, jelszo, teljesnev);
                Intent vissza =
                        new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(vissza);
                finish();
            }
        });

        vissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent keresesActivityre =
                        new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(keresesActivityre);
                finish();
            }
        });
    }

    private void adatFelvetel(String email, String felhasz, String jelszo, String teljesnev) {
        AdatBazisSegito dbHelper = new AdatBazisSegito(RegisterActivity.this);
        if (dbHelper.adatFelvetel(email,felhasz,jelszo,teljesnev)){
            Toast.makeText(this, "Sikeres Adatfelvétel", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Sikertelen Adatfelvétel", Toast.LENGTH_SHORT).show();
        }
    }

    public void init()
    {
        Email = findViewById(R.id.email);
        Felhasz = findViewById(R.id.felhasz);
        Jelszo = findViewById(R.id.jelszo);
        Teljesnev = findViewById(R.id.teljesnev);
        regisztracio = findViewById(R.id.regisztracio);
        vissza = findViewById(R.id.vissza);
    }
}
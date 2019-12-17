package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText bejelentkezofelhasz, bejelentkezojelszo;
    Button bejelenkezes, regisztracio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        regisztracio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent regisztracioActivityre =
                        new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(regisztracioActivityre);
                finish();
            }
        });

        bejelenkezes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AdatBazisSegito dbhelper = new AdatBazisSegito(MainActivity.this);
                String felhasznalonev=bejelentkezofelhasz.getText().toString();
                String jelszo=bejelentkezojelszo.getText().toString();
                if (dbhelper.Bejelentkezes(felhasznalonev,jelszo))
                {
                    Intent loggedin= new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(loggedin);
                    finish();
                }
                Toast.makeText(MainActivity.this,
                        "Hibás felhasználónév vagy jelszó", Toast.LENGTH_SHORT).show();

                /*Cursor cursorAdatok = dbhelper.Bejelentkezes();
                if (cursorAdatok == null){
                    Toast.makeText(MainActivity.this,
                            "Sikertlen Adatlekérdezés", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cursorAdatok.getCount() == 0){
                    Toast.makeText(MainActivity.this,
                            "Nincs még felvéve adat", Toast.LENGTH_SHORT).show();
                    return;
                }
                StringBuffer stringBuffer = new StringBuffer();
                String bejelentkezoneve = bejelentkezofelhasz.getText().toString();
                String bejelentkezojelszava = bejelentkezojelszo.getText().toString();
                boolean felhaszjo = false;
                boolean jelszojo = false;

                while (cursorAdatok.moveToNext()){
                    stringBuffer.append("ID: "+cursorAdatok.getString(0));
                    if (bejelentkezoneve.equals(cursorAdatok.getString(1)))
                    {
                        felhaszjo = true;
                    }
                    if (bejelentkezoneve.equals(cursorAdatok.getString(2)))
                    {
                        felhaszjo = true;
                    }
                    if (bejelentkezojelszava.equals(cursorAdatok.getString(3)))
                    {
                        jelszojo = true;
                    }
                }

                if(felhaszjo == true || jelszojo == true)
                {
                    String bejelentkezofelhasz = dbhelper.Bejelentkezoneve(bejelentkezoneve);
                    Intent loggedIn =
                            new Intent(MainActivity.this, LoggedInActivity.class);
                    startActivity(loggedIn);
                    finish();
                }
                else
                {
                    Toast.makeText(MainActivity.this, "Hiba történt", Toast.LENGTH_SHORT).show();
                }*/
            }
        });

    }

    public void init()
    {
        bejelenkezes = findViewById(R.id.bejelentkezes);
        regisztracio = findViewById(R.id.regisztracio);
        bejelentkezofelhasz = findViewById(R.id.bejelentkezofelhasz);
        bejelentkezojelszo = findViewById(R.id.bejelentkezojelszo);
    }
}
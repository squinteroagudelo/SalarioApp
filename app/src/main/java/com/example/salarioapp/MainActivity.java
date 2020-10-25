package com.example.salarioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname, etuser, etpasword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        etname = findViewById(R.id.etname);
        etuser = findViewById(R.id.etuser);
        etpasword = findViewById(R.id.etpassword);
        etname.requestFocus();

        clear();
    }

    public void login(View v) {
        if (isValidated(etname)) {
            if (isValidated(etuser)) {
                if (isValidated(etpasword)) {
                    String name = etname.getText().toString();
                    Intent datas = new Intent(this, DatasActivity.class);
                    datas.putExtra("name", name);
                    startActivity(datas);
                } else {
                    Toast.makeText(getApplicationContext(), "Ingrese la contraseña", Toast.LENGTH_LONG).show();
                    etpasword.requestFocus();
                }
            } else {
                Toast.makeText(getApplicationContext(), "Ingrese el usuario", Toast.LENGTH_LONG).show();
                etuser.requestFocus();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ingrese el nombre del empleado", Toast.LENGTH_LONG).show();
            etname.requestFocus();
        }

    }

    public boolean isValidated(EditText et) {
        if (et.getText().toString().isEmpty())
            return false;
        else
            return true;
    }

    public void clear(){
        etname.setText("");
        etuser.setText("");
        etpasword.setText("");
    }
}
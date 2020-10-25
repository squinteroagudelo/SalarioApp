package com.example.salarioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DatasActivity extends AppCompatActivity {

    TextView tvname;
    EditText ethours, etprice, etplus;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datas);

        getSupportActionBar().setTitle("Salario - Datos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tvname = findViewById(R.id.tvname);
        ethours = findViewById(R.id.ethours);
        etprice = findViewById(R.id.etprice);
        etplus = findViewById(R.id.etplus);
        name = getIntent().getStringExtra("name");

        tvname.setText(name);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return false;
    }

    public void sendData(View v){
        if(isValidated(ethours)){
            if (isValidated(etprice)){
                if (isValidated(etplus)){
                    int hours = Integer.parseInt(ethours.getText().toString());
                    int price = Integer.parseInt(etprice.getText().toString());
                    int plus = Integer.parseInt(etplus.getText().toString());
                    Intent result = new Intent(this, ResultActivity.class);
                    result.putExtra("name", name);
                    result.putExtra("hours", hours);
                    result.putExtra("price", price);
                    result.putExtra("plus", plus);
                    startActivity(result);
                }else{
                    Toast.makeText(getApplicationContext(), "Ingrese las horas extras", Toast.LENGTH_LONG).show();
                    etplus.requestFocus();
                }
            }else{
                Toast.makeText(getApplicationContext(), "Ingrese el valor de la hora", Toast.LENGTH_LONG).show();
                etprice.requestFocus();
            }
        }else{
            Toast.makeText(getApplicationContext(), "Ingrese las horas trabajadas", Toast.LENGTH_LONG).show();
            ethours.requestFocus();
        }
    }

    public boolean isValidated(EditText et) {
        if (et.getText().toString().isEmpty())
            return false;
        else
            return true;
    }
}
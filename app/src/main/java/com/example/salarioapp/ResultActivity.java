package com.example.salarioapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    String name;
    int hours, price, plus;
    float salary;

    TextView tvemployee, tvresulthours, tvresultprice, tvresultplus, tvresult, tvsalary, tvsymbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        getSupportActionBar().setTitle("Salario - Resultados");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        name = getIntent().getStringExtra("name");
        hours = getIntent().getIntExtra("hours", 0);
        price = getIntent().getIntExtra("price", 0);
        plus = getIntent().getIntExtra("plus", 0);

        tvemployee = findViewById(R.id.tvemployee);
        tvresulthours = findViewById(R.id.tvresulthours);
        tvresultprice = findViewById(R.id.tvresultprice);
        tvresultplus = findViewById(R.id.tvresultplus);
        tvresult = findViewById(R.id.tvresult);
        tvsalary = findViewById(R.id.tvsalary);
        tvsymbol = findViewById(R.id.tvsymbol);

        tvemployee.setText(name);
        tvresulthours.setText(String.valueOf(hours));
        tvresultprice.setText(String.valueOf(price));
        tvresultplus.setText(String.valueOf(plus));

        tvsalary.setVisibility(View.INVISIBLE);
        tvsymbol.setVisibility(View.INVISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        Intent home = new Intent(this, MainActivity.class);
        startActivity(home);
        return false;
    }

    public void calculate(View v){
        salary = (float) (hours * price + (plus * (price + price * 0.25)));
        tvresult.setText(String.valueOf(salary));
        tvsalary.setVisibility(View.VISIBLE);
        tvsymbol.setVisibility(View.VISIBLE);
    }

    public void exit(View v){
        finishAffinity();
    }
}
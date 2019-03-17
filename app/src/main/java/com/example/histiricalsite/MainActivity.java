package com.example.histiricalsite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void explore(View view) {
        Intent exp = new Intent(MainActivity.this, ListActivity.class);
        startActivity(exp);
    }

    public void credit(View view) {
        Intent cre = new Intent(MainActivity.this, CreditActivity.class);
        startActivity(cre);
    }
}

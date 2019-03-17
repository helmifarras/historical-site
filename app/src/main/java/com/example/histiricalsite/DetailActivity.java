package com.example.histiricalsite;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // Initialize the views.
        TextView siteTitle = findViewById(R.id.titleDetail);
        TextView locationTitle = findViewById(R.id.locationDetail);
        TextView detailTitle = findViewById(R.id.subTitleDetail);
        ImageView siteImage = findViewById(R.id.siteImageDetail);

        // Set the text from the Intent extra.
        siteTitle.setText(getIntent().getStringExtra("title"));
        locationTitle.setText(getIntent().getStringExtra("location"));
        detailTitle.setText(getIntent().getStringExtra("subdetail"));

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(siteImage);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}

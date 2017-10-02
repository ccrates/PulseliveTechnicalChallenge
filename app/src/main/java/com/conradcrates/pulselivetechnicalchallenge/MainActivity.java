package com.conradcrates.pulselivetechnicalchallenge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView articles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articles = (RecyclerView)findViewById(R.id.list_articles);
        articles.setLayoutManager(new LinearLayoutManager(this));
        articles.setAdapter(null);
    }
}
package com.conradcrates.pulselivetechnicalchallenge.articles;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.conradcrates.pulselivetechnicalchallenge.R;
import com.conradcrates.pulselivetechnicalchallenge.backend.JSONParser;
import com.conradcrates.pulselivetechnicalchallenge.backend.RestClient;

public class MainActivity extends AppCompatActivity {

    private RecyclerView articlesView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        articlesView = (RecyclerView)findViewById(R.id.list_articles);
        articlesView.setLayoutManager(new LinearLayoutManager(this));

        new RestTask().execute();
    }

    private class RestTask extends AsyncTask<Void, Integer, String>{
        @Override
        protected String doInBackground(Void... voids) {
            return RestClient.getArticles();
        }

        @Override
        protected void onPostExecute(String s) {
            articlesView.setAdapter(new ArticlesAdapter(JSONParser.parseArticles(s), MainActivity.this));
        }
    }
}
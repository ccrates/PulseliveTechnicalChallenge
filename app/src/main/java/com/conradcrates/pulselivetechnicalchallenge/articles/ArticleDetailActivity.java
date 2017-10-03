package com.conradcrates.pulselivetechnicalchallenge.articles;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.conradcrates.pulselivetechnicalchallenge.R;
import com.conradcrates.pulselivetechnicalchallenge.backend.JSONParser;
import com.conradcrates.pulselivetechnicalchallenge.backend.RestClient;
import com.conradcrates.pulselivetechnicalchallenge.constants.IntentConstants;
import com.conradcrates.pulselivetechnicalchallenge.data.Article;

public class ArticleDetailActivity extends AppCompatActivity {

    private TextView title, subtitle, body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_detail);

        title = (TextView)findViewById(R.id.text_title);
        subtitle = (TextView)findViewById(R.id.text_subtitle);
        body = (TextView)findViewById(R.id.text_body);

        if(getIntent() != null){
            Intent intent = getIntent();
            int id = intent.getIntExtra(IntentConstants.ARTICLE_ID, 0);
            new RestTask().execute(id);
        }
    }

    private class RestTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected String doInBackground(Integer... ints) {
            return RestClient.getArticleDetails(ints[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            Article article = JSONParser.parseArticleDetails(s);

            title.setText(article.getTitle());
            subtitle.setText(article.getSubtitle());
            body.setText(article.getBody());
        }
    }
}
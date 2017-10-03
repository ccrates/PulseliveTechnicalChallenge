package com.conradcrates.pulselivetechnicalchallenge.backend;

import android.util.Log;

import com.conradcrates.pulselivetechnicalchallenge.data.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Conrad on 02/10/2017.
 */

public class JSONParser {

    private static final String TAG = JSONParser.class.getSimpleName();

    public static List<Article> getArticles(String data){
        List<Article> articles = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(data);
            JSONArray items = root.getJSONArray("items");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonArticle = items.getJSONObject(i);

                Article article = new Article();
                article.setTitle(jsonArticle.getString("title"));
                article.setSubtitle(jsonArticle.getString("subtitle"));

                articles.add(article);
            }
        } catch (JSONException e){
            Log.e(TAG, e.getMessage());
        }

        return articles;
    }
}
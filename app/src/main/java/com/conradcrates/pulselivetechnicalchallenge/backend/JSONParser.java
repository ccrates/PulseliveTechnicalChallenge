package com.conradcrates.pulselivetechnicalchallenge.backend;

import android.util.Log;

import com.conradcrates.pulselivetechnicalchallenge.data.Article;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Conrad on 02/10/2017.
 */

public class JSONParser {

    private static final String TAG = JSONParser.class.getSimpleName();

    public static List<Article> parseArticles(String data){
        List<Article> articles = new ArrayList<>();

        try {
            JSONObject root = new JSONObject(data);
            JSONArray items = root.getJSONArray("items");
            for(int i = 0; i < items.length(); i++){
                JSONObject jsonArticle = items.getJSONObject(i);

                Article article = new Article();
                article.setId(jsonArticle.getInt("id"));
                article.setTitle(jsonArticle.getString("title"));
                article.setSubtitle(jsonArticle.getString("subtitle"));
                article.setDate(jsonArticle.getString("date"));

                articles.add(article);
            }
        } catch (JSONException e){
            Log.e(TAG, e.getMessage());
        }

        return articles;
    }

    public static Article parseArticleDetails(String data){
        Article article = new Article();

        try{
            JSONObject root = new JSONObject(data);
            JSONObject jsonArticle = root.getJSONObject("item");

            article.setId(jsonArticle.getInt("id"));
            article.setTitle(jsonArticle.getString("title"));
            article.setSubtitle(jsonArticle.getString("subtitle"));
            article.setBody(jsonArticle.getString("body"));
            article.setDate(jsonArticle.getString("date"));
        } catch (JSONException e){
            Log.e(TAG, e.getMessage());
        }

        return article;
    }
}
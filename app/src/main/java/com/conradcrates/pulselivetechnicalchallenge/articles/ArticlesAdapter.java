package com.conradcrates.pulselivetechnicalchallenge.articles;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.conradcrates.pulselivetechnicalchallenge.R;
import com.conradcrates.pulselivetechnicalchallenge.data.Article;

import java.util.List;

/**
 * Created by Conrad on 02/10/2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter {

    private List<Article> articles;

    public ArticlesAdapter(List<Article> articles){
        this.articles = articles;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof ArticleViewHolder){
            ArticleViewHolder vh = (ArticleViewHolder)holder;
        }
    }

    @Override
    public int getItemCount() {
        if(articles != null) {
            return articles.size();
        }

        return 0;
    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder{

        private ArticleViewHolder(View view){
            super(view);
        }
    }
}
package com.conradcrates.pulselivetechnicalchallenge.articles;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.conradcrates.pulselivetechnicalchallenge.R;
import com.conradcrates.pulselivetechnicalchallenge.constants.IntentConstants;
import com.conradcrates.pulselivetechnicalchallenge.data.Article;

import java.util.List;

/**
 * Created by Conrad on 02/10/2017.
 */

public class ArticlesAdapter extends RecyclerView.Adapter {

    private Context context;
    private List<Article> articles;

    public ArticlesAdapter(@NonNull List<Article> articles, Context context){
        this.articles = articles;
        this.context = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewholder_article, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final Article article = articles.get(position);

        if(holder instanceof ArticleViewHolder){
            ArticleViewHolder vh = (ArticleViewHolder)holder;

            vh.title.setText(article.getTitle());
            vh.subtitle.setText(article.getSubtitle());

            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, ArticleDetailActivity.class);
                    intent.putExtra(IntentConstants.ARTICLE_ID, article.getId());
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    private class ArticleViewHolder extends RecyclerView.ViewHolder{

        private TextView title, subtitle;

        private ArticleViewHolder(View view){
            super(view);

            title = (TextView)view.findViewById(R.id.text_title);
            subtitle = (TextView)view.findViewById(R.id.text_subtitle);
        }
    }
}
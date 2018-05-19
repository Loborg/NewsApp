package com.example.android.newsapp.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.models.News;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsHolder> {

    private int mListItemLayoutID;
    private ArrayList<News> mNewsList;

    public NewsAdapter(int listItemLayoutID, ArrayList<News> newsList){
        mListItemLayoutID = listItemLayoutID;
        mNewsList = newsList;
    }

    @Override
    public int getItemCount() {
        if (mNewsList == null){
            return 0;
        } else{
            return mNewsList.size();
        }
    }

    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(mListItemLayoutID, parent, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        ImageView articleTombnail = holder.articleThumbnail;
        if (mNewsList.get(position).getArticleThumbnailImageResource() == 0){
            articleTombnail.setVisibility(View.GONE);
        } else {
            articleTombnail.setImageResource(mNewsList.get(position).getArticleThumbnailImageResource());
        }

        TextView articleWebPublicationDate = holder.articleWebPublicationDate;
        articleWebPublicationDate.setText(mNewsList.get(position).getArticleWebPublicationDate());

        TextView articleHeadline = holder.articleHeadline;
        articleHeadline.setText(mNewsList.get(position).getArticleHeadline());

        TextView articleAuthor = holder.articleAuthor;
        articleAuthor.setText(mNewsList.get(position).getArticleAuthor());
    }

    static class NewsHolder extends RecyclerView.ViewHolder {

        private ImageView articleThumbnail;
        private TextView articleWebPublicationDate;
        private TextView articleHeadline;
        private TextView articleAuthor;

        public NewsHolder(View itemView) {
            super(itemView);
            articleThumbnail = itemView.findViewById(R.id.news_tobnil);
            articleWebPublicationDate = itemView.findViewById(R.id.news_pub_date);
            articleHeadline = itemView.findViewById(R.id.news_headline);
            articleAuthor = itemView.findViewById(R.id.news_author);
        }
    }
}

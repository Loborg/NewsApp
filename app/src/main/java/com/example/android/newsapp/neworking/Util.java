package com.example.android.newsapp.neworking;

import android.content.Context;
import android.widget.ImageView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.models.News;

import java.util.ArrayList;

public class Util {

    public static ArrayList<News> getNewsList(Context context){

        ArrayList<News> news = new ArrayList<News>();

        for (int i = 1; i < 10; i++){
            if (i == 1){
                int tombnil = context.getResources().getIdentifier("test_tombnil", "drawable", context.getPackageName());
                String date = context.getString(R.string.sample_news_pub_date);
                String headline = context.getString(R.string.sample_news_headline);
                String author = context.getString(R.string.sample_news_author);
                news.add(new News(tombnil, date, headline, author));
            } else {
                String date = context.getString(R.string.sample_news_pub_date);
                String headline = context.getString(R.string.sample_news_headline);
                String author = context.getString(R.string.sample_news_author);
                news.add(new News(date, headline, author));
            }
        }

        return news;
    }
}

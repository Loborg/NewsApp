package com.example.android.newsapp.neworking;

import android.content.AsyncTaskLoader;
import android.content.Context;
import com.example.android.newsapp.models.News;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {

    public NewsLoader(Context context) {
        super(context);
    }

    @Override
    public List<News> loadInBackground() {
        return null;
    }
}

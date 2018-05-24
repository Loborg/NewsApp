package com.example.android.newsapp.forms;

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.app.LoaderManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.NewsAdapter;
import com.example.android.newsapp.models.News;
import com.example.android.newsapp.neworking.Util;

import java.util.ArrayList;

import static android.content.Context.CONNECTIVITY_SERVICE;

public class SciTechFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<News>>{
    private NewsAdapter adapter;
    public TextView emptyView;
    private ProgressBar progressBar;
    boolean isConnected;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View containerView = LayoutInflater.from(getActivity()).inflate(R.layout.common_fragment, container, false);

        RecyclerView newsListView = containerView.findViewById(R.id.news_list);
        emptyView = containerView.findViewById(R.id.empty_view);
        progressBar = containerView.findViewById(R.id.progres_bar);
        int newsListId = R.layout.news_list_item;

        ConnectivityManager cm = (ConnectivityManager) getActivity().getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        isConnected = networkInfo != null && networkInfo.isConnectedOrConnecting();

        getLoaderManager().initLoader(1, null, this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        adapter = new NewsAdapter(newsListId, new ArrayList<News>());
        newsListView.addItemDecoration(new DividerItemDecoration(newsListView.getContext(), layoutManager.getOrientation()));
        newsListView.setLayoutManager(layoutManager);
        newsListView.setItemAnimator(new DefaultItemAnimator());
        newsListView.setAdapter(adapter);

        return containerView;
    }

    @NonNull
    @Override
    public Loader<ArrayList<News>> onCreateLoader(int id, @Nullable Bundle args) {
        // Here I can call a new Loader class, In my case the NewsLoader,
        // this will be the loader that ben called when the LoaderManager starts the
        // Loader in the onActivityCreated method
        return new NewsLoader(getActivity());
    }

    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<News>> loader, ArrayList<News> data) {
        //Here I can fill the newly created adapter whit the date the NewsLoader returns
        //For this I need a helper method in the adaptet
        adapter.setData(data, emptyView, getActivity(), isConnected);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<News>> loader) {
    }

    public static class NewsLoader extends AsyncTaskLoader<ArrayList<News>> {

        NewsLoader(Context context) {
            super(context);
        }

        @Override
        protected void onStartLoading() {
            forceLoad();
        }

        @Override
        public ArrayList<News> loadInBackground() {
            //Here I can specifies which task can happen in the background.
            return Util.getNewsList();
        }
    }
}

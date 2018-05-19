package com.example.android.newsapp.forms;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.NewsAdapter;
import com.example.android.newsapp.neworking.Util;

public class SciTechFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View containerView = LayoutInflater.from(getActivity()).inflate(R.layout.common_fragment, container, false);

        RecyclerView newsListView = containerView.findViewById(R.id.news_list);
        NewsAdapter adapter = new NewsAdapter(R.layout.news_list_item, Util.getNewsList(getActivity()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        newsListView.addItemDecoration(new DividerItemDecoration(newsListView.getContext(), layoutManager.getOrientation()));
        newsListView.setLayoutManager(layoutManager);
        newsListView.setItemAnimator(new DefaultItemAnimator());
        newsListView.setAdapter(adapter);

        return containerView;
    }
}

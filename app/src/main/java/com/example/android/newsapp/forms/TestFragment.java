package com.example.android.newsapp.forms;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.android.newsapp.R;

public class TestFragment extends Fragment {

    public TextView emptyView;
    private ProgressBar progressBar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View testFragment = inflater.from(getActivity()).inflate(R.layout.common_fragment, container, false);

        TextView textView = testFragment.findViewById(R.id.test_text);
        textView.setVisibility(View.VISIBLE);
        textView.setText(testFragment.getResources().getString(R.string.teszt_text));

        emptyView = testFragment.findViewById(R.id.empty_view);
        progressBar = testFragment.findViewById(R.id.progres_bar);
        progressBar.setVisibility(View.INVISIBLE);

        return testFragment;
    }
}

package com.example.android.newsapp.adapters;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android.newsapp.R;
import com.example.android.newsapp.forms.SciTechFragment;
import com.example.android.newsapp.forms.TestFragment;


public class ViewPagerAdapter extends FragmentPagerAdapter {
    Context mContext;

    public ViewPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0){
            return new SciTechFragment();
        } else if (position == 1) {
            return new TestFragment();
        } else {
            return null;
        }
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0){
            return mContext.getString(R.string.sample_page_title);
        } else if (position == 1){
            return "Test Header";
        } else {
            return "";
        }
    }
}

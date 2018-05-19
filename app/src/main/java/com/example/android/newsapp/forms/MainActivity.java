package com.example.android.newsapp.forms;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ImageView mainMaenuButton;
    private DrawerLayout mainDrawer;
    private TextView pageTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainMaenuButton = findViewById(R.id.menu_button);
        mainDrawer = findViewById(R.id.main_drawer);
        mainMaenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainDrawer.openDrawer(Gravity.START);
            }
        });

        final ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        final ViewPager pager = findViewById(R.id.main_pager);
        pager.setAdapter(pagerAdapter);

        pageTitle = findViewById(R.id.page_title);
        pageTitle.setText(pagerAdapter.getPageTitle(pager.getCurrentItem()));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                pageTitle.setText(pagerAdapter.getPageTitle(pager.getCurrentItem()));
            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}

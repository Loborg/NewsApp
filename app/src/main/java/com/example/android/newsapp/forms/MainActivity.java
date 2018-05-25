package com.example.android.newsapp.forms;

import android.support.v4.app.*;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.newsapp.R;
import com.example.android.newsapp.adapters.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private ImageView mainMaenuButton;
    private DrawerLayout mainDrawer;
    private TextView pageTitle;
    private ViewPagerAdapter pagerAdapter;
    ViewPager pager;

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

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), this);
        pager = findViewById(R.id.main_pager);
        pager.setAdapter(pagerAdapter);

        NavigationView navView = findViewById(R.id.nav_view);

        //Handles the navigationViews item selection
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.sci_tech:

                        //Refres fragment countent (in theory)
                       /* Fragment selectedFragment = pagerAdapter.getItem(0);
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.detach(selectedFragment);
                        transaction.attach(selectedFragment);
                        transaction.commit();*/

                        pager.setCurrentItem(0);
                        mainDrawer.closeDrawer(Gravity.START);
                        break;
                    case R.id.page_2:
                        pager.setCurrentItem(1);
                        mainDrawer.closeDrawer(Gravity.START);
                        break;
                }
                return true;
            }
        });

        pageTitle = findViewById(R.id.page_title);
        pageTitle.setText(pagerAdapter.getPageTitle(pager.getCurrentItem()));

        //Handles the ViewPager page change and sets the custom header
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

package com.adityasonel.inkpageindicator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.animation.ArgbEvaluator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.adityasonel.inkpage_indicator.InkPageIndicator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.view_pager);
        AppAdapter appAdapter = new AppAdapter(getSupportFragmentManager());
        viewPager.setAdapter(appAdapter);

        InkPageIndicator pageIndicator = findViewById(R.id.page_indicator);
        pageIndicator.setViewPager(viewPager);

        ArgbEvaluator argbEvaluator = new ArgbEvaluator();

        final int color = ContextCompat.getColor(this, android.R.color.holo_orange_light);
        final int color2 = ContextCompat.getColor(this, android.R.color.holo_green_light);
        final int color3 = ContextCompat.getColor(this, android.R.color.holo_blue_light);
        final int[] iArr = new int[]{color, color2, color3};

        TextView main = findViewById(R.id.tv_main);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                int valueOf = iArr[position];
                if (position != 2) {
                    position++;
                }
                position = (int) argbEvaluator.evaluate(positionOffset, valueOf, iArr[position]);
                main.setTextColor(position);
            }

            @Override
            public void onPageSelected(int position) { }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class AppAdapter extends FragmentPagerAdapter {
        AppAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0) {
                return MainFragment.newInstance();
            } else if (position == 1) {
                return MainFragment.newInstance();
            } else if (position == 2) {
                return MainFragment.newInstance();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}

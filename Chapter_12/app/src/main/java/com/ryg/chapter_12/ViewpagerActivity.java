package com.ryg.chapter_12;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class ViewpagerActivity extends Activity {

    private ViewPager mViewPager;
    private int[] imageResIds = {R.drawable.a1, R.drawable.a2, R.drawable.a3};
    private float prePositionOffset ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        init();
    }

    private void init() {
        mViewPager = (ViewPager) findViewById(R.id.ads_vp);
        mViewPager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return imageResIds.length;
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView((View) object);
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                ImageView imageView = new ImageView(ViewpagerActivity.this);
                imageView.setImageResource(imageResIds[position]);
                container.addView(imageView);
                return imageView;
            }
        });

    }
}

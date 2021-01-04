package com.example.projectpkk.Common.OnBoarding;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectpkk.HelperClasses.SliderAdapter;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;

public class OnBoardingActivity extends AppCompatActivity {

    // Variables
    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    Animation animation;
    int currentPosition;
    private static final int NUM_PAGES = 4;

    private ScreenSliderPagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        // Hooks
        viewPager = findViewById(R.id.slider);
//        dotsLayout = findViewById(R.id.dots);
//        letsGetStarted = findViewById(R.id.get_started_btn);

        // Call Adapter
//        sliderAdapter = new SliderAdapter(this);
//        viewPager.setAdapter(sliderAdapter);

        pagerAdapter = new ScreenSliderPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        // Dots
//        addDots(0);
//        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
        finish();
    }

    public void letsGetStarted(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPosition + 1);
    }

//    private void addDots(int position) {
//
//        dots = new TextView[4];
//        dotsLayout.removeAllViews();
//
//        for (int i = 0; i < dots.length; i++) {
//            dots[i] = new TextView(this);
//            dots[i].setText(Html.fromHtml("&#8226"));
//            dots[i].setTextSize(35);
//            dotsLayout.addView(dots[i]);
//        }
//
//        if (dots.length > 0) {
//            dots[position].setTextColor(getResources().getColor(R.color.colorPrimary));
//        }
//
//
//    }

//    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
//        @Override
//        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//        }
//
//        @Override
//        public void onPageSelected(int position) {
//            addDots(position);
//            currentPosition = position;
//            if (position == 0) {
//                letsGetStarted.setVisibility(View.INVISIBLE);
//            } else if (position == 1) {
//                letsGetStarted.setVisibility(View.INVISIBLE);
//            } else if (position == 2) {
//                letsGetStarted.setVisibility(View.INVISIBLE);
//            } else {
//                animation = AnimationUtils.loadAnimation(OnBoardingActivity.this, R.anim.bottom_anim);
//                letsGetStarted.setAnimation(animation);
//                letsGetStarted.setVisibility(View.VISIBLE);
//
//            }
//        }
//
//        @Override
//        public void onPageScrollStateChanged(int state) {
//
//        }
//    };

    private static class ScreenSliderPagerAdapter extends FragmentStatePagerAdapter {

        public ScreenSliderPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    OnBoardingFragment1 tab1 = new OnBoardingFragment1();
                    return tab1;
                case 1:
                    OnBoardingFragment2 tab2 = new OnBoardingFragment2();
                    return tab2;
                case 2:
                    OnBoardingFragment3 tab3 = new OnBoardingFragment3();
                    return tab3;
                case 3:
                    OnBoardingFragment4 tab4 = new OnBoardingFragment4();
                    return tab4;
            }
            return null;
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }


}


package com.example.projectpkk;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalAdapter;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRPLAdapter;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalTKJAdapter;
import com.google.android.material.tabs.TabLayout;

public class JadwalTKJFragment extends Fragment {

    TabLayout tabLayout;
    CustomViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_jadwal_t_k_j, container, false);

        tabLayout = view.findViewById(R.id.jadwal_tkj_tab_layout);
        viewPager = view.findViewById(R.id.jadwal_tkj_view_pager);

        tabLayout.addTab(tabLayout.newTab().setText("KELAS 10"));
        tabLayout.addTab(tabLayout.newTab().setText("KELAS 11"));
        tabLayout.addTab(tabLayout.newTab().setText("KELAS 12"));

        final JadwalTKJAdapter adapter = new JadwalTKJAdapter(getChildFragmentManager(), getActivity(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()) {
                    case 0:
                        viewPager.setCurrentItem(0);
                        break;
                    case 1:
                        viewPager.setCurrentItem(1);
                        break;
                    case 2:
                        viewPager.setCurrentItem(2);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        int betweenSpace = 20;
        ViewGroup slidingTabStrip = (ViewGroup) tabLayout.getChildAt(0);

        for (int i = 0; i < slidingTabStrip.getChildCount() - 1; i++) {
            View v = slidingTabStrip.getChildAt(i);
            ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
            params.rightMargin = betweenSpace;
        }

        viewPager.disableScroll(true);

        return view;

    }
}
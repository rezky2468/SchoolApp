package com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalAdapter;
import com.example.projectpkk.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class MenuJadwalFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton floatingActionButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_menu_jadwal, container, false);

        tabLayout = root.findViewById(R.id.jadwal_tab_layout);
        viewPager = root.findViewById(R.id.jadwal_view_pager);
        floatingActionButton = root.findViewById(R.id.fab_jadwal);

        tabLayout.addTab(tabLayout.newTab().setText("10 RPL"));
        tabLayout.addTab(tabLayout.newTab().setText("10 TKJ"));
        tabLayout.addTab(tabLayout.newTab().setText("10 PKM"));
        tabLayout.addTab(tabLayout.newTab().setText("11 RPL"));
        tabLayout.addTab(tabLayout.newTab().setText("11 TKJ"));
        tabLayout.addTab(tabLayout.newTab().setText("11 PKM"));
        tabLayout.addTab(tabLayout.newTab().setText("12 RPL"));
        tabLayout.addTab(tabLayout.newTab().setText("12 TKJ"));
        tabLayout.addTab(tabLayout.newTab().setText("12 PKM"));

        final JadwalAdapter adapter = new JadwalAdapter(getChildFragmentManager(), getActivity(), tabLayout.getTabCount());
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
                    case 3:
                        viewPager.setCurrentItem(3);
                        break;
                    case 4:
                        viewPager.setCurrentItem(4);
                        break;
                    case 5:
                        viewPager.setCurrentItem(5);
                        break;
                    case 6:
                        viewPager.setCurrentItem(6);
                        break;
                    case 7:
                        viewPager.setCurrentItem(7);
                        break;
                    case 8:
                        viewPager.setCurrentItem(8);
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

        return root;
    }
}
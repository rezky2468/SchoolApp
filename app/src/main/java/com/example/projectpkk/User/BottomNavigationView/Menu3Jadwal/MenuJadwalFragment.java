package com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.projectpkk.CustomViewPager;
import com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalAdapter;
import com.example.projectpkk.R;
import com.google.android.material.tabs.TabLayout;

import java.text.SimpleDateFormat;

public class MenuJadwalFragment extends Fragment {

    TabLayout tabLayout;
    CustomViewPager viewPager;
    TextView tanggal, edit;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_menu_jadwal, container, false);

        tabLayout = root.findViewById(R.id.jadwal_tab_layout);
        viewPager = root.findViewById(R.id.jadwal_view_pager);
        tanggal = root.findViewById(R.id.tanggal);
        edit = root.findViewById(R.id.jadwal_edit);

        long date = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("E, dd MMM yyyy");
        String dateString = simpleDateFormat.format(date);
        tanggal.setText(dateString);

        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.rpl_short)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tkj_short)));
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.pkm_short)));

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
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), JadwalEditActivity.class));
            }
        });

        return root;
    }
}
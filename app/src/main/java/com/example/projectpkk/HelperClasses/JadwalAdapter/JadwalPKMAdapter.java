package com.example.projectpkk.HelperClasses.JadwalAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10PKMFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11PKMFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12PKMFragment;

public class JadwalPKMAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public JadwalPKMAdapter(FragmentManager fragmentManager, Context contextn, int totalTabs) {
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Jadwal10PKMFragment jadwal10PKMFragment = new Jadwal10PKMFragment();
                return jadwal10PKMFragment;
            case 1:
                Jadwal11PKMFragment jadwal11PKMFragment = new Jadwal11PKMFragment();
                return jadwal11PKMFragment;
            case 2:
                Jadwal12PKMFragment jadwal12PKMFragment = new Jadwal12PKMFragment();
                return jadwal12PKMFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

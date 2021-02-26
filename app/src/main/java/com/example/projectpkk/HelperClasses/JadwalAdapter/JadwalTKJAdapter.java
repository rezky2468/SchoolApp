package com.example.projectpkk.HelperClasses.JadwalAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10TKJFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11TKJFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12TKJFragment;

public class JadwalTKJAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public JadwalTKJAdapter(FragmentManager fragmentManager, Context context, int totalTabs) {
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Jadwal10TKJFragment jadwal10TKJFragment = new Jadwal10TKJFragment();
                return jadwal10TKJFragment;
            case 1:
                Jadwal11TKJFragment jadwal11TKJFragment = new Jadwal11TKJFragment();
                return jadwal11TKJFragment;
            case 2:
                Jadwal12TKJFragment jadwal12TKJFragment = new Jadwal12TKJFragment();
                return jadwal12TKJFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

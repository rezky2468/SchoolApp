package com.example.projectpkk.HelperClasses.JadwalAdapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpkk.JadwalRPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10RPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11RPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12RPLFragment;

public class JadwalRPLAdapter extends FragmentPagerAdapter {

    Context context;
    int totalTabs;

    public JadwalRPLAdapter(FragmentManager fragmentManager, Context context, int totalTabs) {
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Jadwal10RPLFragment jadwal10RPLFragment = new Jadwal10RPLFragment();
                return jadwal10RPLFragment;
            case 1:
                Jadwal11RPLFragment jadwal11RPLFragment = new Jadwal11RPLFragment();
                return jadwal11RPLFragment;
            case 2:
                Jadwal12RPLFragment jadwal12RPLFragment = new Jadwal12RPLFragment();
                return jadwal12RPLFragment;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}

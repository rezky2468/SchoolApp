package com.example.projectpkk.HelperClasses.JadwalAdapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10PKMFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10RPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal10TKJFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11PKMFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11RPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal11TKJFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12PKMFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12RPLFragment;
import com.example.projectpkk.User.BottomNavigationView.Menu3Jadwal.Tabs.Jadwal12TKJFragment;

public class JadwalAdapter extends FragmentPagerAdapter {

    private Context context;
    int totalTabs;

    public JadwalAdapter(FragmentManager fragmentManager, Context context, int totalTabs) {
        super(fragmentManager);
        this.context = context;
        this.totalTabs = totalTabs;
    }

    @Override
    public int getCount() {
        return totalTabs;
    }

    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Jadwal10RPLFragment jadwal10RPLFragment = new Jadwal10RPLFragment();
                return jadwal10RPLFragment;
            case 1:
                Jadwal10TKJFragment jadwal10TKJFragment = new Jadwal10TKJFragment();
                return jadwal10TKJFragment;
            case 2:
                Jadwal10PKMFragment jadwal10PKMFragment = new Jadwal10PKMFragment();
                return jadwal10PKMFragment;
            case 3:
                Jadwal11RPLFragment jadwal11RPLFragment = new Jadwal11RPLFragment();
                return jadwal11RPLFragment;
            case 4:
                Jadwal11TKJFragment jadwal11TKJFragment = new Jadwal11TKJFragment();
                return jadwal11TKJFragment;
            case 5:
                Jadwal11PKMFragment jadwal11PKMFragment = new Jadwal11PKMFragment();
                return jadwal11PKMFragment;
            case 6:
                Jadwal12RPLFragment jadwal12RPLFragment = new Jadwal12RPLFragment();
                return jadwal12RPLFragment;
            case 7:
                Jadwal12TKJFragment jadwal12TKJFragment = new Jadwal12TKJFragment();
                return jadwal12TKJFragment;
            case 8:
                Jadwal12PKMFragment jadwal12PKMFragment = new Jadwal12PKMFragment();
                return jadwal12PKMFragment;
            default:
                return null;
        }
    }

}

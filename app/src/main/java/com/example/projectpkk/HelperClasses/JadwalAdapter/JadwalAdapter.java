package com.example.projectpkk.HelperClasses.JadwalAdapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.projectpkk.JadwalPKMFragment;
import com.example.projectpkk.JadwalRPLFragment;
import com.example.projectpkk.JadwalTKJFragment;
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
                JadwalRPLFragment jadwalRPLFragment = new JadwalRPLFragment();
                return jadwalRPLFragment;
            case 1:
                JadwalTKJFragment jadwalTKJFragment = new JadwalTKJFragment();
                return jadwalTKJFragment;
            case 2:
                JadwalPKMFragment jadwalPKMFragment = new JadwalPKMFragment();
                return jadwalPKMFragment;
            default:
                return null;
        }
    }

}

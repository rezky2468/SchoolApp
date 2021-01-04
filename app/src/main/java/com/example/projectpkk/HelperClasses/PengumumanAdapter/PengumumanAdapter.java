package com.example.projectpkk.HelperClasses.PengumumanAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class PengumumanAdapter extends BaseAdapter {

    // Variables
    LayoutInflater layoutInflater;
    Context context;
    TextView titleTextView, dateTextView, descTextView;
    ArrayList<PengumumanHelperClass> arrayList;

    public PengumumanAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    String[] titles = {
            "Pengumuman 1",
            "Pengumuman 2",
            "Pengumuman 3",
            "Pengumuman 4",
            "Pengumuman 5",
            "Pengumuman 6",
            "Pengumuman 7",
            "Pengumuman 8",
            "Pengumuman 9",
            "Pengumuman 10"
    };

    String[] dates = {
            "31 Januari 2019",
            "31 Januari 2020",
            "31 Januari 2021",
            "31 Januari 2022",
            "31 Januari 2023",
            "31 Januari 2024",
            "31 Januari 2025",
            "31 Januari 2026",
            "31 Januari 2027",
            "31 Januari 2028"
    };

    String[] descriptions = {
            "Description 1 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 2 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 3 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 4 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 5 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 6 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 7 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 8 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 9 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet...",
            "Description 10 lorem ipsum dolor sit amet lorem ipsum dolor sit amet lorem ipsum dolor sit amet..."
    };

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.layout_list_view_pengumuman, parent, false);
        }

//        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = layoutInflater.inflate(R.layout.layout_list_view_pengumuman, null);

        titleTextView = convertView.findViewById(R.id.pengumuman_title);
        dateTextView = convertView.findViewById(R.id.pengumuman_date);
        descTextView = convertView.findViewById(R.id.pengumuman_desc);

//        String title = titles[position];
//        String date = dates[position];
//        String desc = descriptions[position];

        titleTextView.setText(arrayList.get(position).getJudul());
        dateTextView.setText(arrayList.get(position).getTanggal());
        descTextView.setText(arrayList.get(position).getIsi());

        return convertView;

    }

}

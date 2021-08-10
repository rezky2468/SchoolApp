package com.example.projectpkk.HelperClasses.GuruAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projectpkk.R;

import java.util.ArrayList;

public class GuruAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    Context context;
    TextView namaTextView, jabatanTextView, ttlTextView, pendidikanTextView, mapelTextView, emailTextView, telpTextView;
    de.hdodenhof.circleimageview.CircleImageView fotoCircleImageView;
    ArrayList<GuruHelperClass> arrayList;

    public GuruAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
//        this.pengajarArrayList = arrayList;
//        this.context = context;
//        this.arrayList = arrayList;
//        this.images = images;
//        this.names = names;
//        this.descriptions = descriptions;
    }

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

        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = mInflater.inflate(R.layout.layout_list_view_pengajar, null);

//        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = mInflater.inflate(R.layout.layout_list_view_pengajar, null);

        fotoCircleImageView = view.findViewById(R.id.pengajar_image);
        namaTextView = view.findViewById(R.id.pengajar_name);
        mapelTextView = view.findViewById(R.id.pengajar_mapel);

//        int id = context.getResources().getIdentifier(arrayList.get(position).getGambar(), "drawable", context.getPackageName());

//        fotoCircleImageView.setImageResource(image);
//        fotoCircleImageView.setImageResource(id);
        namaTextView.setText(arrayList.get(position).getName());
        mapelTextView.setText(arrayList.get(position).getMapel());

        return view;
    }


}

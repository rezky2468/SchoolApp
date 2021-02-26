package com.example.projectpkk.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    LayoutInflater layoutInflater;
    Context context;
    TextView nameTextView, dateTextView, descriptionTextView;
    ArrayList<ListViewHelperClass> arrayList;

    public ListViewAdapter(Context context, ArrayList arrayList) {
        this.context = context;
        this.arrayList = arrayList;
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

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.listview_example, null);

        nameTextView = view.findViewById(R.id.txt_name);
        dateTextView = view.findViewById(R.id.txt_date);
        descriptionTextView = view.findViewById(R.id.txt_description);

        nameTextView.setText(arrayList.get(position).getName());
        dateTextView.setText(arrayList.get(position).getDate());
        descriptionTextView.setText(arrayList.get(position).getDescription());

        return view;

    }

}

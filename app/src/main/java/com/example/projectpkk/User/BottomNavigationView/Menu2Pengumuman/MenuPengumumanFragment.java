package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanHelperClass;
import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanAdapter;
import com.example.projectpkk.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MenuPengumumanFragment extends Fragment {

    // Variables
    ListView pengumumanListView;
    ArrayList<PengumumanHelperClass> arrayList;
    ImageView addNewPengumuman;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_pengumuman, container, false);

        pengumumanListView = view.findViewById(R.id.pengumuman_list_view);
//        addNewPengumuman = view.findViewById(R.id.pengumuman_add);
        arrayList = new ArrayList<>();

//        addNewPengumuman.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getContext(), AddNewPengumuman.class));
//            }
//        });

        PengumumanAdapter pengumumanAdapter = new PengumumanAdapter(getContext(), arrayList);

        try {
            JSONObject jsonObject = new JSONObject(readPengumumanJSON());
            JSONArray jsonArray = jsonObject.getJSONArray("pengumuman");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject _jsonObject = jsonArray.getJSONObject(i);

                final String judulValue = _jsonObject.getString("judul");
                final String tanggalValue = _jsonObject.getString("tanggal");
                final String isiValue = _jsonObject.getString("isi");

                PengumumanHelperClass pengumumanHelperClass = new PengumumanHelperClass();
                pengumumanHelperClass.setJudul(judulValue);
                pengumumanHelperClass.setTanggal(tanggalValue);
                pengumumanHelperClass.setIsi(isiValue);
                arrayList.add(0, pengumumanHelperClass);
                pengumumanAdapter.notifyDataSetChanged();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        pengumumanListView.post(new Runnable() {
            @Override
            public void run() {
                pengumumanListView.smoothScrollToPosition(0);
            }
        });

        pengumumanListView.setAdapter(pengumumanAdapter);
        pengumumanListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(getContext(), PengumumanDetailActivity.class);
                intent.putExtra("com.example.projectpkk.ITEM_INDEX", position);
                startActivity(intent);

            }
        });

        return view;
    }

    public String readPengumumanJSON() {
        String json = null;
        try {
            InputStream inputStream = getActivity().getAssets().open("pengumuman.json");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return json;
    }

}
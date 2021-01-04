package com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.projectpkk.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class PengumumanDetailActivity extends AppCompatActivity {

    // Variables
    TextView pengumumanDetailTitle, pengumumanDetailDate, pengumumanDetailDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_pengumuman_detail);

        // Hooks
        pengumumanDetailTitle = findViewById(R.id.pengumuman_detail_title);
        pengumumanDetailDate = findViewById(R.id.pengumuman_detail_date);
        pengumumanDetailDesc = findViewById(R.id.pengumuman_detail_desc);

        int index = getIntent().getIntExtra("com.example.projectpkk.ITEM_INDEX", -1);

        try {
            JSONObject jsonObject = new JSONObject(loadPengumumanJSONFromAsset());
            JSONArray jsonArray = jsonObject.getJSONArray("pengumuman");
            JSONObject _jsonObject = jsonArray.getJSONObject(index);

            final String judulValue = _jsonObject.getString("judul");
            final String tanggalValue = _jsonObject.getString("tanggal");
            final String isiValue = _jsonObject.getString("isi");

            Bundle bundle = new Bundle();
            bundle.putString("judul", judulValue);
            bundle.putString("tanggal", tanggalValue);
            bundle.putString("isi", isiValue);

            if (index > -1) {
                pengumumanDetailTitle.setText(judulValue);
                pengumumanDetailDate.setText(tanggalValue);
                pengumumanDetailDesc.setText(isiValue);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public String loadPengumumanJSONFromAsset() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("pengumuman.json");
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
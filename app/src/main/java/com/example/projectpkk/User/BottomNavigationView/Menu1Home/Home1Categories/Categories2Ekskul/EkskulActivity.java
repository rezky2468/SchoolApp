package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories2Ekskul;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.HelperClasses.HomeAdapter.Ekskul.EkskulAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.Ekskul.EkskulHelperClass;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class EkskulActivity extends AppCompatActivity {

    RecyclerView ekskulRecycler;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_ekskul);

        ekskulRecycler = findViewById(R.id.ekskul_recycler);

        ekskulRecycler();

    }

    public void ekskulRecycler() {
        ekskulRecycler.setHasFixedSize(true);
        ekskulRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<EkskulHelperClass> ekskulLocations = new ArrayList<>();
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
        ekskulLocations.add(new EkskulHelperClass("Futsal", R.drawable.img1));
//        ekskulLocations.add(new EventHelperClass("Voli", R.drawable.ekskul_voli));
//        ekskulLocations.add(new EventHelperClass("Pramuka", R.drawable.ekskul_pramuka));
//        ekskulLocations.add(new EventHelperClass("PMR", R.drawable.ekskul_pmr));
//        ekskulLocations.add(new EventHelperClass("Andro IT", R.drawable.ekskul_androit));
//        ekskulLocations.add(new EventHelperClass("Paduan Suara", R.drawable.ekskul_paduan_suara));

        adapter = new EkskulAdapter(ekskulLocations);
        ekskulRecycler.setAdapter(adapter);

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }


}
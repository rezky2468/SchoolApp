package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories3Event;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.projectpkk.Common.SearchActivity;
import com.example.projectpkk.HelperClasses.HomeAdapter.Event.EventAdapter;
import com.example.projectpkk.HelperClasses.HomeAdapter.Event.EventHelperClass;
import com.example.projectpkk.R;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    RecyclerView eventRecycler;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_event);

        eventRecycler = findViewById(R.id.event_recycler);

        eventRecycler();

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public void callSearchScreen(View view) {
        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
    }

    public void eventRecycler() {
        eventRecycler.setHasFixedSize(true);
        eventRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));

        ArrayList<EventHelperClass> eventLocations = new ArrayList<>();
        eventLocations.add(new EventHelperClass("Bulbas", R.drawable.img1));
        eventLocations.add(new EventHelperClass("Porak", R.drawable.img1));
        eventLocations.add(new EventHelperClass("Pensi", R.drawable.img1));
        eventLocations.add(new EventHelperClass("Port-IT", R.drawable.img1));
        eventLocations.add(new EventHelperClass("LDKS", R.drawable.img1));
        eventLocations.add(new EventHelperClass("17 Agustus", R.drawable.img1));

        adapter = new EventAdapter(eventLocations);
        eventRecycler.setAdapter(adapter);

    }

}
package com.example.projectpkk.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.projectpkk.HelperClasses.PengumumanAdapter.PengumumanAdapter;
import com.example.projectpkk.R;
import com.example.projectpkk.User.BottomNavigationView.Menu2Pengumuman.PengumumanDetailActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.list_example);
        final ArrayList<ListViewHelperClass> arrayList = new ArrayList<>();
        final ListViewAdapter listViewAdapter = new ListViewAdapter(getApplicationContext(), arrayList);

        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        Query query = FirebaseDatabase.getInstance().getReference().child("list-view");
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (int i = 0; i < 2; i++) {

                    ListViewHelperClass listViewHelperClass = new ListViewHelperClass();

                    String name = dataSnapshot.child(String.valueOf(i)).child("name").getValue(String.class);
                    String date = dataSnapshot.child(String.valueOf(i)).child("date").getValue(String.class);
                    String description = dataSnapshot.child(String.valueOf(i)).child("description").getValue(String.class);

                    listViewHelperClass.setName(name);
                    listViewHelperClass.setDate(date);
                    listViewHelperClass.setDescription(description);
                    arrayList.add(listViewHelperClass);
                }
                listViewAdapter.notifyDataSetChanged();
                listView.setAdapter(listViewAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                Intent intent = new Intent(getApplicationContext(), PengumumanDetailActivity.class);
//                intent.putExtra("index", position);
//                startActivity(intent);

            }
        });

    }
}
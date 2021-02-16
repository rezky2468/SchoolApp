package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectpkk.Common.LoginSignUp.LoginActivity;
import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.firebase.FirebaseError;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.makeramen.roundedimageview.RoundedImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class GuruDetailBottomSheet extends BottomSheetDialogFragment {

//    private BottomSheetListener mListener;

    TextView nama, jabatan, ttl, pendidikan, mapel, email, telp;
    Button btnEmailGuru, btnTelpGuru;
    com.makeramen.roundedimageview.RoundedImageView foto;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_bottom_sheet, container, false);

        // Hooks
        nama = view.findViewById(R.id.data_guru_nama);
        jabatan = view.findViewById(R.id.data_guru_jabatan);
        ttl = view.findViewById(R.id.data_guru_tanggal_lahir);
        pendidikan = view.findViewById(R.id.data_guru_pendidikan);
        mapel = view.findViewById(R.id.data_guru_mapel);
        email = view.findViewById(R.id.data_guru_email);
        telp = view.findViewById(R.id.data_guru_telp);
        foto = view.findViewById(R.id.data_guru_foto);

        btnEmailGuru = view.findViewById(R.id.btn_email_guru);
        btnTelpGuru = view.findViewById(R.id.btntelpguru);

//        final int _id = getArguments().getInt("dataId");
        String dataNama = getArguments().getString("dataNama");
        String dataJabatan = getArguments().getString("dataJabatan");
        String dataTtl = getArguments().getString("dataTtl");
        String dataPendidikan = getArguments().getString("dataPendidikan");
        String dataMapel = getArguments().getString("dataMapel");
        final String dataEmail = getArguments().getString("dataEmail");
        final String dataTelp = getArguments().getString("dataTelp");
        int dataFoto = getArguments().getInt("dataFoto");
//        Serializable dataFoto = getArguments().getSerializable("dataFoto");

//        int foto = dataFoto.get

        nama.setText(dataNama);
        jabatan.setText(dataJabatan);
        ttl.setText(dataTtl);
        pendidikan.setText(dataPendidikan);
        mapel.setText(dataMapel);
        email.setText(dataEmail);
        telp.setText(dataTelp);
        foto.setImageResource(dataFoto);

//        Button button1 = view.findViewById(R.id.buttonShare);
//        Button button2 = view.findViewById(R.id.button2);
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                mListener.onButtonClicked();
//                dismiss();
//                startActivity(new Intent(getContext(), JadwalMengajarGuru.class));
//            }
//        });
        btnEmailGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", dataEmail, null));
                getContext().startActivity(Intent.createChooser(intent, null));
//                intent.setType("plain/text");
//                intent.setData(Uri.parse("test@gmail.com"));
//                intent.setClassName("com.google.android.gm", "com.google.android.gm.ConversationListActivity");
//                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"test@gmail.com"});
//                intent.putExtra(Intent.EXTRA_SUBJECT, "test");
//                intent.putExtra(Intent.EXTRA_TEXT, "this is a text of an email");
//                startActivity(intent);
            }
        });

        btnTelpGuru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = dataTelp;
                String url = "https://api.whatsapp.com/send?phone=" + number;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });

//        FirebaseDatabase.getInstance().setPersistenceEnabled(true);
//        DatabaseReference scoresRef = FirebaseDatabase.getInstance().getReference("guru");
//        scoresRef.keepSynced(true);
//        Query myGuru = FirebaseDatabase.getInstance().getReference("guru");
//        myGuru.keepSynced(true);

//        scoresRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
////                for (DataSnapshot snap: dataSnapshot.getChildren()) {
////                    Toast.makeText(getActivity(), snap.getKey(), Toast.LENGTH_SHORT).show();
////                    Log.e(snap.getKey(),snap.getChildrenCount() + "");
//
//
//                    String _nama = dataSnapshot.child(String.valueOf(dataSnapshot.getKey())).child("nama").getValue(String.class);
//                    String _jabatan = dataSnapshot.child(String.valueOf(dataSnapshot.getKey())).child("jabatan").getValue(String.class);
//                    String _ttl = dataSnapshot.child(String.valueOf(dataSnapshot.getKey())).child("ttl").getValue(String.class);
//                    String _pendidikan = dataSnapshot.child(String.valueOf(dataSnapshot.getKey())).child("pendidikan").getValue(String.class);
//                    String _mapel = dataSnapshot.child(String.valueOf(dataSnapshot.getKey())).child("mapel").getValue(String.class);
////                    String _email = dataSnapshot.child(_id).child("email").getValue(String.class);
////                    String _telp = dataSnapshot.child(_id).child("telp").getValue(String.class);
//
//                    nama.setText(_nama);
//                    jabatan.setText(_jabatan);
//                    ttl.setText(_ttl);
//                    pendidikan.setText(_pendidikan);
//                    mapel.setText(_mapel);
//
////                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });



//        Query checkUser = FirebaseDatabase.getInstance().getReference("guru").orderByChild("phoneNo").equalTo(_completePhoneNumber);
//
//        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if (dataSnapshot.exists()) {
//                    phoneNumber.setError(null);
//                    phoneNumber.setErrorEnabled(false);
//
//                    String systemPassword = dataSnapshot.child(_completePhoneNumber).child("password").getValue(String.class);
//                    if (systemPassword.equals(_password)) {
//                        phoneNumber.setError(null);
//                        phoneNumber.setErrorEnabled(false);
//
//                        String _fullName = dataSnapshot.child(_completePhoneNumber).child("fullName").getValue(String.class);
//                        String _username = dataSnapshot.child(_completePhoneNumber).child("username").getValue(String.class);
//                        String _email = dataSnapshot.child(_completePhoneNumber).child("email").getValue(String.class);
//                        String _gender = dataSnapshot.child(_completePhoneNumber).child("gender").getValue(String.class);
//                        String _date = dataSnapshot.child(_completePhoneNumber).child("date").getValue(String.class);
//                        String _phoneNo = dataSnapshot.child(_completePhoneNumber).child("phoneNo").getValue(String.class);
//                        String _password = dataSnapshot.child(_completePhoneNumber).child("password").getValue(String.class);
//
//                        // Create a Session
//                        SessionManager sessionManager = new SessionManager(LoginActivity.this);
//                        sessionManager.createLoginSession(_fullName, _username, _email, _phoneNo, _password, _date, _gender);
//
//                        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
//
////                        Toast.makeText(LoginActivity.this, _fullName + "\n" + _email + "\n" + _phoneNo + "\n" + _date, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(LoginActivity.this, "Anda berhasil login!", Toast.LENGTH_SHORT).show();
//                        progressBar.setVisibility(View.GONE);
//
//                    } else {
//                        progressBar.setVisibility(View.GONE);
//                        Toast.makeText(LoginActivity.this, "Kata sandi salah", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    progressBar.setVisibility(View.GONE);
//                    Toast.makeText(LoginActivity.this, "Tidak ada pengguna yang cocok", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//                progressBar.setVisibility(View.GONE);
//                Toast.makeText(LoginActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
        return view;
    }


//    @Override
//    public void onListClicked(String nama, String jabatan, String ttl, String pendidikan, String mapel, String email, String telp) {
//        this.nama.setText(nama);
//        this.jabatan.setText(jabatan);
//        this.ttl.setText(ttl);
//        this.pendidikan.setText(pendidikan);
//        this.mapel.setText(mapel);
//        this.email.setText(email);
//        this.telp.setText(telp);
//    }
////
//    public interface BottomSheetListener {
//        void onButtonClicked();
//    }
//
//
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        try {
//            mListener = (BottomSheetListener) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement BottomSheetListener");
//        }
//
//    }
}

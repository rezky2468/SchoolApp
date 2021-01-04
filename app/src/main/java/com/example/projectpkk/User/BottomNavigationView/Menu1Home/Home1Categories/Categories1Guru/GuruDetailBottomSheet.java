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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectpkk.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.makeramen.roundedimageview.RoundedImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

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

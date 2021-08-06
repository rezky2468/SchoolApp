package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.projectpkk.Parcelable.Guru;
import com.example.projectpkk.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

//import com.example.projectpkk.contoh;

public class GuruDetailBottomSheet extends BottomSheetDialogFragment {

//    private BottomSheetListener mListener;

    TextView nama, jenis_kelamin, jabatan, tempat_tanggal_lahir, pendidikan, mapel, email, telp;
    Button btnEmailGuru, btnTelpGuru;
    com.makeramen.roundedimageview.RoundedImageView foto;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.layout_bottom_sheet, container, false);

        // Hooks
        nama = view.findViewById(R.id.data_guru_nama);
        jenis_kelamin = view.findViewById(R.id.data_guru_jenis_kelamin);
        jabatan = view.findViewById(R.id.data_guru_jabatan);
        tempat_tanggal_lahir = view.findViewById(R.id.data_guru_tempat_tanggal_lahir);
        pendidikan = view.findViewById(R.id.data_guru_pendidikan);
        mapel = view.findViewById(R.id.data_guru_mapel);
        email = view.findViewById(R.id.data_guru_email);
        telp = view.findViewById(R.id.data_guru_telp);
        foto = view.findViewById(R.id.data_guru_foto);

        btnEmailGuru = view.findViewById(R.id.btn_email_guru);
        btnTelpGuru = view.findViewById(R.id.btntelpguru);


        Guru guruDiterima;
//        Guru guruDiterima = getActivity().getIntent().getParcelableExtra("GURU");

        Bundle bundle = this.getArguments();
        if (bundle != null) {


            guruDiterima = bundle.getParcelable("GURU");

            //        String dataNip = guruDiterima.getUsername();
            String dataNama = guruDiterima.getNama();
            String dataJenisKelamin = guruDiterima.getJenis_kelamin();
            String dataUsername = guruDiterima.getUsername();
            String dataPassword = guruDiterima.getPassword();
            String dataJabatan = guruDiterima.getJabatan();
            final String dataMapel = guruDiterima.getMapel();
            String dataPendidikan = guruDiterima.getPendidikan();
            String dataTempatLahir = guruDiterima.getTempat_lahir();
            String dataTanggalLahir = guruDiterima.getTanggal_lahir();
            final String dataEmail = guruDiterima.getEmail();
            final String dataNoTelp = guruDiterima.getNo_telp();
            String dataGambar = guruDiterima.getGambar();
            String dataLevel = guruDiterima.getLevel();
            String dataTtl = dataTempatLahir + ", " + dataTanggalLahir;

            nama.setText(dataNama);
            jenis_kelamin.setText(dataJenisKelamin);
            jabatan.setText(dataJabatan);
            tempat_tanggal_lahir.setText(dataTtl);
            pendidikan.setText(dataPendidikan);
            mapel.setText(dataMapel);
            email.setText(dataEmail);
            telp.setText(dataNoTelp);
            int id = getActivity().getResources().getIdentifier(dataGambar, "drawable", getActivity().getPackageName());
            foto.setImageResource(id);


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
                    String number = dataNoTelp;
                    String url = "https://api.whatsapp.com/send?phone=" + number;
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            });

        }


//        final int _id = getArguments().getInt("dataId");
//        String dataNama = getArguments().getString("dataNama");
//        String dataJabatan = getArguments().getString("dataJabatan");
//        String dataTtl = getArguments().getString("dataTtl");
//        String dataPendidikan = getArguments().getString("dataPendidikan");
//        String dataMapel = getArguments().getString("dataMapel");
//        final String dataEmail = getArguments().getString("dataEmail");
//        final String dataTelp = getArguments().getString("dataTelp");
//        int dataFoto = getArguments().getInt("dataFoto");
//        Serializable dataFoto = getArguments().getSerializable("dataFoto");

//        int foto = dataFoto.get


//        nama.setText(dataNama);
//        jabatan.setText(dataJabatan);
//        ttl.setText(dataTanggalLahir);
//        pendidikan.setText(dataPendidikan);
//        mapel.setText(dataMapel);
//        email.setText(dataEmail);
//        telp.setText(dataNoTelp);
//        foto.setImageResource(dataGambar);

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


        return view;
    }

}

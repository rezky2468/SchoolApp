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

    int[] images = {
            R.drawable.guru_anton,
            R.drawable.guru_asep_d_y,
            R.drawable.guru_wahyu,
            R.drawable.guru_teli,
            R.drawable.guru_sigid,
            R.drawable.guru_indra,
            R.drawable.guru_devi,
            R.drawable.guru_abin,
            R.drawable.guru_iis,
            R.drawable.guru_asep_y,
            R.drawable.guru_egi,
            R.drawable.no_photo,
            R.drawable.guru_mega,
            R.drawable.guru_nurwita,
            R.drawable.no_photo,
            R.drawable.guru_rina,
            R.drawable.guru_wahyudi,
            R.drawable.guru_liku,
            R.drawable.guru_indira,
            R.drawable.guru_fitria,
            R.drawable.no_photo,
            R.drawable.guru_pravita,
            R.drawable.guru_eka,
            R.drawable.guru_irma,
            R.drawable.guru_rini,
            R.drawable.guru_isma,
            R.drawable.guru_ai,
            R.drawable.guru_yogie,
            R.drawable.guru_odih,
            R.drawable.guru_fajar,
            R.drawable.guru_nirwan,
            R.drawable.guru_neni,
            R.drawable.guru_kiki,
            R.drawable.guru_lisda,
            R.drawable.guru_hani,
            R.drawable.guru_m_sobar,
            R.drawable.guru_sinta,
            R.drawable.guru_andiyanto,
            R.drawable.guru_guruh,
            R.drawable.guru_handi,
            R.drawable.guru_uman
    };

    String[] names = {
            "Anton Jaenudin, Sp.D",
            "Asep Dimyati Yusup, St",
            "Wahyu Taufix, S.Pd",
            "Teli Mardiani, S.Pd",
            "Sigid Purwanto, S.Pd",
            "Indra Setia Nugraha, St",
            "Devi Adriani, S.Pd",
            "Drs. Abin Saepudin",
            "Iis Robiah, S.Ag",
            "Asep Yusup Hambara Sukendar, S.Sn",
            "Egi Dodi Gunadi, St",
            "Ence Kamil, S.Si",
            "Mega Merliana, S.Ds, S.Kom",
            "Nurwita, S.Pd",
            "Iwan Setiawan, S.Sos.i, S.Kom",
            "Rina Erwina, St",
            "Wahyudi, S.Pd",
            "Liku Vici Indriani, Se",
            "Indira Soviaty Ganiwa Putri, S.Si",
            "Fitria Yuliana Damayanti, S.Pd",
            "Irpan Nurapandi, S.Kom",
            "Pravita Devi Amalia, S.Pd",
            "Eka Mardiana, S.Pd",
            "Irma Sumarni, S.Pd",
            "Rini Shoffa Aulia, S.Pd",
            "Isma Purnamasari, S.Pd",
            "Ai Rodiah, S.Pd.i",
            "Yogie Prandi Wargina, S.Tr.Kom",
            "Odih Syarifudin, S.Ps.I",
            "Fajar Oktavian Nugraha, S.Pd",
            "Nirwan Setia Dharmadi, S.Pd, M.M.Pd",
            "Neni Rosmayani, S.S",
            "Kiki Padila, S.Pd",
            "Lisda Nurhayati, S.Pd",
            "Hani Kusyanti Kusnadi, S.Pd",
            "M. Sobar, St",
            "Sinta Hodliah, S.Pd",
            "Andiyanto, S.Kom",
            "Guruh Panji Alam, S.Kom",
            "Handi Mulyadi, S.Pd",
            "Uman Priatna, S.Pd.I"
    };

    String[] descriptions = {
            "Fisika",
            "Produktif RPL",
            "Matematika",
            "Bahasa Inggris",
            "Produktif TIK",
            "Produktif TKJ",
            "Produktif Perbankan",
            "PKN",
            "PABP",
            "Seni Budaya",
            "Produktif TKJ",
            "PJOK",
            "Produktif RPL",
            "Bahasa Inggris",
            "Produktif TKJ",
            "Produktif RPL",
            "Matematika",
            "Produktif Perbankan",
            "Ilmu Pengetahuan Alam",
            "Bahasa Indonesia",
            "Produktif TIK",
            "Bahasa Inggris",
            "Matematika",
            "PKN",
            "Fisika",
            "PJOK",
            "PABP",
            "Produktif TKJ",
            "BP/BK",
            "Produktif TIK",
            "Sejarah Indonesia",
            "Bahasa Jepang",
            "Bahasa Sunda",
            "Bahasa Indonesia",
            "Produktif Perbankan",
            "Produktif TKJ",
            "Kimia",
            "Produktif TKJ",
            "Produktif TKJ",
            "BP/BK",
            "Murotal Al-Quran"
    };

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

        int image = images[position];

        fotoCircleImageView.setImageResource(image);
        namaTextView.setText(arrayList.get(position).getNama());
        mapelTextView.setText(arrayList.get(position).getMapel());

        return view;
    }


}

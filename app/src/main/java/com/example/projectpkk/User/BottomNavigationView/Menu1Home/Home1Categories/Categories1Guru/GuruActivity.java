package com.example.projectpkk.User.BottomNavigationView.Menu1Home.Home1Categories.Categories1Guru;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.projectpkk.HelperClasses.PengajarAdapter.PengajarAdapter;
import com.example.projectpkk.HelperClasses.PengajarAdapter.PengajarHelperClass;
import com.example.projectpkk.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class GuruActivity extends AppCompatActivity {

    private TextView mTextView;
    ListView myListView;
    String[] names, descriptions;
    ArrayList<PengajarHelperClass> pengajarArrayList;
    int[] fotos = {
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

//    ListClicked listClicked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_categories_guru);

//        Resources resources = getResources();
        myListView = findViewById(R.id.pengajar_list_view);
//        mTextView = findViewById(R.id.text_view_button_clicked);
//        pengajarArrayList = new ArrayList<>();
//        images = resources.getStringArray(R.array.images);
//        names = resources.getStringArray(R.array.names);
//        descriptions = resources.getStringArray(R.array.descriptions);


        PengajarAdapter pengajarAdapter = new PengajarAdapter(this);

//        try {
//            JSONObject jsonObject = new JSONObject(readPengajarJSON());
//            JSONArray jsonArray = jsonObject.getJSONArray("guru");
////            Context context = null;
////            Resources resources = getResources();
//
//            for (int i = 0; i < jsonArray.length(); i++) {
//
//                JSONObject _jsonObject = jsonArray.getJSONObject(i);
//
//                final String namaValue = _jsonObject.getString("nama");
//                final String mapelValue = _jsonObject.getString("mapel");
////                final String fotoValue = _jsonObject.getString("foto");
//
////                final int resourceId = resources.getIdentifier(fotoValue,"drawable", context.getPackageName());
//
////                Drawable drawable = resources.getDrawable(resourceId);
//
////                Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);
//
//                PengajarHelperClass pengajarHelperClass = new PengajarHelperClass();
//                pengajarHelperClass.setNama(namaValue);
//                pengajarHelperClass.setMapel(mapelValue);
////                pengajarHelperClass.setFoto(R.drawable.add_missing_place);
//                pengajarArrayList.add(pengajarHelperClass);
//
//            }

//        } catch (JSONException e) {
//            e.printStackTrace();
//        }


        myListView.setAdapter(pengajarAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

//                startActivity(new Intent(getApplicationContext(), DataGuru.class));

                try {
//                    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();

//                    List<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
                    JSONObject jsonObject = new JSONObject(readPengajarJSON());
                    JSONArray jsonArray = jsonObject.getJSONArray("guru");
//                    Context context = null;
//                    Resources resources = context.getResources();

//                    for (int i = 0; i < jsonArray.length(); i++) {

//                        HashMap<String, String> hm = new HashMap<String,String>();
//                        hm.put("txt", "Country : " + countries[i]);
//                        hm.put("cur","Currency : " + currency[i]);

                    JSONObject _jsonObject = jsonArray.getJSONObject(position);
//                            Log.d("Details-->", _jsonObject.getString("nama"));
                    final String namaValue = _jsonObject.getString("nama");
                    final String jabatanValue = _jsonObject.getString("jabatan");
                    final String ttlValue = _jsonObject.getString("ttl");
                    final String pendidikanValue = _jsonObject.getString("pendidikan");
                    final String mapelValue = _jsonObject.getString("mapel");
                    final String emailValue = _jsonObject.getString("email");
                    final String telpValue = _jsonObject.getString("telp");
//                    final String fotoValue = _jsonObject.getString("foto");

//                        final int resourceId = resources.getIdentifier(fotoValue, "drawable", context.getPackageName());

                    // get drawable by resource id
//                        Drawable drawable = resources.getDrawable(resourceId);

                    // get bitmap by resource id
//                        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), resourceId);

//                        hm.put("flag", Integer.toString(resourceId) );
//                        list.add(hm);

//                        int foto = fotos[position];

                    Bundle bundle = new Bundle();
                    bundle.putString("dataNama", namaValue);
                    bundle.putString("dataJabatan", jabatanValue);
                    bundle.putString("dataTtl", ttlValue);
                    bundle.putString("dataPendidikan", pendidikanValue);
                    bundle.putString("dataMapel", mapelValue);
                    bundle.putString("dataEmail", emailValue);
                    bundle.putString("dataTelp", telpValue);
                    bundle.putInt("dataFoto", fotos[position]);
//                        bundle.putSerializable("dataFoto", hm);
                    GuruDetailBottomSheet bottomSheetDialog = new GuruDetailBottomSheet();
                    bottomSheetDialog.setArguments(bundle);
                    bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
//                    }

//                    HashMap<String, String> hashMap = new HashMap<String, String>(position);


//                    hashMap.put("flag", Integer.toString(resourceId));


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });


    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

    public void callSearchScreen(View view) {
//        startActivity(new Intent(getApplicationContext(), Search.class));
//        ExampleBottomSheetDialog bottomSheetDialog = new ExampleBottomSheetDialog();
//        bottomSheetDialog.setArguments(bundle);
//        bottomSheetDialog.show(getSupportFragmentManager(), "exampleBottomSheet");
    }


    public String readPengajarJSON() {
        String json = null;
        try {
            InputStream inputStream = getAssets().open("guru.json");
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


//    public interface ListClicked {
//        void onListClicked(String nama, String jabatan, String ttl, String pendidikan, String mapel, String email, String telp);
//    }
//
//        @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//
//        try {
//            listClicked = (ListClicked) context;
//        } catch (ClassCastException e) {
//            throw new ClassCastException(context.toString()
//                    + " must implement BottomSheetListener");
//        }
//
//    }
//
//    @Override
//    public void onButtonClicked() {
////        mTextView.setText(text);
//    }

}
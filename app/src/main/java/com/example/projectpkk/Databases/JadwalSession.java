package com.example.projectpkk.Databases;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class JadwalSession {

    public static final String KEY_SENIN_MAPEL1 = "seninMapel1";
    public static final String KEY_SENIN_MAPEL2 = "seninMapel2";
    public static final String KEY_SENIN_MAPEL3 = "seninMapel3";

//    private static final String IS_LOGIN = "IsLoggedIn";
    public static final String KEY_SENIN_JAM1 = "seninJam1";
    public static final String KEY_SENIN_JAM2 = "seninJam2";
    public static final String KEY_SENIN_JAM3 = "seninJam3";
    public static final String KEY_SELASA_MAPEL1 = "selasaMapel1";
    public static final String KEY_SELASA_MAPEL2 = "selasaMapel2";
    public static final String KEY_SELASA_MAPEL3 = "selasaMapel3";
    public static final String KEY_SELASA_JAM1 = "selasaJam1";
    public static final String KEY_SELASA_JAM2 = "selasaJam2";
    public static final String KEY_SELASA_JAM3 = "selasaJam3";
    public static final String KEY_RABU_MAPEL1 = "rabuMapel1";
    public static final String KEY_RABU_MAPEL2 = "rabuMapel2";
    public static final String KEY_RABU_MAPEL3 = "rabuMapel3";
    public static final String KEY_RABU_JAM1 = "rabuJam1";
    public static final String KEY_RABU_JAM2 = "rabuJam2";
    public static final String KEY_RABU_JAM3 = "rabuJam3";
    public static final String KEY_KAMIS_MAPEL1 = "kamisMapel1";
    public static final String KEY_KAMIS_MAPEL2 = "kamisMapel2";
    public static final String KEY_KAMIS_MAPEL3 = "kamisMapel3";
    public static final String KEY_KAMIS_JAM1 = "kamisJam1";
    public static final String KEY_KAMIS_JAM2 = "kamisJam2";
    public static final String KEY_KAMIS_JAM3 = "kamisJam3";
    public static final String KEY_JUMAT_MAPEL1 = "jumatMapel1";
    public static final String KEY_JUMAT_MAPEL2 = "jumatMapel2";
    public static final String KEY_JUMAT_MAPEL3 = "jumatMapel3";
    public static final String KEY_JUMAT_JAM1 = "jumatJam1";
    public static final String KEY_JUMAT_JAM2 = "jumatJam2";
    public static final String KEY_JUMAT_JAM3 = "jumatJam3";
    public static final String KEY_SABTU_MAPEL1 = "kamisMapel1";
    public static final String KEY_SABTU_MAPEL2 = "kamisMapel2";
    public static final String KEY_SABTU_MAPEL3 = "kamisMapel3";
    public static final String KEY_SABTU_JAM1 = "kamisJam1";
    public static final String KEY_SABTU_JAM2 = "kamisJam2";
    public static final String KEY_SABTU_JAM3 = "kamisJam3";
    // Variables
    SharedPreferences jadwalSessions;
    SharedPreferences.Editor editor;
    Context context;


    public JadwalSession(Context _context) {
        context = _context;
        jadwalSessions = _context.getSharedPreferences("jadwalSessions", Context.MODE_PRIVATE);
        editor = jadwalSessions.edit();
    }

    public void createJadwalSeninSession(
            String seninMapel1, String seninMapel2, String seninMapel3, String seninJam1, String seninJam2, String seninJam3,
            String selasaMapel1, String selasaMapel2, String selasaMapel3, String selasaJam1, String selasaJam2, String selasaJam3,
            String rabuMapel1, String rabuMapel2, String rabuMapel3, String rabuJam1, String rabuJam2, String rabuJam3,
            String kamisMapel1, String kamisMapel2, String kamisMapel3, String kamisJam1, String kamisJam2, String kamisJam3,
            String jumatMapel1, String jumatMapel2, String jumatMapel3, String jumatJam1, String jumatJam2, String jumatJam3,
            String sabtuMapel1, String sabtuMapel2, String sabtuMapel3, String sabtuJam1, String sabtuJam2, String sabtuJam3) {

//        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_SENIN_MAPEL1, seninMapel1);
        editor.putString(KEY_SENIN_MAPEL2, seninMapel2);
        editor.putString(KEY_SENIN_MAPEL3, seninMapel3);
        editor.putString(KEY_SENIN_JAM1, seninJam1);
        editor.putString(KEY_SENIN_JAM2, seninJam2);
        editor.putString(KEY_SENIN_JAM3, seninJam3);

        editor.putString(KEY_SELASA_MAPEL1, selasaMapel1);
        editor.putString(KEY_SELASA_MAPEL2, selasaMapel2);
        editor.putString(KEY_SELASA_MAPEL3, selasaMapel3);
        editor.putString(KEY_SELASA_JAM1, selasaJam1);
        editor.putString(KEY_SELASA_JAM2, selasaJam2);
        editor.putString(KEY_SELASA_JAM3, selasaJam3);

        editor.putString(KEY_RABU_MAPEL1, rabuMapel1);
        editor.putString(KEY_RABU_MAPEL2, rabuMapel2);
        editor.putString(KEY_RABU_MAPEL3, rabuMapel3);
        editor.putString(KEY_RABU_JAM1, rabuJam1);
        editor.putString(KEY_RABU_JAM2, rabuJam2);
        editor.putString(KEY_RABU_JAM3, rabuJam3);

        editor.putString(KEY_KAMIS_MAPEL1, kamisMapel1);
        editor.putString(KEY_KAMIS_MAPEL2, kamisMapel2);
        editor.putString(KEY_KAMIS_MAPEL3, kamisMapel3);
        editor.putString(KEY_KAMIS_JAM1, kamisJam1);
        editor.putString(KEY_KAMIS_JAM2, kamisJam2);
        editor.putString(KEY_KAMIS_JAM3, kamisJam3);

        editor.putString(KEY_JUMAT_MAPEL1, jumatMapel1);
        editor.putString(KEY_JUMAT_MAPEL2, jumatMapel2);
        editor.putString(KEY_JUMAT_MAPEL3, jumatMapel3);
        editor.putString(KEY_JUMAT_JAM1, jumatJam1);
        editor.putString(KEY_JUMAT_JAM2, jumatJam2);
        editor.putString(KEY_JUMAT_JAM3, jumatJam3);

        editor.putString(KEY_SABTU_MAPEL1, sabtuMapel1);
        editor.putString(KEY_SABTU_MAPEL2, sabtuMapel2);
        editor.putString(KEY_SABTU_MAPEL3, sabtuMapel3);
        editor.putString(KEY_SABTU_JAM1, sabtuJam1);
        editor.putString(KEY_SABTU_JAM2, sabtuJam2);
        editor.putString(KEY_SABTU_JAM3, sabtuJam3);

        editor.commit();

    }

    public HashMap<String, String> getJadwalDetailFromSession() {
        HashMap<String, String> jadwalData = new HashMap<String, String>();

        jadwalData.put(KEY_SENIN_MAPEL1, jadwalSessions.getString(KEY_SENIN_MAPEL1, null));
        jadwalData.put(KEY_SENIN_MAPEL2, jadwalSessions.getString(KEY_SENIN_MAPEL2, null));
        jadwalData.put(KEY_SENIN_MAPEL3, jadwalSessions.getString(KEY_SENIN_MAPEL3, null));
        jadwalData.put(KEY_SENIN_JAM1, jadwalSessions.getString(KEY_SENIN_JAM1, null));
        jadwalData.put(KEY_SENIN_JAM2, jadwalSessions.getString(KEY_SENIN_JAM2, null));
        jadwalData.put(KEY_SENIN_JAM3, jadwalSessions.getString(KEY_SENIN_JAM3, null));

        jadwalData.put(KEY_SELASA_MAPEL1, jadwalSessions.getString(KEY_SELASA_MAPEL1, null));
        jadwalData.put(KEY_SELASA_MAPEL2, jadwalSessions.getString(KEY_SELASA_MAPEL2, null));
        jadwalData.put(KEY_SELASA_MAPEL3, jadwalSessions.getString(KEY_SELASA_MAPEL3, null));
        jadwalData.put(KEY_SELASA_JAM1, jadwalSessions.getString(KEY_SELASA_JAM1, null));
        jadwalData.put(KEY_SELASA_JAM2, jadwalSessions.getString(KEY_SELASA_JAM2, null));
        jadwalData.put(KEY_SELASA_JAM3, jadwalSessions.getString(KEY_SELASA_JAM3, null));

        jadwalData.put(KEY_RABU_MAPEL1, jadwalSessions.getString(KEY_RABU_MAPEL1, null));
        jadwalData.put(KEY_RABU_MAPEL2, jadwalSessions.getString(KEY_RABU_MAPEL2, null));
        jadwalData.put(KEY_RABU_MAPEL3, jadwalSessions.getString(KEY_RABU_MAPEL3, null));
        jadwalData.put(KEY_RABU_JAM1, jadwalSessions.getString(KEY_RABU_JAM1, null));
        jadwalData.put(KEY_RABU_JAM2, jadwalSessions.getString(KEY_RABU_JAM2, null));
        jadwalData.put(KEY_RABU_JAM3, jadwalSessions.getString(KEY_RABU_JAM3, null));

        jadwalData.put(KEY_KAMIS_MAPEL1, jadwalSessions.getString(KEY_KAMIS_MAPEL1, null));
        jadwalData.put(KEY_KAMIS_MAPEL2, jadwalSessions.getString(KEY_KAMIS_MAPEL2, null));
        jadwalData.put(KEY_KAMIS_MAPEL3, jadwalSessions.getString(KEY_KAMIS_MAPEL3, null));
        jadwalData.put(KEY_KAMIS_JAM1, jadwalSessions.getString(KEY_KAMIS_JAM1, null));
        jadwalData.put(KEY_KAMIS_JAM2, jadwalSessions.getString(KEY_KAMIS_JAM2, null));
        jadwalData.put(KEY_KAMIS_JAM3, jadwalSessions.getString(KEY_KAMIS_JAM3, null));

        jadwalData.put(KEY_JUMAT_MAPEL1, jadwalSessions.getString(KEY_JUMAT_MAPEL1, null));
        jadwalData.put(KEY_JUMAT_MAPEL2, jadwalSessions.getString(KEY_JUMAT_MAPEL2, null));
        jadwalData.put(KEY_JUMAT_MAPEL3, jadwalSessions.getString(KEY_JUMAT_MAPEL3, null));
        jadwalData.put(KEY_JUMAT_JAM1, jadwalSessions.getString(KEY_JUMAT_JAM1, null));
        jadwalData.put(KEY_JUMAT_JAM2, jadwalSessions.getString(KEY_JUMAT_JAM2, null));
        jadwalData.put(KEY_JUMAT_JAM3, jadwalSessions.getString(KEY_JUMAT_JAM3, null));

        jadwalData.put(KEY_SABTU_MAPEL1, jadwalSessions.getString(KEY_SABTU_MAPEL1, null));
        jadwalData.put(KEY_SABTU_MAPEL2, jadwalSessions.getString(KEY_SABTU_MAPEL2, null));
        jadwalData.put(KEY_SABTU_MAPEL3, jadwalSessions.getString(KEY_SABTU_MAPEL3, null));
        jadwalData.put(KEY_SABTU_JAM1, jadwalSessions.getString(KEY_SABTU_JAM1, null));
        jadwalData.put(KEY_SABTU_JAM2, jadwalSessions.getString(KEY_SABTU_JAM2, null));
        jadwalData.put(KEY_SABTU_JAM3, jadwalSessions.getString(KEY_SABTU_JAM3, null));

        return jadwalData;

    }

}

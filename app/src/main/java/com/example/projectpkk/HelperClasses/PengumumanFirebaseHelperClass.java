package com.example.projectpkk.HelperClasses;

public class PengumumanFirebaseHelperClass {

    String judul, tanggal, isi;

    public PengumumanFirebaseHelperClass(String judul, String tanggal, String isi) {
        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

}

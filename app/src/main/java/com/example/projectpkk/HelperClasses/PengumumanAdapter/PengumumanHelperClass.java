package com.example.projectpkk.HelperClasses.PengumumanAdapter;

public class PengumumanHelperClass {

    String timestamp, judul, tanggal, isi;

    public PengumumanHelperClass(String timestamp, String judul, String tanggal, String isi) {
        this.timestamp = timestamp;
        this.judul = judul;
        this.tanggal = tanggal;
        this.isi = isi;
    }


    public PengumumanHelperClass() {

    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getJudul() {
        return judul;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getIsi() {
        return isi;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }


}

package com.example.projectpkk.HelperClasses.PengumumanAdapter;

public class PengumumanTambahHelperClass {

    String timestamp, judul, isi, tanggal;

    public PengumumanTambahHelperClass(String timestamp, String judul, String isi, String tanggal) {
        this.timestamp = timestamp;
        this.judul = judul;
        this.isi = isi;
        this.tanggal = tanggal;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

}

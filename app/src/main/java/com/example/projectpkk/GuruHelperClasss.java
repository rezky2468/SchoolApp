package com.example.projectpkk;

public class GuruHelperClasss {

    String nama, jabatan, ttl, pendidikan, mapel, email, telp, foto;

    public GuruHelperClasss(String nama, String jabatan, String ttl, String pendidikan, String mapel, String email, String telp, String foto) {
        this.nama = nama;
        this.jabatan = jabatan;
        this.ttl = ttl;
        this.pendidikan = pendidikan;
        this.mapel = mapel;
        this.email = email;
        this.telp = telp;
        this.foto = foto;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    public String getMapel() {
        return mapel;
    }

    public void setMapel(String mapel) {
        this.mapel = mapel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

}

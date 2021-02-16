package com.example.projectpkk.HelperClasses.JadwalAdapter.JadwalRecyclerViewAdapter;

public class JadwalHelperClass {

    String hari, jadwal1, jadwal2, jadwal3, jam1, jam2, jam3;

    public JadwalHelperClass(String hari, String jadwal1, String jadwal2, String jadwal3, String jam1, String jam2, String jam3) {
        this.hari = hari;
        this.jadwal1 = jadwal1;
        this.jadwal2 = jadwal2;
        this.jadwal3 = jadwal3;
        this.jam1 = jam1;
        this.jam2 = jam2;
        this.jam3 = jam3;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public void setJadwal1(String jadwal1) {
        this.jadwal1 = jadwal1;
    }

    public void setJadwal2(String jadwal2) {
        this.jadwal2 = jadwal2;
    }

    public void setJadwal3(String jadwal3) {
        this.jadwal3 = jadwal3;
    }

    public void setJam1(String jam1) {
        this.jam1 = jam1;
    }

    public void setJam2(String jam2) {
        this.jam2 = jam2;
    }

    public void setJam3(String jam3) {
        this.jam3 = jam3;
    }

    public String getHari() {
        return hari;
    }

    public String getJadwal1() {
        return jadwal1;
    }

    public String getJadwal2() {
        return jadwal2;
    }

    public String getJadwal3() {
        return jadwal3;
    }

    public String getJam1() {
        return jam1;
    }

    public String getJam2() {
        return jam2;
    }

    public String getJam3() {
        return jam3;
    }
}

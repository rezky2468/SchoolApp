package com.example.projectpkk.HelperClasses.HomeAdapter;

public class BeritaHelperClass {

    int image;
    String title, desc;

    public BeritaHelperClass(int image, String title, String desc) {
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

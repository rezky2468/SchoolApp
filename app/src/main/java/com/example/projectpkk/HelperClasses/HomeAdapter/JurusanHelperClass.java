package com.example.projectpkk.HelperClasses.HomeAdapter;

import android.widget.Button;

public class JurusanHelperClass {

    int image, icon;
    String title, description;

    public JurusanHelperClass(int image, int icon, String title, String description) {
        this.image = image;
        this.icon = icon;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public int getIcon() {
        return icon;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

}

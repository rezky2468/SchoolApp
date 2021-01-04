package com.example.projectpkk.HelperClasses.HomeAdapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.widget.RelativeLayout;

public class CategoriesHelperClass {

    int image;
    String title;

    public CategoriesHelperClass(int image, String title) {
        this.image = image;
        this.title = title;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

}

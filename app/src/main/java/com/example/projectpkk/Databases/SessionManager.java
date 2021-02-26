package com.example.projectpkk.Databases;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    // Variables
    SharedPreferences userSessions;
    SharedPreferences.Editor editor;
    Context context;

    private static final String IS_LOGIN = "IsLoggedIn";

    public static final String KEY_FULLNAME = "fullName";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_PHONENUMBER = "phoneNumber";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_DATE = "date";
    public static final String KEY_GENDER = "gender";

    public SessionManager(Context _context) {
        context = _context;
        userSessions = _context.getSharedPreferences("userLoginSession", Context.MODE_PRIVATE);
        editor = userSessions.edit();
    }

    public void createLoginSession(String fullName, String username, String email, String password, String gender, String date, String phoneNo) {

        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_FULLNAME, fullName);
        editor.putString(KEY_USERNAME, username);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASSWORD, password);
        editor.putString(KEY_GENDER, gender);
        editor.putString(KEY_DATE, date);
        editor.putString(KEY_PHONENUMBER, phoneNo);

        editor.commit();

    }

    public HashMap<String, String> getUsersDetailFromSession() {
        HashMap<String, String> userData = new HashMap<String, String>();

        userData.put(KEY_FULLNAME, userSessions.getString(KEY_FULLNAME, null));
        userData.put(KEY_USERNAME, userSessions.getString(KEY_USERNAME, null));
        userData.put(KEY_EMAIL, userSessions.getString(KEY_EMAIL, null));
        userData.put(KEY_PHONENUMBER, userSessions.getString(KEY_PHONENUMBER, null));
        userData.put(KEY_PASSWORD, userSessions.getString(KEY_PASSWORD, null));
        userData.put(KEY_DATE, userSessions.getString(KEY_DATE, null));
        userData.put(KEY_GENDER, userSessions.getString(KEY_GENDER, null));

        return userData;

    }

    public boolean checkLogin() {
        if (userSessions.getBoolean(IS_LOGIN, false)) {
            return true;
        } else {
            return false;
        }
    }

    public void logoutUserSession() {
        editor.clear();
        editor.commit();
    }

}

package com.example.projectpkk.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.projectpkk.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUpActivity extends AppCompatActivity {

    // Variables
//    ImageView backBtn;
//    Button next, login;
//    TextView titleText;

    // Get Data Variables
    TextInputLayout fullName, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up);

        // Hooks for animation
//        backBtn = findViewById(R.id.sign_up_back_button);
//        next = findViewById(R.id.next_btn);
//        login = findViewById(R.id.login_btn);
//        titleText = findViewById(R.id.sign_up_title_text);

        // Hooks for getting data
        fullName = findViewById(R.id.sign_up_full_name);
        username = findViewById(R.id.sign_up_username);
        email = findViewById(R.id.sign_up_email);
        password = findViewById(R.id.sign_up_password);
    }

    public void call2ndSignUpScreen(View view) {

        if (!validateFullName() | !validateUsername() | !validateEmail() | !validatePassword()) {
            return;
        }

        String _fullName = fullName.getEditText().getText().toString().trim();
        String _username = username.getEditText().getText().toString().trim();
        String _email = email.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();

        Intent intent1 = new Intent(getApplicationContext(), SignUpSecondClassActivity.class);

        intent1.putExtra("fullName", _fullName);
        intent1.putExtra("username", _username);
        intent1.putExtra("email", _email);
        intent1.putExtra("password", _password);

        // Add Transition
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

//            Pair[] pairs = new Pair[4];
//            pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
//            pairs[1] = new Pair<View, String>(next, "transition_next_btn");
//            pairs[2] = new Pair<View, String>(login, "transition_back_btn");
//            pairs[3] = new Pair<View, String>(titleText, "transition_title_btn");
//
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
//            startActivity(intent, options.toBundle());
        } else {
            startActivity(intent1);
        }
    }

    public void callLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    // Validation Functions

    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Data tidak boleh kosong!");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateUsername() {
        String val = username.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";
        if (val.isEmpty()) {
            username.setError("Data tidak boleh kosong!");
            return false;
        } else if (val.length() > 20) {
            username.setError("Nama terlalu panjang!");
            return false;
        } else if (!val.matches(checkSpaces)) {
            username.setError("Spasi tidak diperbolehkan!");
            return false;
        } else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if (val.isEmpty()) {
            email.setError("Data tidak boleh kosong!");
            return false;
        } else if (!val.matches(checkEmail)) {
            email.setError("Email salah!");
            return false;
        } else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                // "(?=.*[0-9])" + // at least 1 digit
                // "(?=.*[a-z])" + // at least 1 lower case letter
                // "(?=.*[A-Z])" + // at least 1 upper case letter
                "(?=.*[a-zA-Z])" + // any letter
                // "(?=.*[@#$%^&+=])" + // at least 1 special character
                "(?=\\S+$])"; //+ // no white spaces
////                ".{4,}" + // at least 4 character
//                "$";

        if (val.isEmpty()) {
            password.setError("Data tidak boleh kosong!");
            return false;
//        } else if (!val.matches(checkPassword)) {
//            password.setError("Password should contains 4 characters!");
//            return false;
        } else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }
}
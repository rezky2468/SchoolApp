package com.example.projectpkk.Common.LoginSignUp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import com.example.projectpkk.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUpThirdClassActivity extends AppCompatActivity {

    // Variables
//    ImageView backBtn;
//    Button next, login;
//    TextView titleText;

    ScrollView scrollView;
    CountryCodePicker countryCodePicker;
    TextInputLayout signUpPhoneNumber;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up_third_class);

        // Hooks
//        backBtn = findViewById(R.id.sign_up_back_button);
//        next = findViewById(R.id.sign_up_next_btn);
//        login = findViewById(R.id.login_btn);
//        titleText = findViewById(R.id.sign_up_title_text);

        scrollView = findViewById(R.id.signup_3rd_screen_scroll_view);
        countryCodePicker = findViewById(R.id.loginCountryCodePicker);
        signUpPhoneNumber = findViewById(R.id.sign_up_phone_number);

    }


    public void callVerifyOTPScreen(View view) {

        if (!isConnected(this)) {
            showCustomDialog();
        }

        // Validate fields
        if (!validatePhoneNumber()) {
            return;
        } // Validation succeeded and now move to next screen to verify phone number and save data

        // Get all values passed from previous screens using Intent
        String _fullName = getIntent().getStringExtra("fullName");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");
        String _gender = getIntent().getStringExtra("gender");
        String _date = getIntent().getStringExtra("date");

        String _getUserEnteredPhoneNumber = signUpPhoneNumber.getEditText().getText().toString().trim(); // Get Phone Number
        String _phoneNo = "+" + countryCodePicker.getFullNumber() + _getUserEnteredPhoneNumber;

        Intent intent3 = new Intent(getApplicationContext(), VerifyOTPActivity.class);

        // Pass all fields to the next activity
        intent3.putExtra("fullName", _fullName);
        intent3.putExtra("username", _username);
        intent3.putExtra("email", _email);
        intent3.putExtra("password", _password);
        intent3.putExtra("gender", _gender);
        intent3.putExtra("date", _date);
        intent3.putExtra("phoneNo", _phoneNo);

        // Add Transition
//        Pair[] pairs = new Pair[1];
//        pairs[0] = new Pair<View, String>(scrollView, "transition_OTP_screen");

        startActivity(intent3);
    }

    public void callLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    private boolean isConnected(SignUpThirdClassActivity signUpThirdClassActivity) {

        ConnectivityManager connectivityManager = (ConnectivityManager) signUpThirdClassActivity.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        if ((wifiConn != null && wifiConn.isConnected()) || (mobileConn != null && mobileConn.isConnected())) {
            return true;
        } else {
            return false;
        }
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SignUpThirdClassActivity.this);
        builder.setMessage("Tolong hubungkan koneksi internet")
                .setCancelable(false)
                .setPositiveButton("Hubungkan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        startActivity(new Intent(getApplicationContext(), RetailerStartUpScreenActivity.class));
                        ;
                        finish();
                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public boolean validatePhoneNumber() {
        String val = signUpPhoneNumber.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            signUpPhoneNumber.setError("Data tidak boleh Kosong!");
            return false;
        } else {
            signUpPhoneNumber.setError(null);
            signUpPhoneNumber.setErrorEnabled(false);
            return true;
        }
    }
}
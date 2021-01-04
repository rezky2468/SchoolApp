package com.example.projectpkk.Common.LoginSignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.projectpkk.Databases.CheckInternet;
import com.example.projectpkk.R;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.hbb20.CountryCodePicker;

public class ForgetPasswordActivity extends AppCompatActivity {

    // Variables
    private ImageView screenIcon;
    private TextView title, description;
    private TextInputLayout phoneNumberTextField;
    private CountryCodePicker countryCodePicker;
    private Button nextBtn;
    private Animation animation;
    RelativeLayout progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_forget_password);

        // Hooks
//        screenIcon = findViewById(R.id.forget_password_icon);
//        title = findViewById(R.id.forget_password_title);
//        description = findViewById(R.id.forget_password_description);
        phoneNumberTextField = findViewById(R.id.forget_password_phone_number);
        countryCodePicker = findViewById(R.id.forgetPasswordCountryCodePicker);
        nextBtn = findViewById(R.id.forget_password_next_btn);
        progressBar = findViewById(R.id.forget_password_progress_bar);


    }


    public void verifyOTP(View view) {

        // Check Internet Connection
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }

        // Validate Phone Number
        if (!validateField()) {
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        // Get data from fields
        String _phoneNumber = phoneNumberTextField.getEditText().getText().toString().trim();
        if (_phoneNumber.charAt(0) == '0') {
            _phoneNumber.substring(1);
        }
        final String _completePhoneNumber = "+" + countryCodePicker.getFullNumber() + _phoneNumber;

        // Check weather user exist or not in database
        Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("phoneNo").equalTo(_completePhoneNumber);
        checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // If phone number exists then call OTP to verify that it is his/her phone number
                if (dataSnapshot.exists()) {
                    phoneNumberTextField.setError(null);
                    phoneNumberTextField.setErrorEnabled(false);

                    Intent intent = new Intent(getApplicationContext(), VerifyOTPActivity.class);
                    intent.putExtra("phoneNo", _completePhoneNumber);
                    intent.putExtra("whatToDO", "updateData");
                    startActivity(intent);
                    finish();

                    progressBar.setVisibility(View.GONE);
                } else {
                    progressBar.setVisibility(View.GONE);
                    phoneNumberTextField.setError("No such user exist!");
                    phoneNumberTextField.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

//    private boolean isConnected(ForgetPassword forgetPassword) {
//
//        ConnectivityManager connectivityManager = (ConnectivityManager) forgetPassword.getSystemService(Context.CONNECTIVITY_SERVICE);
//
//        NetworkInfo wifiConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
//        NetworkInfo mobileConn = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
//
//        if ((wifiConn != null | wifiConn.isConnected()) | (mobileConn != null | mobileConn.isConnected())) {
//            return true;
//        } else {
//            return false;
//        }
//
//    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(ForgetPasswordActivity.this);

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
                        finish();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private boolean validateField() {

        String _phoneNumber = phoneNumberTextField.getEditText().getText().toString().trim();

        if (_phoneNumber.isEmpty()) {
            phoneNumberTextField.setError("Nomor telepon tidak boleh kosong");
            phoneNumberTextField.requestFocus();
            return false;
        } else {
            phoneNumberTextField.setError(null);
            phoneNumberTextField.setErrorEnabled(false);
            return true;
        }

    }
}
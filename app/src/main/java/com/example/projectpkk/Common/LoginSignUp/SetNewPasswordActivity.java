package com.example.projectpkk.Common.LoginSignUp;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetNewPasswordActivity extends AppCompatActivity {

    // Variables
    private ImageView screenIcon;
    private TextView title, description;
    private TextInputLayout newPassword, confirmNewPassword;
    private Button nextBtn;
    private Animation animation;
    RelativeLayout progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_set_new_password);

        // Hooks
//        screenIcon = findViewById(R.id.forget_password_icon);
//        title = findViewById(R.id.forget_password_title);
//        description = findViewById(R.id.forget_password_description);
        newPassword = findViewById(R.id.new_password);
        confirmNewPassword = findViewById(R.id.confirm_new_password);
        nextBtn = findViewById(R.id.new_password_button);
        progressBar = findViewById(R.id.set_new_password_progress_bar);


    }

    public void setNewPasswordBtn(View view) {

        // Check Internet Connection
        CheckInternet checkInternet = new CheckInternet();
        if (!checkInternet.isConnected(this)){
            showCustomDialog();
            return;
        }

        // Validate Password
        if (!validatePassword() | !validateConfirmPassword()) {
            return;
        }
        progressBar.setVisibility(View.VISIBLE);

        // Get data from fields
        String _newPassword = newPassword.getEditText().getText().toString().trim();
        String _phoneNumber = getIntent().getStringExtra("phoneNo");

        // Update data in firebase and sessions
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        reference.child(_phoneNumber).child("password").setValue(_newPassword);

        startActivity(new Intent(getApplicationContext(), ForgetPasswordSuccessMessageActivity.class));
        finish();

    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(SetNewPasswordActivity.this);

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

    private boolean validatePassword() {

        String _thisNewPassword = newPassword.getEditText().getText().toString().trim();

        if (_thisNewPassword.isEmpty()) {
            newPassword.setError("Password tidak boleh kosong");
            newPassword.requestFocus();
            return false;
        } else {
            newPassword.setError(null);
            newPassword.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateConfirmPassword() {

        String _thisConfirmNewPassword = confirmNewPassword.getEditText().getText().toString().trim();

        if (_thisConfirmNewPassword.isEmpty()) {
            confirmNewPassword.setError("Password tidak boleh kosong");
            confirmNewPassword.requestFocus();
            return false;
        } else {
            confirmNewPassword.setError(null);
            confirmNewPassword.setErrorEnabled(false);
            return true;
        }

    }

    public void callBackScreen(View view) {
        super.onBackPressed();
    }

}
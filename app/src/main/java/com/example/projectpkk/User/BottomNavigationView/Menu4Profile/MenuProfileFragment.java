package com.example.projectpkk.User.BottomNavigationView.Menu4Profile;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projectpkk.Common.LoginSignUp.RetailerStartUpScreenActivity;
import com.example.projectpkk.Databases.SessionManager;
import com.example.projectpkk.Databases.UserHelperClass;
import com.example.projectpkk.NotifikasiActivity;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MenuProfileFragment extends Fragment {

    Button logoutBtn;
    TextView fullNameTV, usernameTV, emailTV, phoneTV, dobTV;
    ImageView editProfile;
    String _fullName, _username, _email, _phone, _dob, _password, _gender;
    String newFullName, newUserName, newEmail, newPhone, newDate, newPassword, newGender;
    EditText fullNameET, usernameET, emailET, phoneET, dateET;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_profile, container, false);

        fullNameTV = view.findViewById(R.id.profile_full_name);
        usernameTV = view.findViewById(R.id.profile_username);
        emailTV = view.findViewById(R.id.profile_email);
        phoneTV = view.findViewById(R.id.profile_phone);
        dobTV = view.findViewById(R.id.profile_dob);
        logoutBtn = view.findViewById(R.id.profile_logout);
        editProfile = view.findViewById(R.id.profile_edit);

        SessionManager sessionManager = new SessionManager(getActivity());
        HashMap<String, String> hashMap = sessionManager.getUsersDetailFromSession();

        _fullName = hashMap.get(SessionManager.KEY_FULLNAME);
        _username = hashMap.get(SessionManager.KEY_USERNAME);
        _email = hashMap.get(SessionManager.KEY_EMAIL);
        _password = hashMap.get(SessionManager.KEY_PASSWORD);
        _gender = hashMap.get(SessionManager.KEY_GENDER);
        _phone = hashMap.get(SessionManager.KEY_PHONENUMBER);
        _dob = hashMap.get(SessionManager.KEY_DATE);

        fullNameTV.setText(_fullName);
        usernameTV.setText(_username);
        emailTV.setText(_email);
        phoneTV.setText(_phone);
        dobTV.setText(_dob);

        TextView textView = view.findViewById(R.id.list_activity);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), NotifikasiActivity.class));
            }
        });

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showEditDialog();

            }
        });

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLogoutDialog();
            }
        });

        return view;
    }

    private void showEditDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialog);

        Context context = getActivity();
        LinearLayout layout = new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Add a TextView here for the "Title" label, as noted in the comments
        fullNameET = new EditText(context);
        fullNameET.setHint("Nama Lengkap");
        fullNameET.setHintTextColor(getResources().getColor(R.color.colorGrey));
        fullNameET.setText(_fullName);
        fullNameET.setTextColor(getResources().getColor(R.color.colorOnPrimaryText));
        layout.addView(fullNameET); // Notice this is an add method

        // Add another TextView here for the "Description" label
        usernameET = new EditText(context);
        usernameET.setHint("Username");
        usernameET.setHintTextColor(getResources().getColor(R.color.colorGrey));
        usernameET.setText(_username);
        usernameET.setTextColor(getResources().getColor(R.color.colorOnPrimaryText));
        layout.addView(usernameET); // Another add method

        emailET = new EditText(context);
        emailET.setHint("Email");
        emailET.setHintTextColor(getResources().getColor(R.color.colorGrey));
        emailET.setText(_email);
        emailET.setTextColor(getResources().getColor(R.color.colorOnPrimaryText));
        layout.addView(emailET); // Another add method

        phoneET = new EditText(context);
        phoneET.setHint("Nomor Telepon");
        phoneET.setHintTextColor(getResources().getColor(R.color.colorGrey));
        phoneET.setText(_phone);
        phoneET.setTextColor(getResources().getColor(R.color.colorOnPrimaryText));
        layout.addView(phoneET); // Another add method

        dateET = new EditText(context);
        dateET.setHint("Tanggal Lahir");
        dateET.setHintTextColor(getResources().getColor(R.color.colorGrey));
        dateET.setText(_dob);
        dateET.setTextColor(getResources().getColor(R.color.colorOnPrimaryText));
        layout.addView(dateET); // Another add method

        builder.setView(layout); // Again this is a set method, not add

        builder.setTitle("Edit Profil")
                .setPositiveButton("Simpan", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        newFullName = fullNameET.getText().toString().trim();
                        newUserName = usernameET.getText().toString().trim();
                        newEmail = emailET.getText().toString().trim();
                        newPassword = _password;
                        newGender = _gender;
                        newDate = dateET.getText().toString().trim();
                        newPhone = phoneET.getText().toString().trim();

                        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
                        DatabaseReference reference = rootNode.getReference("Users");
                        UserHelperClass editProfil = new UserHelperClass(newFullName, newUserName, newEmail, newPhone, newDate, newPassword, newGender);
                        reference.child(newPhone).setValue(editProfil);

                        SessionManager sessionManager = new SessionManager(getActivity());
                        sessionManager.createLoginSession(newFullName, newUserName, newEmail, newPhone, newDate, newPassword, newGender);

                        fullNameTV.setText(newFullName);
                        usernameTV.setText(newUserName);
                        emailTV.setText(newEmail);
                        phoneTV.setText(newPhone);
                        dobTV.setText(newDate);

                        startActivity(new Intent(getActivity(), UserDashboardActivity.class));
                        Toast.makeText(getActivity(), "Profil berhasil diubah!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Batal", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showLogoutDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialog);
        builder.setMessage("Yakin ingin logout?")
                .setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        SessionManager sessionManager = new SessionManager(getActivity());
                        sessionManager.logoutUserSession();
                        startActivity(new Intent(getActivity(), UserDashboardActivity.class));
                        Toast.makeText(getActivity(), "Anda berhasil logout!", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void showCustomDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
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
                        startActivity(new Intent(getActivity(), RetailerStartUpScreenActivity.class));
                        getActivity().finish();
                    }
                });

        AlertDialog alert = builder.create();
        alert.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alert.show();
    }

//    private boolean validateFullName() {
//        String val = fullNameBox.getText().toString().trim();
//        if (val.isEmpty()) {
//            fullNameBox.setError("Data tidak boleh kosong!");
//            return false;
//        } else {
//            fullNameBox.setError(null);
////            fullNameBox.setErrorEnabled(false);
//            return true;
//        }
//
//    }

//    private boolean validateUsername() {
//        String val = email.getText().toString().trim();
//        String checkSpaces = "\\A\\w{1,20}\\z";
//        if (_username.isEmpty()) {
//            usernameBox.setError("Data tidak boleh kosong!");
//            return false;
//        } else if (_username.length() > 20) {
//            usernameBox.setError("Username terlalu panjang!");
//            return false;
//        } else if (!_username.matches(checkSpaces)) {
//            usernameBox.setError("Spasi tidak diperbolehkan!");
//            return false;
//        } else {
//            usernameBox.setError(null);
////            usernameBox.setErrorEnabled(false);
//            return true;
//        }
//
//    }

//    private boolean validateEmail() {
//        String val = email.getText().toString().trim();
//        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
//        if (val.isEmpty()) {
//            email.setError("Data tidak boleh kosong!");
//            return false;
//        } else if (!val.matches(checkEmail)) {
//            email.setError("Email salah!");
//            return false;
//        } else {
//            email.setError(null);
//            email.setErrorEnabled(false);
//            return true;
//        }
//
//    }

//    private boolean validatePassword() {
//        String val = password.getEditText().getText().toString().trim();
//        String checkPassword = "^" +
//                // "(?=.*[0-9])" + // at least 1 digit
//                // "(?=.*[a-z])" + // at least 1 lower case letter
//                // "(?=.*[A-Z])" + // at least 1 upper case letter
//                "(?=.*[a-zA-Z])" + // any letter
//                // "(?=.*[@#$%^&+=])" + // at least 1 special character
//                "(?=\\S+$])"; //+ // no white spaces
//////                ".{4,}" + // at least 4 character
////                "$";
//
//        if (val.isEmpty()) {
//            password.setError("Data tidak boleh kosong!");
//            return false;
////        } else if (!val.matches(checkPassword)) {
////            password.setError("Password should contains 4 characters!");
////            return false;
//        } else {
//            password.setError(null);
//            password.setErrorEnabled(false);
//            return true;
//        }

//    }


}
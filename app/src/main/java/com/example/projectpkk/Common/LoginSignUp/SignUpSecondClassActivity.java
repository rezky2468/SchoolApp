package com.example.projectpkk.Common.LoginSignUp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.projectpkk.R;

import java.util.Calendar;

public class SignUpSecondClassActivity extends AppCompatActivity {

    // Variables
//    ImageView backBtn;
//    Button next, login;
//    TextView titleText;

    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_retailer_sign_up_second_class);

        // Hooks
//        backBtn = findViewById(R.id.sign_up_back_button);
//        next = findViewById(R.id.next_btn);
//        login = findViewById(R.id.login_btn);
//        titleText = findViewById(R.id.sign_up_title_text);

        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);


    }

    public void call3rdSignUpScreen(View view) {

        if (!validateGender() | !validateAge()) {
            return;
        }

        String _fullName = getIntent().getStringExtra("fullName");
        String _username = getIntent().getStringExtra("username");
        String _email = getIntent().getStringExtra("email");
        String _password = getIntent().getStringExtra("password");

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectedGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String _date = day + "/" + month + "/" + year;

        Intent intent2 = new Intent(getApplicationContext(), SignUpThirdClassActivity.class);

        intent2.putExtra("fullName", _fullName);
        intent2.putExtra("username", _username);
        intent2.putExtra("email", _email);
        intent2.putExtra("password", _password);
        intent2.putExtra("gender", _gender);
        intent2.putExtra("date", _date);

//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // Add Transition
//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {

//            Pair[] pairs = new Pair[4];
//            pairs[0] = new Pair<View, String>(backBtn, "transition_back_arrow_btn");
//            pairs[1] = new Pair<View, String>(next, "transition_next_btn");
//            pairs[2] = new Pair<View, String>(login, "transition_back_btn");
//            pairs[3] = new Pair<View, String>(titleText, "transition_title_btn");
//
//            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUpSecondClass.this, pairs);
//            startActivity(intent, options.toBundle());
//        } else {
            startActivity(intent2);
//        }
    }

    public void callLoginScreen(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Mohon pilih jenis kelamin!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "Umur belum cukup!", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
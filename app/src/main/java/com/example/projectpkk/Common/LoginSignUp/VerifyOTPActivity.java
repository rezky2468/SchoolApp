package com.example.projectpkk.Common.LoginSignUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.example.projectpkk.Databases.UserHelperClass;
import com.example.projectpkk.R;
import com.example.projectpkk.UserDashboardActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOTPActivity extends AppCompatActivity {

    PinView pinFromUser;
    String codeBySystem;
    String fullName, username, email, password, gender, date, phoneNo, whatToDO;
    TextView displayPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_verify_o_t_p);

        // Hooks
        pinFromUser = findViewById(R.id.pin_view);
        displayPhoneNumber = findViewById(R.id.verify_otp_phone_number);

        // Get all the data from intent
        fullName = getIntent().getStringExtra("fullName");
        username = getIntent().getStringExtra("username");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        gender = getIntent().getStringExtra("gender");
        date = getIntent().getStringExtra("date");
        phoneNo = getIntent().getStringExtra("phoneNo");
        whatToDO = getIntent().getStringExtra("whatToDO");

        displayPhoneNumber.setText(phoneNo);

        sendVerificationCodeToUser(phoneNo);

    }

    private void sendVerificationCodeToUser(String phoneNo) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phoneNo,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                TaskExecutors.MAIN_THREAD,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

                @Override
                public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codeBySystem = s;
                }

                @Override
                public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
                    String code = phoneAuthCredential.getSmsCode();
                    if (code != null) {
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(FirebaseException e) {
                    Toast.makeText(VerifyOTPActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeBySystem, code);
        SignInWithPhoneAuthCredential(credential);
    }

    private void SignInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Verification completed successfully here Either store the data or do whatever desire
//                            if (whatToDO.equals("updateData")) {
//                                updateOldUserData();
//                            } else {
                            storeNewUsersData();
//                                startActivity(new Intent(getApplicationContext(), RetailerStartUpScreen.class));
//                            }
                            Toast.makeText(VerifyOTPActivity.this, "Verifikasi Berhasil!", Toast.LENGTH_SHORT).show();
                        } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                            Toast.makeText(VerifyOTPActivity.this, "Verifikasi Gagal! Coba Lagi.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void updateOldUserData() {

        Intent intent = new Intent(getApplicationContext(), SetNewPasswordActivity.class);
        intent.putExtra("phoneNo", phoneNo);
        startActivity(intent);
        finish();

    }

    private void storeNewUsersData() {

        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        UserHelperClass addNewUser = new UserHelperClass(fullName, username, email, password, gender, date, phoneNo);

        reference.child(phoneNo).setValue(addNewUser);


//        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference();

    }

    // First check the call and then redirect user accordingly to the Profile or to set new password screen
    public void verifyOTPScreen(View view) {

        String code = pinFromUser.getText().toString();
        if (!code.isEmpty()) {
            verifyCode(code);
            startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
        }

    }

    public void closeScreen(View view) {
        startActivity(new Intent(getApplicationContext(), UserDashboardActivity.class));
    }


}
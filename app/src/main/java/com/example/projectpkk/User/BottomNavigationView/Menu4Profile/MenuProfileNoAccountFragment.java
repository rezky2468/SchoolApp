package com.example.projectpkk.User.BottomNavigationView.Menu4Profile;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.projectpkk.Common.LoginSignUp.SignUpActivity;
import com.example.projectpkk.R;
import com.example.projectpkk.User.LoginSiswaActivity;

public class MenuProfileNoAccountFragment extends Fragment {

    Button login, signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu_profile_no_account, container, false);

        login = view.findViewById(R.id.profile_login_btn);
        signUp = view.findViewById(R.id.profile_sign_up_btn);
        
//        ImageView imageView = view.findViewById(R.id.gambarcontoh);
//
//        StorageReference storageReference = FirebaseStorage.getInstance().getReference();
//        StorageReference photoReference= storageReference.child("foto-guru/guru_abin.jpg");
//
//        final long ONE_MEGABYTE = 1024 * 1024;
//        photoReference.getBytes(ONE_MEGABYTE).addOnSuccessListener(new OnSuccessListener<byte[]>() {
//            @Override
//            public void onSuccess(byte[] bytes) {
//                Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
//                imageView.setImageBitmap(bmp);
//
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                Toast.makeText(getContext(), "No Such file or Path found!!", Toast.LENGTH_LONG).show();
//            }
//        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] options = {"Siswa", "Guru", "Admin"};
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialog);
                builder.setTitle("Login sebagai")
                        .setItems(options, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(getActivity(), LoginSiswaActivity.class);
                                switch (which) {
                                    case 0:
                                        intent.putExtra("LEVEL", "siswa");
                                        startActivity(intent);
                                        break;
                                    case 1:
                                        intent.putExtra("LEVEL", "guru");
                                        startActivity(intent);
                                        break;
                                    case 2:
                                        intent.putExtra("LEVEL", "admin");
                                        startActivity(intent);
                                        break;
                                }
                            }
                        });
                builder.show();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SignUpActivity.class));
            }
        });

        return view;

    }
}
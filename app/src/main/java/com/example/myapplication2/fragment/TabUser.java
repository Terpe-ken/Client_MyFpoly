package com.example.myapplication2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.myapplication2.R;


public class TabUser extends Fragment {


    TextView masinhvien, tvName, tvEmail;
    String email, name, avatar;
    ImageView imgavatar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile,container,false);
        masinhvien = view.findViewById(R.id.masinhvien);
        tvName = view.findViewById(R.id.textView);
        tvEmail = view.findViewById(R.id.textView2);
        imgavatar = view.findViewById(R.id.imgAvatar);
        Intent intent = getActivity().getIntent();
        email = intent.getStringExtra("email");
        name = intent.getStringExtra("name");
        avatar = intent.getStringExtra("avatar");
        tvName.setText(name);
        tvEmail.setText(email);
        Glide.with(getActivity()) //fix
                .load(avatar)
                .circleCrop()
                .into(imgavatar);
        String[] mssv = email.split("@");
        String beforeAt = mssv[0];
        int startIndex = beforeAt.length() - 7;
        String mssv2 = beforeAt.substring(startIndex);
        masinhvien.setText(mssv2);
        return view;
    }
}
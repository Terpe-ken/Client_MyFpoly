package com.example.myapplication2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.dto.GetLichHocIdRequestDTO;
import com.example.myapplication2.dto.GetLichHocIdResponeseDTO;
import com.example.myapplication2.dto.ListgetAllCosoResponeseDTO;
import com.example.myapplication2.dto.LoginRequestDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLichHocActivity extends AppCompatActivity {
    TextView details_diadiem, details_ngayhoc, details_monhoc, details_mamonhoc;
    int id;
    String teacher;
    Button BtnBack;
    IRetrofit iRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_schedules);
        details_diadiem = findViewById(R.id.details_diadiem);
        details_ngayhoc = findViewById(R.id.details_ngayhoc);
        details_monhoc = findViewById(R.id.details_monhoc);
        details_mamonhoc = findViewById(R.id.details_mamonhoc);
        BtnBack = findViewById(R.id.BtnBack);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        Intent intent = getIntent();
        id = Integer.parseInt(intent.getStringExtra("id"));
        teacher = intent.getStringExtra("teacher");



        BtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        GetLichHocIdRequestDTO request = new GetLichHocIdRequestDTO(id);
        iRetrofit.getLichHocId(request).enqueue(getlichhocid);
    }
    Callback<GetLichHocIdResponeseDTO> getlichhocid = new Callback<GetLichHocIdResponeseDTO>() {
        @Override
        public void onResponse(Call<GetLichHocIdResponeseDTO> call, Response<GetLichHocIdResponeseDTO> response) {
            if (response.isSuccessful()) {
                GetLichHocIdResponeseDTO reponeseDTO = response.body();
                if(reponeseDTO.isStatus()){
                    String toa = reponeseDTO.getAddress().substring(0,1);
                    details_diadiem.setText("Phòng: " + reponeseDTO.getAddress() + "(Tòa" + toa + ")");
                    details_monhoc.setText(reponeseDTO.getCourseid());
                    details_ngayhoc.setText(reponeseDTO.getDate() +"-Ca " + reponeseDTO.getCa());
                    details_mamonhoc.setText(teacher);
                }
            }
        }
        @Override
        public void onFailure(Call<GetLichHocIdResponeseDTO> call, Throwable t) {
        }
    };
}
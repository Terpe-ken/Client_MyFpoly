package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.dto.GetLichHocIdRequestDTO;
import com.example.myapplication2.dto.GetLichHocIdResponeseDTO;
import com.example.myapplication2.dto.GetLichThiIdRequestDTO;
import com.example.myapplication2.dto.GetLichThiIdResponeseDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailLichThiActivity extends AppCompatActivity {
    TextView details_diadiem, details_ngayhoc, details_monhoc, details_mamonhoc;
    int id;
    String teacher;
    IRetrofit iRetrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_schedules);
        details_diadiem = findViewById(R.id.details_diadiem);
        details_ngayhoc = findViewById(R.id.details_ngayhoc);
        details_monhoc = findViewById(R.id.details_monhoc);
        details_mamonhoc = findViewById(R.id.details_mamonhoc);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        Intent intent = getIntent();
        id = Integer.parseInt(intent.getStringExtra("id"));
        teacher = intent.getStringExtra("teacher");

    }

    @Override
    protected void onResume() {
        super.onResume();
        GetLichThiIdRequestDTO request = new GetLichThiIdRequestDTO(id);
        iRetrofit.getLichThiId(request).enqueue(getlichhocid);
    }
    Callback<GetLichThiIdResponeseDTO> getlichhocid = new Callback<GetLichThiIdResponeseDTO>() {
        @Override
        public void onResponse(Call<GetLichThiIdResponeseDTO> call, Response<GetLichThiIdResponeseDTO> response) {
            if (response.isSuccessful()) {
                GetLichThiIdResponeseDTO reponeseDTO = response.body();
                if(reponeseDTO.isStatus()){
                    String toa = reponeseDTO.getAddress().substring(0,1);
                    details_diadiem.setText("Phòng: " + reponeseDTO.getAddress() + "(Tòa" + toa + ")");
                    details_monhoc.setText(reponeseDTO.getIdcourse());
                    details_ngayhoc.setText(reponeseDTO.getDate() +"-Ca " + reponeseDTO.getCa());
                    details_mamonhoc.setText(teacher);
                }
            }
        }
        @Override
        public void onFailure(Call<GetLichThiIdResponeseDTO> call, Throwable t) {
        }
    };
}
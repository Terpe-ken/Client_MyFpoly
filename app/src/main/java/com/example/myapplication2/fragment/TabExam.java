package com.example.myapplication2.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication2.Adapter.LichThiAdapter;
import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllLichThiRequestDTO;
import com.example.myapplication2.dto.ListGetAllLichThiResponeseDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabExam extends Fragment {
    ListView lvLichThi;
    IRetrofit iRetrofit;
    LichThiAdapter lichThiAdapter;
    int id = 3;
    ArrayList<ListGetAllLichThiResponeseDTO.GetAllLichThiResponeseDTO> listLichThi;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_exam, container, false);
        lvLichThi = view.findViewById(R.id.lvLichThi);
        listLichThi = new ArrayList<>();
        lichThiAdapter = new LichThiAdapter(listLichThi);
        lvLichThi.setAdapter(lichThiAdapter);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        ListGetAllLichThiRequestDTO request = new ListGetAllLichThiRequestDTO(id);
        iRetrofit.getAllLichThi(request).enqueue(getalllichthi);
    }
    Callback<ListGetAllLichThiResponeseDTO> getalllichthi = new Callback<ListGetAllLichThiResponeseDTO>() {
        @Override
        public void onResponse(Call<ListGetAllLichThiResponeseDTO> call, Response<ListGetAllLichThiResponeseDTO> response) {
            if (response.isSuccessful()) {
                ListGetAllLichThiResponeseDTO reponeseDTO = response.body();
                listLichThi.clear();
                listLichThi.addAll(reponeseDTO.getAlllichthi());
//                ListGetAllCourseResponeseDTO.GetAllCourseResponeseDTO request = new GetLichHocIdRequestDTO(id);
//                iRetrofit.getAllLichHoc(request).enqueue(getalllichhoc);
                lichThiAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<ListGetAllLichThiResponeseDTO> call, Throwable t) {

        }
    };
}

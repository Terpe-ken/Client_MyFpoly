package com.example.myapplication2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication2.Adapter.LichHocAdapter;
import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllLichHocRequestDTO;
import com.example.myapplication2.dto.ListGetAllLichHocResponeseDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabSchedules extends Fragment {
    ListView lvLichHoc;
    IRetrofit iRetrofit;
    LichHocAdapter lichhocadapter;
    ArrayList<ListGetAllLichHocResponeseDTO.GetAllLichHocResponeseDTO> listlichhoc;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab_schedules, container, false);
        lvLichHoc = view.findViewById(R.id.lvLichHoc);
        listlichhoc = new ArrayList<>();
        lichhocadapter = new LichHocAdapter(listlichhoc);
        lvLichHoc.setAdapter(lichhocadapter);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);

        return view;
    }
    @Override
    public void onResume() {
        super.onResume();
        int id = 1;
        ListGetAllLichHocRequestDTO request = new ListGetAllLichHocRequestDTO(id);
        iRetrofit.getAllLichHoc(request).enqueue(getalllichhoc);
    }
    Callback<ListGetAllLichHocResponeseDTO> getalllichhoc = new Callback<ListGetAllLichHocResponeseDTO>() {
        @Override
        public void onResponse(Call<ListGetAllLichHocResponeseDTO> call, Response<ListGetAllLichHocResponeseDTO> response) {
            if (response.isSuccessful()) {
                ListGetAllLichHocResponeseDTO reponeseDTO = response.body();
                listlichhoc.clear();
                listlichhoc.addAll(reponeseDTO.getAlllichhoc());
                lichhocadapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<ListGetAllLichHocResponeseDTO> call, Throwable t) {

        }
    };
}

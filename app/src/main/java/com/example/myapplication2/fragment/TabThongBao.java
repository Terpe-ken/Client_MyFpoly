package com.example.myapplication2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication2.Adapter.ThongBaoAdapter;
import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllThongBaoRequestDTO;
import com.example.myapplication2.dto.ListgetAllThongBaoResponeseDTO;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabThongBao extends Fragment {

    ListView lvThongBao;
    IRetrofit iRetrofit;
    ThongBaoAdapter thongBaoAdapter;
    ArrayList<ListgetAllThongBaoResponeseDTO.getAllThongBaoResponeseDTO> listThongBao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notification,container,false);
        lvThongBao = view.findViewById(R.id.lvThongBao);
        listThongBao = new ArrayList<>();
        thongBaoAdapter = new ThongBaoAdapter(listThongBao);
        lvThongBao.setAdapter(thongBaoAdapter);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        return view;

    }

    @Override
    public void onResume() {
        super.onResume();
        int id = 3;
        ListGetAllThongBaoRequestDTO request = new ListGetAllThongBaoRequestDTO(id);
        iRetrofit.getallthongbao(request).enqueue(getallthongbao);
    }
    Callback<ListgetAllThongBaoResponeseDTO> getallthongbao = new Callback<ListgetAllThongBaoResponeseDTO>() {
        @Override
        public void onResponse(Call<ListgetAllThongBaoResponeseDTO> call, Response<ListgetAllThongBaoResponeseDTO> response) {
            if (response.isSuccessful()) {
                ListgetAllThongBaoResponeseDTO reponeseDTO = response.body();
                listThongBao.clear();
                listThongBao.addAll(reponeseDTO.getAllthongbao());
                thongBaoAdapter.notifyDataSetChanged();
            }
        }
        @Override
        public void onFailure(Call<ListgetAllThongBaoResponeseDTO> call, Throwable t) {

        }
    };
}
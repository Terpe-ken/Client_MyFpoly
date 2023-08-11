package com.example.myapplication2.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.myapplication2.Adapter.NewsAdapter;
import com.example.myapplication2.Helper.IRetrofit;
import com.example.myapplication2.Helper.RetrofitHelper;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.GetNewsKeywordRequestDTO;
import com.example.myapplication2.dto.GetNewsKeywordResponeseDTO;
import com.example.myapplication2.dto.ListGetAllNewsResponeseDTO;
import com.example.myapplication2.model.News;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabNews extends Fragment {
    IRetrofit iRetrofit;
    ListView listNews;
    Button btnSearch;
    EditText edtSearch;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news,container,false);
        listNews = view.findViewById(R.id.lvNews);
        btnSearch = view.findViewById(R.id.btnSearch);
        edtSearch = view.findViewById(R.id.edtSearch);
        iRetrofit = RetrofitHelper.createService(IRetrofit.class);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onSearch();
            }
        });
        return view;
    }
    public void onSearch(){
        String keyword = edtSearch.getText().toString().trim();
        GetNewsKeywordRequestDTO request = new GetNewsKeywordRequestDTO(keyword);
        iRetrofit.getnewskeyword(request).enqueue(newskeyword);
    }
    @Override
    public void onResume() {
        super.onResume();
        iRetrofit.getallnews().enqueue(getallnews);

    }
    Callback<ListGetAllNewsResponeseDTO> getallnews = new Callback<ListGetAllNewsResponeseDTO>() {
        @Override
        public void onResponse(Call<ListGetAllNewsResponeseDTO> call, Response<ListGetAllNewsResponeseDTO> response) {
            if (response.isSuccessful()) {
                ListGetAllNewsResponeseDTO reponeseDTO = response.body();
                List<ListGetAllNewsResponeseDTO.GetAllNewsResponeseDTO> listAllNews = reponeseDTO.getAllnews();
                ArrayList<News> list = new ArrayList<>();
                for (int i = 0; i < listAllNews.size(); i++) {
                    list.add(new News(listAllNews.get(i).getTitle(),listAllNews.get(i).getResource(),listAllNews.get(i).getDate()));
                }
                NewsAdapter adapter =new NewsAdapter(list, getActivity());
                listNews.setAdapter(adapter);
            }
        }
        @Override
        public void onFailure(Call<ListGetAllNewsResponeseDTO> call, Throwable t) {

        }
    };
    Callback<GetNewsKeywordResponeseDTO> newskeyword = new Callback<GetNewsKeywordResponeseDTO>() {
        @Override
        public void onResponse(Call<GetNewsKeywordResponeseDTO> call, Response<GetNewsKeywordResponeseDTO> response) {
            if (response.isSuccessful()) {
                GetNewsKeywordResponeseDTO reponeseDTO = response.body();
                List<GetNewsKeywordResponeseDTO.GetAllNewsResponeseDTO> listAllNews = reponeseDTO.allthongbao();
                ArrayList<News> list = new ArrayList<>();
                for (int i = 0; i < listAllNews.size(); i++) {
                    list.add(new News(listAllNews.get(i).getTitle(),listAllNews.get(i).getResource(),listAllNews.get(i).getDate()));
                }
                NewsAdapter adapter =new NewsAdapter(list, getActivity());
                listNews.setAdapter(adapter);
            }
        }
        @Override
        public void onFailure(Call<GetNewsKeywordResponeseDTO> call, Throwable t) {

        }
    };

}
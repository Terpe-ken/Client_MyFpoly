package com.example.myapplication2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.DetailLichHocActivity;
import com.example.myapplication2.MainActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllLichHocResponeseDTO;

import java.util.ArrayList;
import java.util.List;

public class LichHocAdapter extends BaseAdapter{
        private List<ListGetAllLichHocResponeseDTO.GetAllLichHocResponeseDTO> listlichhoc;

        public LichHocAdapter(List<ListGetAllLichHocResponeseDTO.GetAllLichHocResponeseDTO> listlichhoc){
            this.listlichhoc = listlichhoc;
        }
        @Override
        public int getCount() {
            return this.listlichhoc.size();
        }

        @Override
        public Object getItem(int i) {
            return this.listlichhoc.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int _i, View _view, ViewGroup _viewGroup) {
            View view = _view;
            if(view == null) {
                view = View.inflate(_viewGroup.getContext(), R.layout.item_schedules, null);
                TextView tvname = view.findViewById(R.id.monhoc);
                TextView tvca = view.findViewById(R.id.mamonhoc);
                TextView tvngay = view.findViewById(R.id.ngayhoc);
                TextView tvdiachi = view.findViewById(R.id.diadiem);
                ViewHolder holder = new ViewHolder(tvname, tvca, tvngay, tvdiachi);
                view.setTag(holder);
            }
            ListGetAllLichHocResponeseDTO.GetAllLichHocResponeseDTO allichhoc = this.listlichhoc.get(_i);
            ViewHolder holder = (ViewHolder) view.getTag();
            holder.tvname.setText(allichhoc.getCourseid());
            holder.tvca.setText(allichhoc.getTeacher() +"");
            holder.tvngay.setText(allichhoc.getDate()+"-Ca "+allichhoc.getCa());
            String toa = allichhoc.getAddress().substring(0,1);
            holder.tvdiachi.setText("Phòng "+ allichhoc.getAddress() + "\n(Nhà " + toa +")");
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(_viewGroup.getContext(), DetailLichHocActivity.class);
                    intent.putExtra("id", allichhoc.getId()+"");
                    intent.putExtra("teacher", allichhoc.getTeacher());
                    _viewGroup.getContext().startActivity(intent);

                }
            });
            return view;
        }

        private static class ViewHolder{
            final TextView tvname;
            final TextView tvca;
            final TextView tvngay;
            final TextView tvdiachi;

            public ViewHolder(TextView tvname, TextView tvca, TextView tvngay, TextView tvdiachi) {
                this.tvname = tvname;
                this.tvca = tvca;
                this.tvngay = tvngay;
                this.tvdiachi = tvdiachi;
            }
        }
    }

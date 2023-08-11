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

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.DetailLichHocActivity;
import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllLichThiResponeseDTO;

import java.util.ArrayList;
import java.util.List;

public class LichThiAdapter extends BaseAdapter {
    private List<ListGetAllLichThiResponeseDTO.GetAllLichThiResponeseDTO> listlichthi;
    public LichThiAdapter(List<ListGetAllLichThiResponeseDTO.GetAllLichThiResponeseDTO> listlichthi){
        this.listlichthi = listlichthi;
    }
    @Override
    public int getCount() {
        return this.listlichthi.size();
    }

    @Override
    public Object getItem(int i) {
        return this.listlichthi.get(i);
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
            TextView tvCourse = view.findViewById(R.id.monhoc);
            TextView tvDate = view.findViewById(R.id.mamonhoc);
            TextView tvCa = view.findViewById(R.id.ngayhoc);
            TextView tvaddress = view.findViewById(R.id.diadiem);
            ViewHolder holder = new ViewHolder(tvCourse, tvDate, tvCa, tvaddress);
            view.setTag(holder);
        }
        ListGetAllLichThiResponeseDTO.GetAllLichThiResponeseDTO allichthi = this.listlichthi.get(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.tvCourse.setText(allichthi.getCourseid()+"");
        holder.tvDate.setText(allichthi.getDate()+"-Ca "+allichthi.getCa());
        String toa = allichthi.getAddress().substring(0,1);
        holder.tvCa.setText(allichthi.getTeacher()+"");
        holder.tvaddress.setText("Phòng "+ allichthi.getAddress() + "\n(Nhà " + toa +")");
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(_viewGroup.getContext(), DetailLichHocActivity.class);
                intent.putExtra("id", allichthi.getId()+"");
                intent.putExtra("teacher", allichthi.getTeacher());
                _viewGroup.getContext().startActivity(intent);
            }
        });
        return view;
    }

    private static class ViewHolder{
        final TextView tvCourse;
        final TextView tvDate;
        final TextView tvCa;
        final TextView tvaddress;

        public ViewHolder(TextView tvCourse, TextView tvDate, TextView tvCa, TextView tvaddress) {
            this.tvCourse = tvCourse;
            this.tvDate = tvDate;
            this.tvCa = tvCa;
            this.tvaddress = tvaddress;
        }
    }
}

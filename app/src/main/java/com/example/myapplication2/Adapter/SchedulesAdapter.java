package com.example.myapplication2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.model.Schedules;

import java.util.ArrayList;

public class SchedulesAdapter extends BaseAdapter {
    public ArrayList<Schedules> listSchedules;
    Context context;

    public SchedulesAdapter(ArrayList<Schedules> listSchedules, Context context) {
        this.listSchedules = listSchedules;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listSchedules.size();
    }

    @Override
    public Object getItem(int i) {
        return listSchedules.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewOfItem{
        TextView diadiem, ngayhoc, monhoc, mamonhoc;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        ViewOfItem viewOfItem;

        if (view == null) {
            viewOfItem = new ViewOfItem();
            view = inflater.inflate(R.layout.item_schedules, viewGroup,false);
            viewOfItem.diadiem = view.findViewById(R.id.diadiem);
            viewOfItem.ngayhoc = view.findViewById(R.id.ngayhoc);
            viewOfItem.monhoc = view.findViewById(R.id.monhoc);
            viewOfItem.mamonhoc = view.findViewById(R.id.mamonhoc);
            view.setTag(viewOfItem);
        }else {
            viewOfItem = (ViewOfItem) view.getTag( );
        }
        viewOfItem.diadiem.setText(listSchedules.get(i).getDiadiem());
        viewOfItem.ngayhoc.setText(listSchedules.get(i).getNgayhoc());
        viewOfItem.monhoc.setText(listSchedules.get(i).getMonhoc());
        viewOfItem.mamonhoc.setText(listSchedules.get(i).getMamonhoc());

        return view;
    }
}

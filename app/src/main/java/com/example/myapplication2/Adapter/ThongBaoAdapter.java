package com.example.myapplication2.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.dto.ListGetAllNewsResponeseDTO;
import com.example.myapplication2.dto.ListgetAllThongBaoResponeseDTO;

import java.util.List;

public class ThongBaoAdapter extends BaseAdapter {
    private List<ListgetAllThongBaoResponeseDTO.getAllThongBaoResponeseDTO> listAllThongBao;
    public ThongBaoAdapter(List<ListgetAllThongBaoResponeseDTO.getAllThongBaoResponeseDTO> listAllThongBao){
        this.listAllThongBao = listAllThongBao;
    }
    @Override
    public int getCount() {
        return listAllThongBao.size();
    }

    @Override
    public Object getItem(int i) {
        return listAllThongBao.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int _i, View _view, ViewGroup _viewGroup) {
        View view = _view;
        if(view == null) {
            view = View.inflate(_viewGroup.getContext(), R.layout.item_notification, null);
            TextView tvtitle = view.findViewById(R.id.title);
            TextView content = view.findViewById(R.id.content);
            TextView date = view.findViewById(R.id.date);
            ViewHolder holder = new ViewHolder(tvtitle, content, date);
            view.setTag(holder);
        }
        ListgetAllThongBaoResponeseDTO.getAllThongBaoResponeseDTO allThongBao =  this.listAllThongBao.get(_i);
        ViewHolder holder = (ViewHolder) view.getTag();
        holder.title.setText(allThongBao.getTitle()+"");
        holder.content.setText(allThongBao.getContent() +"");
        holder.date.setText(allThongBao.getDate()+"");
        return view;
    }

    private static class ViewHolder{
        final TextView title;
        final TextView content;
        final TextView date;

        public ViewHolder(TextView title, TextView content, TextView date) {
            this.title = title;
            this.content = content;
            this.date = date;
        }
    }
}

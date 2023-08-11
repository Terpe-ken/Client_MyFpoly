package com.example.myapplication2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication2.R;
import com.example.myapplication2.model.News;

import java.util.ArrayList;

public class NewsAdapter extends BaseAdapter {
    public ArrayList<News> listNews;
    Context context;

    public NewsAdapter(ArrayList<News> listNews, Context context) {
        this.listNews = listNews;
        this.context = context;
    }

    @Override
    public int getCount() {
        return listNews.size();
    }

    @Override
    public Object getItem(int i) {
        return listNews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    public static class ViewOfItem{
        TextView txtTitleNews, txtResourceNews, txtDate;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        ViewOfItem viewOfItem;

        if(view == null){
            viewOfItem = new ViewOfItem();
            view = inflater.inflate(R.layout.item_news, viewGroup, false);
            viewOfItem.txtTitleNews = view.findViewById(R.id.txtTitleNews);
            viewOfItem.txtResourceNews = view.findViewById(R.id.txtSourceNews);
            viewOfItem.txtDate = view.findViewById(R.id.txtDate);

            view.setTag(viewOfItem);
        }else {
            viewOfItem = (ViewOfItem) view.getTag();
        }
        viewOfItem.txtTitleNews.setText(listNews.get(i).getTitle());
        viewOfItem.txtResourceNews.setText(listNews.get(i).getResource());
        viewOfItem.txtDate.setText(listNews.get(i).getDate());
        return view;

    }
}

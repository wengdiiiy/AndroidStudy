package com.busantoseoul.busan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.busantoseoul.busan.model.Board;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<Board> boards;
    private int layout;

    public MyAdapter(Context context, int layout, List<Board> boards){
        this.context = context;
        this.layout = layout;
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.boards = boards;
    }

    @Override
    public int getCount() {
        return boards.size();
    }

    @Override
    public Object getItem(int position) {
        return boards.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = inflater.inflate(this.layout, parent, false);
        }

        TextView count = (TextView) convertView.findViewById(R.id.count);
        count.setText(boards.get(position).getNum());

        TextView content = (TextView) convertView.findViewById(R.id.content);
        content.setText(boards.get(position).getTitle());

        return convertView;
    }
}
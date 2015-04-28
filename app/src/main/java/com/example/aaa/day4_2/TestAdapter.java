package com.example.aaa.day4_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by aaa on 15-4-16.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.ViewHolder> {
    private Context context;
    private List<String> list;

    public TestAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    //创建
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.text.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView text;
        public ViewHolder(View itemView) {
            super(itemView);
          //  text= (TextView) itemView.findViewById(R.id.tex);
        }
    }

}


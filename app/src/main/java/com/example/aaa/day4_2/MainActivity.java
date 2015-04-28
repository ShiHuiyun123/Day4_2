package com.example.aaa.day4_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;




public class MainActivity extends ActionBarActivity implements View.OnClickListener{
private RecyclerView recyclerView;
    private ImageAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        StaggeredGridLayoutManager manager=new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(manager);
        try {
            String[]images=getAssets().list("images");
            List<String>list=new ArrayList<>();
            list.addAll(Arrays.asList(images));
            adapter=new ImageAdapter(this,list);
            recyclerView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

RecyclerView.ItemAnimator animator =new DefaultItemAnimator();


    @Override
    public void onClick(View v) {
        //可以得到点击对象的位置
  int position= recyclerView.getChildPosition(v);
 // adapter.remove(position);
 adapter.insert(position,"新增一条数据");
    }
}

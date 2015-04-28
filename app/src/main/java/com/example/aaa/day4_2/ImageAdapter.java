package com.example.aaa.day4_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.io.IOException;
import java.util.List;

/**
 * Created by aaa on 15-4-16.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
   private View.OnClickListener listener;
    private Context context;
    private List<String> list;

    public ImageAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
        if(context instanceof View.OnClickListener)
        {
             listener= (View.OnClickListener) context;
        }
    }
    public void insert(int position,String str)
    {
        list.add(position,str);
        notifyItemInserted(position);
    }

    @Override
		//创建视图的种类
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view= null;
        switch(i)
        {case 0:
           view= LayoutInflater.from(context).inflate(R.layout.item,viewGroup,false);
            break;
            case 1:

                view= LayoutInflater.from(context).inflate(R.layout.item_2,viewGroup,false);
                break;
        }

        view.setOnClickListener(listener);
        return new ViewHolder(view);
    }

    @Override
    public int getItemViewType(int position) {

        if(list.get(position).endsWith(".jpg"))//如果是图片以.jpg结尾，采用第一种布局
        {
            return  0;

        }else
        {
            return 1;
        }

    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        if(list.get(i).endsWith(".jpg"))
        {
            try {
                Bitmap bitmap= BitmapFactory.decodeStream(context.getAssets().open("images/"+list.get(i)));
                viewHolder.image.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else
        {
            viewHolder.text.setText(list.get(i));
        }


    }



    @Override
    public int getItemCount() {
        return list.size();
    }
    public void remove(int position)
    {
        list.remove(position);
        notifyItemRemoved(position);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder
    {private TextView text;
        private ImageViewWithWidth image;
        public ViewHolder(View itemView)
        {
            super(itemView);

            image= (ImageViewWithWidth) itemView.findViewById(R.id.image);
            text= (TextView) itemView.findViewById(R.id.text);
        }
    }
}

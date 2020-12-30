package com.example.hello.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hello.R;

public class MyListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mLayoutInflater;
    MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    static class  ViewHolder{
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       ViewHolder holder = null;
        if(convertView == null){
            convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.iv_3);
            holder.tvTitle = convertView.findViewById(R.id.tv_title);
            holder.tvTime = convertView.findViewById(R.id.tv_time);
            holder.tvContent = convertView.findViewById(R.id.tv_content);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        // 给控件赋值
        holder.tvTitle.setText("这是标题");
        holder.tvTime.setText("1088-08-08");
        holder.tvContent.setText("这是内容赋值");
        Glide.with(mContext).load("data:image/png;base64,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").into(holder.imageView);
        return convertView;
    }
}

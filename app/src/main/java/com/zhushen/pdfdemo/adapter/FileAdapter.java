package com.zhushen.pdfdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zhushen.pdfdemo.FileActivity;

import java.util.List;

/**
 * Created by Zhushen on 2018/4/28.
 */
public class FileAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater mInfalter;

    private List<String> data;

    public FileAdapter(Context context) {
        this.context = context;
        mInfalter = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
            viewHolder = new ViewHolder();
//            convertView =
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.title.setText(data.get(position));

        return convertView;
    }

    public class ViewHolder{
        TextView title;

        public TextView getTitle() {
            return title;
        }

        public void setTitle(TextView title) {
            this.title = title;
        }
    }
}

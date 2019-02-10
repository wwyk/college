package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.TzggContact;

import java.util.List;

public class ListAdapter extends BaseAdapter {
    public static final String TAG="ListAdapter";
    private List<TzggContact> mData;
    private Context mcontext;

    public ListAdapter(Context context, List<TzggContact>tzggContactList){
        this.mcontext = context;
        this.mData = tzggContactList;
    }
    @Override
    public int getCount() {
        return mData == null ?0 :mData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View view;
        TzggContact tzggContact = mData.get(position);

        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.tzggTitle = view.findViewById(R.id.btn_show_title);
            viewHolder.tzggDate = view.findViewById(R.id.btn_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.tzggTitle.setText(tzggContact.getTitle());
//        viewHolder.tzggData.setText(tzggContact.getData());
        viewHolder.tzggDate.setText(tzggContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView tzggTitle;
//        TextView tzggData;
        TextView tzggDate;
    }
}

package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.CfbgContact;
import com.example.hp.college.bean.YxxwContact;

import java.util.List;

public class YxxwAdapter extends BaseAdapter {
    public static final String TAG="CfbgAdapter";
    private List<YxxwContact> mData;
    private Context mcontext;
    public YxxwAdapter(Context context, List<YxxwContact>yxxwContactList){
        this.mcontext = context;
        this.mData = yxxwContactList;
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
        YxxwContact yxxwContact = mData.get(position);

        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.yxxwTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.yxxwDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.yxxwTitle.setText(yxxwContact.getTitle());
        viewHolder.yxxwDate.setText(yxxwContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView yxxwTitle;
        TextView yxxwDate;
    }
}

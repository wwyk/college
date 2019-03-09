package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.XsjzContact;
import com.example.hp.college.bean.XxgkContact;

import java.util.List;


public class XsjzAdapter extends BaseAdapter {
    public static final String TAG="XxgkAdapter";
    private List<XsjzContact> mData;
    private Context mcontext;
    public XsjzAdapter(Context context, List<XsjzContact>xsjzContactList){
        this.mcontext = context;
        this.mData = xsjzContactList;
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
        XsjzAdapter.ViewHolder viewHolder;
        View view;
        XsjzContact xsjzContact = mData.get(position);
        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new XsjzAdapter.ViewHolder();
            viewHolder.xsjzTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.xsjzDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (XsjzAdapter.ViewHolder) view.getTag();
        }
        viewHolder.xsjzTitle.setText(xsjzContact.getTitle());
        viewHolder.xsjzDate.setText(xsjzContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView xsjzTitle;
        TextView xsjzDate;
    }
}

package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.XxgkContact;

import java.util.List;


public class XxgkAdapter extends BaseAdapter {
    public static final String TAG="XxgkAdapter";
    private List<XxgkContact> mData;
    private Context mcontext;
    public XxgkAdapter(Context context, List<XxgkContact>xxgkContactList){
        this.mcontext = context;
        this.mData = xxgkContactList;
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
        XxgkAdapter.ViewHolder viewHolder;
        View view;
        XxgkContact xxgkContact = mData.get(position);
        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new XxgkAdapter.ViewHolder();
            viewHolder.xxgkTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.xxgkDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (XxgkAdapter.ViewHolder) view.getTag();
        }
        viewHolder.xxgkTitle.setText(xxgkContact.getTitle());
        viewHolder.xxgkDate.setText(xxgkContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView xxgkTitle;
        TextView xxgkDate;
    }
}

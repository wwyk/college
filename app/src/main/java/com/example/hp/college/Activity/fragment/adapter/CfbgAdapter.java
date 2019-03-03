package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.CfbgContact;

import java.util.List;

public class CfbgAdapter extends BaseAdapter {
    public static final String TAG="CfbgAdapter";
    private List<CfbgContact> mData;
    private Context mcontext;
    public CfbgAdapter(Context context, List<CfbgContact>cfbgContactList){
        this.mcontext = context;
        this.mData = cfbgContactList;
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
        CfbgContact cfbgContact = mData.get(position);

        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.cfbgTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.cfbgDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.cfbgTitle.setText(cfbgContact.getTitle());
//        viewHolder.tzggData.setText(tzggContact.getData());
        viewHolder.cfbgDate.setText(cfbgContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView cfbgTitle;
//        TextView tzggData;
        TextView cfbgDate;
    }
}

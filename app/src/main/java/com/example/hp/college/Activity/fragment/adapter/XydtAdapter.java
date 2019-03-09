package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.XydtContact;

import java.util.List;

public class XydtAdapter extends BaseAdapter {
    public static final String TAG="CfbgAdapter";
    private List<XydtContact> mData;
    private Context mcontext;
    public XydtAdapter(Context context, List<XydtContact>xydtContactList){
        this.mcontext = context;
        this.mData = xydtContactList;
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
        XydtContact xydtContact = mData.get(position);

        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new ViewHolder();
            viewHolder.xydtTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.xydtDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.xydtTitle.setText(xydtContact.getTitle());
        viewHolder.xydtDate.setText(xydtContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView xydtTitle;
        TextView xydtDate;
    }
}

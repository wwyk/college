package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.XmcgContact;
import com.example.hp.college.bean.XxgkContact;

import java.util.List;


public class XmcgAdapter extends BaseAdapter {
    public static final String TAG="XxgkAdapter";
    private List<XmcgContact> mData;
    private Context mcontext;
    public XmcgAdapter(Context context, List<XmcgContact>xmcgContactList){
        this.mcontext = context;
        this.mData = xmcgContactList;
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
        XmcgAdapter.ViewHolder viewHolder;
        View view;
        XmcgContact xmcgContact = mData.get(position);
        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new XmcgAdapter.ViewHolder();
            viewHolder.xmcgTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.xmcgDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (XmcgAdapter.ViewHolder) view.getTag();
        }
        viewHolder.xmcgTitle.setText(xmcgContact.getTitle());
        viewHolder.xmcgDate.setText(xmcgContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView xmcgTitle;
        TextView xmcgDate;
    }
}

package com.example.hp.college.Activity.fragment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.bean.KydtContact;
import com.example.hp.college.bean.XxgkContact;

import java.util.List;


public class KydtAdapter extends BaseAdapter {
    public static final String TAG="KydtAdapter";
    private List<KydtContact> mData;
    private Context mcontext;
    public KydtAdapter(Context context, List<KydtContact>kydtContactList){
        this.mcontext = context;
        this.mData = kydtContactList;
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
        KydtAdapter.ViewHolder viewHolder;
        View view;
        KydtContact kydtContact = mData.get(position);
        if(convertView == null){
            view = LayoutInflater.from(mcontext).inflate(R.layout.item1_layout,null);
            viewHolder = new KydtAdapter.ViewHolder();
            viewHolder.kydtTitle = view.findViewById(R.id.cfbg_show_title);
            viewHolder.kydtDate = view.findViewById(R.id.cfbg_show_date);

            view.setTag(viewHolder);

        }else {
            view = convertView;
            viewHolder = (KydtAdapter.ViewHolder) view.getTag();
        }
        viewHolder.kydtTitle.setText(kydtContact.getTitle());
        viewHolder.kydtDate.setText(kydtContact.getDate());
        return view;
    }
    class ViewHolder {
        TextView kydtTitle;
        TextView kydtDate;
    }
}

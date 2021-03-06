package com.example.hp.college.Activity.fragment.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hp.college.Activity.fragment.adapter.CfbgAdapter;
import com.example.hp.college.Activity.fragment.adapter.ListAdapter;
import com.example.hp.college.Activity.fragment.chufangbaogaoActivity;
import com.example.hp.college.Activity.fragment.tongzhigaonggaoActivity;
import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;
import com.example.hp.college.bean.CfbgContact;
import com.example.hp.college.bean.TzggContact;
import com.example.hp.college.util.DaoManager;

import java.util.List;

/**
 * Created by HP on 2019/1/7.
 */

public class ShouyePageFragment extends Fragment {
    private static final String TAG = "ShouyeFragment";
    ListView listView;
    ListAdapter listAdapter;
    CfbgAdapter cfbgAdapter;
    private List<TzggContact> tzggContacts;
    private List<CfbgContact> cfbgContacts;
    private String title;
    private String data;
    private String datetime;
    private ImageView technology,news,teacher,college;
    public ShouyePageFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDatas();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shouye_main, container, false);
//        init();

        initView(view);
        initListener();
        return view;

    }

    private void initListener() {
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.TEC_ACTION);
                startActivity(intent);
            }
        });
        news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.NEWS_ACTION);
                startActivity(intent);
            }
        });
        college.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.COLLEGE_ACTION);
                startActivity(intent);
            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.TEA_ACTION);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState) {
        super.onActivityCreated(saveInstanceState);
    }

    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getActivity());
        tzggContacts = daoManager.getTzggContactDao().queryBuilder().list();
        cfbgContacts = daoManager.getCfbgContactDao().queryBuilder().list();
    }

    private void initView(View view) {
        technology = view.findViewById(R.id.technology);
        news = view.findViewById(R.id.news);
        college = view.findViewById(R.id.college);
        teacher = view.findViewById(R.id.teacher);
        ListView tzgg = view.findViewById(R.id.tzgg_listView);
        listAdapter = new ListAdapter(ShouyePageFragment.this.getActivity(), tzggContacts);
        tzgg.setAdapter(listAdapter);
        tzgg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TzggContact tzggContact = tzggContacts.get(position);
                title = tzggContact.getTitle();
                data = tzggContact.getData();
                datetime = tzggContact.getDate();
                Intent intent = new Intent(getActivity(), tongzhigaonggaoActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
        ListView cfbg = view.findViewById(R.id.cfbg_listView);
        cfbgAdapter = new CfbgAdapter(ShouyePageFragment.this.getActivity(), cfbgContacts);
        cfbg.setAdapter(cfbgAdapter);
        cfbg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                CfbgContact cfbgContact = cfbgContacts.get(position);
                title = cfbgContact.getTitle();
                data = cfbgContact.getData();
                datetime = cfbgContact.getDate();
//                datetime = cfbgContact.getDate(ShouyePageFragment.this);
                Intent intent = new Intent(getActivity(), chufangbaogaoActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
    }

    private void init() {
//        DaoManager daoManager = DaoManager.getInstance();
//        daoManager.init(getActivity().getApplicationContext());
//        TzggContactDao tzggContactDao = daoManager.getTzggContactDao();
//        List<TzggContact> tzggContacts = tzggContactDao.queryBuilder().list();
//        for (TzggContact tzggContact : tzggContacts) {
//            Log.i(TAG, "title = " + tzggContact.getTitle());
//            Log.i(TAG, "data = " + tzggContact.getData());
//            Log.i(TAG, "date = " + tzggContact.getDate(ShouyePageFragment.this));
////            Log.i(TAG, "date = " + tzggContact.getDate(ShezhiPageFragment.this));
//        }
//        CfbgContactDao cfbgContactDao = daoManager.getCfbgContactDao();
//        List<CfbgContact> cfbgContacts = cfbgContactDao.queryBuilder().list();
//        for (CfbgContact cfbgContact : cfbgContacts){
//            Log.i(TAG, "title = " + cfbgContact.getTitle());
//            Log.i(TAG, "data = " + cfbgContact.getData());
//            Log.i(TAG, "date = " + cfbgContact.getDate(ShouyePageFragment.this));
//
//        }
    }
}
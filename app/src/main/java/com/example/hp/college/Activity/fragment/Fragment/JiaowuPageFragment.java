package com.example.hp.college.Activity.fragment.Fragment;

/**
 * Created by HP on 2019/1/6.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.hp.college.Activity.fragment.adapter.XsjzAdapter;
import com.example.hp.college.Activity.fragment.xsjzActivity;
import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;
import com.example.hp.college.bean.XsjzContact;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.XsjzContactDao;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class JiaowuPageFragment extends Fragment {
    private static final String TAG = "JiaowuPageFragment";
    private ImageView iv_tel,iv_citiao,iv_schoolkaikuang,iv_rli,iv_schoolmap;
    XsjzAdapter xsjzAdapter;
    private List<XsjzContact> xsjzContacts;
    private String title;
    private String data;
    private String datetime;


    public JiaowuPageFragment(){
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getActivity());
        DaoSession daoSession = daoManager.getDaoSession();
//        XsjzContactDao xsjzContactDao = daoSession.getXsjzContactDao();
//        XsjzContact xsjzContact = new XsjzContact();
//        xsjzContact.setTitle("");
//        xsjzContact.setData(");
//                xsjzContact.setDate("2019-03-08");
//        xsjzContactDao.insert(xsjzContact);
//        xsjzContactDao.save(xsjzContact);
        initDatas();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jiaowu_main,container,false);
        init();
        initView(view);
        initListener();
        return view;
    }

    private void init() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getActivity().getApplicationContext());
        XsjzContactDao xsjzContactDao = daoManager.getXsjzContactDao();
        List<XsjzContact> xsjzContacts = xsjzContactDao.queryBuilder().list();
        for (XsjzContact xsjzContact : xsjzContacts) {
            Log.i(TAG, "title = " + xsjzContact.getTitle());
            Log.i(TAG, "data = " + xsjzContact.getData());
//            Log.i(TAG, "date = " + xsjzContact.getDate(JiaowuPageFragment.this));
//            Log.i(TAG, "date = " + xsjzContact.getDate(ShezhiPageFragment.this));
        }
    }

    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
    }
    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getActivity());
        xsjzContacts = daoManager.getXsjzContactDao().queryBuilder().list();
    }

    private void initListener() {
        iv_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("Intent.ACTION_DIAL");
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:61900100"));
                startActivity(intent);
            }
        });
        iv_citiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6/1273892?fr=aladdin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        iv_schoolkaikuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.shou.edu.cn/xxgk_93/list.htm");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        iv_rli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_schoolmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri uri = Uri.parse("https://www.shou.edu.cn/xydt/list.htm");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                Intent intent = new Intent(Constants.SMAP_ACTION);
                startActivityForResult(intent,3);
            }
        });
    }

    private void initView(View view) {
        iv_tel = view.findViewById(R.id.btn_tel);
        iv_citiao = view.findViewById(R.id.btn_citiao);
        iv_schoolkaikuang = view.findViewById(R.id.btn_schoolkaikuang);
        iv_rli = view.findViewById(R.id.btn_rli);
        iv_schoolmap = view.findViewById(R.id.btn_schoolmap);

        ListView xsjz = view.findViewById(R.id.xsjz_listView);
        xsjzAdapter = new XsjzAdapter(JiaowuPageFragment.this.getActivity(), xsjzContacts);
        xsjz.setAdapter(xsjzAdapter);
        xsjz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XsjzContact xsjzContact = xsjzContacts.get(position);
                title = xsjzContact.getTitle();
                data = xsjzContact.getData();
                datetime = xsjzContact.getDate();
                Intent intent = new Intent(getActivity(),xsjzActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
    }


}
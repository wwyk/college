package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.college.Activity.fragment.adapter.XydtAdapter;
import com.example.hp.college.R;
import com.example.hp.college.bean.XydtContact;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.XydtContactDao;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class collegeActivity extends AppCompatActivity{
    private static final String TAG = "collegeActivity";
    XydtAdapter xydtAdapter;
    private List<XydtContact> xydtContacts;
    private String title;
    private String data;
    private String datetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.college_main);
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(collegeActivity.this);
        DaoSession daoSession = daoManager.getDaoSession();
        //tzgg添加
//        XydtContactDao xydtContactDao = daoSession.getXydtContactDao();
//        XydtContact xydtContact = new XydtContact();
//        xydtContact.setTitle("工程学院2019年大学生创新创业项目答辩会顺利开展");
//        xydtContact.setData("为进一步促进学生参与科研训练的热情，激发学生的创新精神和实践能力，2019年3月5日，工程学院2019年大学生创新创业项目答辩会于第二教学楼顺利举行，共计83个小组参与本次项目申报答辩会，同时学院20名老师作为评委出席了此次项目答辩会。" +
//                "项目答辩分项目陈述、评委提问两个环节。答辩伊始，各个项目团队就项目的立项背景、目的意义、研究方法、研究计划及预期成果等方面进行了陈述与展示。评委老师根据项目材料和答辩现场展示就相关问题进行了提问，并从进一步完善项目的角度提供了参考性的建议，鼓励各项目小组进一步优化项目研究，丰富项目内容。\n" +
//                "\n" +
//                "本次答辩会的顺利举办一方面有利于激发学生的创新思维、创新意识和实践能力，另一方面增强了学生与学业导师、科创指导老师之间的交流，进一步发挥了科研育人功效。在此，也希望我院学子在科创之路上再创佳绩！\n");
//        xydtContact.setDate("2019-03-17");
//        xydtContactDao.insert(xydtContact);
//        xydtContactDao.save(xydtContact);

        initDatas();
        init();
        initView();
    }
    private void initView() {
        ListView xydt = findViewById(R.id.college_listView);
        xydtAdapter = new XydtAdapter(collegeActivity.this, xydtContacts);
        xydt.setAdapter(xydtAdapter);
        xydt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XydtContact xydtContact = xydtContacts.get(position);
                title = xydtContact.getTitle();
                data = xydtContact.getData();
                datetime = xydtContact.getDate();
                Intent intent = new Intent(collegeActivity.this,xydtActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
    }
    private void init() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        XydtContactDao xydtContactDao = daoManager.getXydtContactDao();
        List<XydtContact> xydtContacts = xydtContactDao.queryBuilder().list();
        for (XydtContact xydtContact : xydtContacts) {
            Log.i(TAG, "title = " + xydtContact.getTitle());
            Log.i(TAG, "data = " + xydtContact.getData());
//            Log.i(TAG, "date = " + xsjzContact.getDate(JiaowuPageFragment.this));
//            Log.i(TAG, "date = " + xsjzContact.getDate(ShezhiPageFragment.this));
        }
    }

    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        xydtContacts = daoManager.getXydtContactDao().queryBuilder().list();
    }
}

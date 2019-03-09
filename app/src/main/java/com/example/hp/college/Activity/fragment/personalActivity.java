package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;
import com.example.hp.college.bean.StudentsContact;
import com.example.hp.college.bean.dao.StudentsContactDao;
import com.example.hp.college.util.CustomToolBar;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class personalActivity extends AppCompatActivity {
    private static final String TAG = "personalActivity";
    TextView tv_stuname,tv_usernum,tv_username;
    private List<StudentsContact> studentsContacts;

    CustomToolBar customToolBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personal_main);

        init();
        initView();
        initData();
        initListener();
    }

    private void initData() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(personalActivity.this);
        studentsContacts = daoManager.getStudentsContactDao().queryBuilder().list();

        tv_stuname.setText(studentsContacts.get(0).getStuname());
        tv_usernum.setText(studentsContacts.get(0).getUsername());
        tv_username.setText(studentsContacts.get(0).getUsername());
    }

    private void init() {
        Log.i(TAG,"personalActivity+init()");
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        StudentsContactDao studentsContactDao = daoManager.getStudentsContactDao();

        List<StudentsContact> studentsContacts = studentsContactDao.queryBuilder().list();
        for (StudentsContact studentsContact : studentsContacts) {
            Log.i(TAG,"ID"+studentsContact.getId());
            Log.i(TAG, "name = " + studentsContact.getStuname());
            Log.i(TAG, "username = " + studentsContact.getUsername());
            Log.i(TAG, "usernum = " + studentsContact.getUsername());
        }
    }

    private void initView() {
        customToolBar = findViewById(R.id.act_tb_gerenxinxi);
        tv_stuname = findViewById(R.id.tv_stuname);
        tv_usernum = findViewById(R.id.tv_usernum);
        tv_username = findViewById(R.id.tv_username);
    }

    private void initListener() {
        customToolBar.setOnLeftIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.LOGIN_ACTION);
                startActivity(intent);
                finish();
            }
        });
    }
}

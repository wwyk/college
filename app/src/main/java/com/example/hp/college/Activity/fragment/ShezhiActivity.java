package com.example.hp.register;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.register.bean.StudentsContact;
import com.example.hp.register.bean.dao.DaoSession;
import com.example.hp.register.bean.dao.StudentsContactDao;
import com.example.hp.register.util.DaoManager;

import java.util.List;

public class ShezhiActivity extends AppCompatActivity {
    private static final String TAG ="ShezhiActivity" ;
    private EditText act_et_uname,act_et_psw;
    private Button btn_login;
    private List<StudentsContact> studentsContacts;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shezhi_main);
//        DaoManager daoManager = DaoManager.getInstance();
//        daoManager.init(ShezhiActivity.this);
//        DaoSession daoSession = daoManager.getDaoSession();
//        StudentsContactDao studentsContactDao = daoSession.getStudentsContactDao();
//        StudentsContact studentsContact = new StudentsContact();
//        studentsContact.setStuname("王彦凯");
//        studentsContact.setUsername("1551318");
//        studentsContact.setUserpsw("1551318");
//        studentsContactDao.insert(studentsContact);
//        studentsContactDao.save(studentsContact);
        initViews();
        initListener();
        firstRun();
    }

    private void firstRun() {
        SharedPreferences sharedPreferences = getSharedPreferences("FirstRun",0);
        Boolean first_run = sharedPreferences.getBoolean("First",true);
        if (first_run){
            sharedPreferences.edit().putBoolean("First",false).commit();
            Log.i(TAG,"第一次");
            DaoManager daoManager = DaoManager.getInstance();
            daoManager.init(ShezhiActivity.this);
            DaoSession daoSession = daoManager.getDaoSession();
            StudentsContactDao studentsContactDao = daoSession.getStudentsContactDao();
            StudentsContact studentsContact = new StudentsContact();
            studentsContact.setStuname("王彦凯");
            studentsContact.setUsername("1551318");
            studentsContact.setUserpsw("1551318");
            studentsContactDao.insertOrReplace(studentsContact);
        }
        else {
            Log.i(TAG,"不是第一次");
        }

    }

    private void initViews() {
        btn_login = findViewById(R.id.btn_login);
        act_et_uname = findViewById(R.id.act_et_uname);
        act_et_psw = findViewById(R.id.act_et_psw);

//        sharedPreferencesHelper = new SharedPreferencesHelper(this.getApplicationContext());
//        sharedPreferencesHelper.open(FILE_NAME);
//        isFirstRun = ! sharedPreferencesHelper.getBoolean(KEY);
//        if(isFirstRun){
//            //第一次运行
//            Log.i(TAG, "First Time Run Application");
//
//            DaoManager daoManager = DaoManager.getInstance();
//            daoManager.init(ShezhiActivity.this);
//            DaoSession daoSession = daoManager.getDaoSession();
//            StudentsContactDao studentsContactDao = daoSession.getStudentsContactDao();
//            StudentsContact studentsContact = new StudentsContact();
//            studentsContact.setStuname("王彦凯");
//            studentsContact.setUsername("1551318");
//            studentsContact.setUserpsw("1551318");
//            studentsContactDao.insertOrReplace(studentsContact);
//            studentsContactDao.save(studentsContact);



            //            Constants.Stu.setId();
//            Constants.Stu.setStuname("王彦凯");
//            Constants.Stu.setUsername("1551318");
//            Constants.Stu.setUserpsw("1551317");
//            studentsContactDao.insertOrReplace(Constants.Stu);

//
//            Stu.setStuname("王彦凯");
//            Stu.setUsername("1551318");
//            Stu.setUserpsw("1551318");
//            startActivityForResult(intent, Constants.REQUEST_CODE);
//        }

    }

    private void initListener() {
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DaoManager daoManager = DaoManager.getInstance();
                studentsContacts = daoManager.getStudentsContactDao().queryBuilder().list();
                String name = act_et_uname.getText().toString().trim();
                String password = act_et_psw.getText().toString().trim();
                if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)) {
                    List<StudentsContact> data = studentsContacts;
                    boolean match = false;
                    for (int i = 0; i < data.size(); i++) {
                        StudentsContact studentsContact = data.get(i);
                        if (name.equals(studentsContact.getUsername()) && password.equals(studentsContact.getUserpsw())) {
                            match = true;
                            break;
                        } else {
                            match = false;
                        }
                    }
                    if (match) {
                        Toast.makeText(ShezhiActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ShezhiActivity.this, loginActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(ShezhiActivity.this, "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ShezhiActivity.this, "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}


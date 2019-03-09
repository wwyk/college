package com.example.hp.register;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.register.Constans.Constants;
import com.example.hp.register.bean.StudentsContact;
import com.example.hp.register.bean.dao.StudentsContactDao;
import com.example.hp.register.util.CustomToolBar;
import com.example.hp.register.util.DaoManager;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class changedpswActivity extends AppCompatActivity {
    private static final String TAG = "changedpswActivity";
    EditText et_original_psw, et_new_psw, et_again_new_psw;
    private Button btn_confrimchanged;
    CustomToolBar customToolBar;
    StudentsContact Stu;
    StudentsContact studentsContact;
    private List<StudentsContact> studentsContacts;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changedpsw);
        initDatas();
        initView();
        initListener();
        initput();


    }
    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        studentsContacts = daoManager.getStudentsContactDao().queryBuilder().list();
    }


    private void initput() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        StudentsContactDao studentsContactDao = daoManager.getStudentsContactDao();
        List<StudentsContact> studentsContacts = studentsContactDao.queryBuilder().list();
        for (StudentsContact studentsContact : studentsContacts) {
            Log.i(TAG,"ID"+studentsContact.getId());
            Log.i(TAG, "stuname = " + studentsContact.getStuname());
            Log.i(TAG, "Username = " + studentsContact.getUsername());
            Log.i(TAG, "Userpsw = " + studentsContact.getUserpsw());
        }
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
        btn_confrimchanged.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String psw = et_original_psw.getText().toString().trim();
                String newpsw = et_new_psw.getText().toString().trim();
                String again = et_again_new_psw.getText().toString().trim();
                if (TextUtils.isEmpty(psw)) {
                    Toast.makeText(changedpswActivity.this, "请输入原始密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!psw.equals(studentsContacts.get(0).getUserpsw())){
                    Toast.makeText(changedpswActivity.this, "输入的密码与原始密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }else if (newpsw.equals(studentsContacts.get(0).getUserpsw())){
                    Toast.makeText(changedpswActivity.this, "输入的新密码与原始密码一致", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(newpsw)){
                    Toast.makeText(changedpswActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                }else if (TextUtils.isEmpty(again)){
                    Toast.makeText(changedpswActivity.this, "请再次输入新密码", Toast.LENGTH_SHORT).show();
                }else if (!newpsw.equals(again)){
                    Toast.makeText(changedpswActivity.this, "输入新密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    DaoManager daoManager = DaoManager.getInstance();
                    daoManager.init(changedpswActivity.this);
                    StudentsContactDao studentsContactDao = daoManager.getStudentsContactDao();
                    StudentsContact studentsContact =studentsContactDao.queryBuilder()
                            .where(StudentsContactDao.Properties.Id.eq(studentsContacts.get(0).getId())).unique();
                    studentsContact.setUserpsw(newpsw);
                    Log.i(TAG,"修改了"+studentsContact.getId());
                    Log.i(TAG,"修改为"+newpsw);
                    studentsContactDao.delete(studentsContact);
                    studentsContact.setId(studentsContact.getId());
                    studentsContact.setUsername(studentsContact.getUsername());
                    studentsContact.setUserpsw(studentsContact.getUserpsw());
                    studentsContactDao.insertOrReplace(studentsContact);


                    Toasty.success(changedpswActivity.this,"新密码设置成功",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(changedpswActivity.this,ShezhiActivity.class);
                    startActivity(intent);
                    Log.i(TAG,"已经修改密码");
                    Log.i(TAG,"修改后的密码"+studentsContacts.get(0).getUserpsw());

                    finish();
                }
            }
        });
    }

    private void initView() {
        customToolBar = findViewById(R.id.act_tb_changedpsw);
        et_original_psw = findViewById(R.id.et_original_psw);
        et_new_psw = findViewById(R.id.et_new_psw);
        et_again_new_psw = findViewById(R.id.et_again_new_psw);
        btn_confrimchanged = findViewById(R.id.btn_confrimchanged);
    }
}

package com.example.hp.college.Activity.fragment.Fragment;

/**
 * Created by HP on 2019/1/6.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hp.college.Activity.fragment.loginActivity;
import com.example.hp.college.R;
import com.example.hp.college.bean.StudentsContact;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.StudentsContactDao;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class ShezhiPageFragment extends Fragment {
    private static final String TAG ="ShezhiActivity" ;
    private EditText act_et_uname,act_et_psw;
    private Button btn_login;
    private List<StudentsContact> studentsContacts;


    public ShezhiPageFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shezhi_main,container,false);
        return view;
    }
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);
        initView();
        initListener();
        firstRun();
    }

    private void firstRun() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("FirstRun",0);
        Boolean first_run = sharedPreferences.getBoolean("First",true);
        if (first_run){
            sharedPreferences.edit().putBoolean("First",false).commit();
            Log.i(TAG,"第一次");
            DaoManager daoManager = DaoManager.getInstance();
            daoManager.init(getActivity());
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
                        Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
                        //TODO
                        Intent intent = new Intent(getActivity(), loginActivity.class);
                        startActivityForResult(intent,1);
                        //TODO
//                        finish();
                    } else {
                        Toast.makeText(getActivity(), "用户名或密码不正确，请重新输入", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "请输入你的用户名或密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initView() {
        btn_login = getView().findViewById(R.id.btn_login);
        act_et_uname = getView().findViewById(R.id.act_et_uname);
        act_et_psw = getView().findViewById(R.id.act_et_psw);
    }

}

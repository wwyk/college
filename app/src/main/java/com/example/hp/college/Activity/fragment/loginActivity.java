package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;


public class loginActivity extends AppCompatActivity {
    private TextView act_tv_chagnedpse,act_tv_personal;
    private Button act_btn_logout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        initViews();
        initListener();
    }

    private void initListener() {
        act_tv_chagnedpse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.CHANGEDPSW_ACTION);
                startActivity(intent);
            }
        });
        act_tv_personal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.PERSONAL_ACTION);
                startActivity(intent);
            }
        });
        act_btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this,MainActivity.class);
                setResult(2,intent);
                finish();
//                Intent intent = new Intent(loginActivity.this,ShezhiPageFragment.class);
//                startActivity(intent);
//                finish();
            }
        });
    }

    private void initViews() {
        act_tv_chagnedpse  = findViewById(R.id.act_tv_changedpsw);
        act_tv_personal = findViewById(R.id.act_tv_personal);
        act_btn_logout= findViewById(R.id.act_btn_logout);

    }
}

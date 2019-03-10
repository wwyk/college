package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;
import com.example.hp.college.util.CustomToolBar;

public class aboutusActivity extends AppCompatActivity {
    CustomToolBar customToolBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus);
        initView();
        initListeners();

    }

    private void initListeners() {
        customToolBar.setOnLeftIconClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Constants.LOGIN_ACTION);
                startActivity(intent);
                finish();
            }
        });
    }

    private void initView() {
        customToolBar = findViewById(R.id.act_tb_aboutus);
    }
}

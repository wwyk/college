package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class xsjzActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView xsjz_title;
    private TextView xsjz_datetime;
    private TextView xsjz_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xsjz);

        xsjz_title = findViewById(R.id.xsjz_title);
        xsjz_datetime = findViewById(R.id.xsjz_datetime);
        xsjz_data = findViewById(R.id.xsjz_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        xsjz_title.setText(title);
        data = bundle.getString("data");
        xsjz_data.setText(data);
        datetime = bundle.getString("datetime");
        xsjz_datetime.setText(datetime);
    }

}

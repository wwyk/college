package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class xydtActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView xydt_title;
    private TextView xydt_datetime;
    private TextView xydt_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xydt);

        xydt_title = findViewById(R.id.xydt_title);
        xydt_datetime = findViewById(R.id.xydt_datetime);
        xydt_data = findViewById(R.id.xydt_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        xydt_title.setText(title);
        data = bundle.getString("data");
        xydt_data.setText(data);
        datetime = bundle.getString("datetime");
        xydt_datetime.setText(datetime);
    }

}

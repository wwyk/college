package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class chufangbaogaoActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView cfbg_title;
    private TextView cfbg_datetime;
    private TextView cfbg_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.chufangbaogao);

        cfbg_title = findViewById(R.id.cfbg_title);
        cfbg_datetime = findViewById(R.id.cfbg_datetime);
        cfbg_data = findViewById(R.id.cfbg_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        cfbg_title.setText(title);
        data = bundle.getString("data");
        cfbg_data.setText(data);
        datetime = bundle.getString("datetime");
        cfbg_datetime.setText(datetime);
    }

}

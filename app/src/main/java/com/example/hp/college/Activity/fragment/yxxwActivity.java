package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class yxxwActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView yxxw_title;
    private TextView yxxw_datetime;
    private TextView yxxw_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.yxxw);

        yxxw_title = findViewById(R.id.yxxw_title);
        yxxw_datetime = findViewById(R.id.yxxw_datetime);
        yxxw_data = findViewById(R.id.yxxw_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        yxxw_title.setText(title);
        data = bundle.getString("data");
        yxxw_data.setText(data);
        datetime = bundle.getString("datetime");
        yxxw_datetime.setText(datetime);
    }

}

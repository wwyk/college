package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class kydtActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView kydt_title;
    private TextView kydt_datetime;
    private TextView kydt_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.kydt);

        kydt_title = findViewById(R.id.kydt_title);
        kydt_datetime = findViewById(R.id.kydt_datetime);
        kydt_data = findViewById(R.id.kydt_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        kydt_title.setText(title);
        data = bundle.getString("data");
        kydt_data.setText(data);
        datetime = bundle.getString("datetime");
        kydt_datetime.setText(datetime);
    }

}

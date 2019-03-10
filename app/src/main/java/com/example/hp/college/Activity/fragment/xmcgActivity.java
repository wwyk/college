package com.example.hp.college.Activity.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.hp.college.R;


public class xmcgActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView xmcg_title;
    private TextView xmcg_datetime;
    private TextView xmcg_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xmcg);

        xmcg_title = findViewById(R.id.xmcg_title);
        xmcg_datetime = findViewById(R.id.xmcg_datetime);
        xmcg_data = findViewById(R.id.xmcg_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        xmcg_title.setText(title);
        data = bundle.getString("data");
        xmcg_data.setText(data);
        datetime = bundle.getString("datetime");
        xmcg_datetime.setText(datetime);
    }

}

package com.example.hp.college;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


public class tongzhigaonggaoActivity extends AppCompatActivity {
    private int id;
    private String data;
    private String datetime;
    private String title;

    private TextView tzgg_title;
    private TextView tzgg_datetime;
    private TextView tzgg_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.tongzhigonggao);

        tzgg_title = (TextView) findViewById(R.id.tzgg_title);
        tzgg_datetime = (TextView) findViewById(R.id.tzgg_datetime);
        tzgg_data = (TextView) findViewById(R.id.tzgg_data);


        Intent intent = getIntent();
        final Bundle bundle = intent.getExtras();
        title = bundle.getString("title");
        tzgg_title.setText(title);
        data = bundle.getString("data");
        tzgg_data.setText(data);
        datetime = bundle.getString("datetime");
        tzgg_datetime.setText(datetime);
    }

}

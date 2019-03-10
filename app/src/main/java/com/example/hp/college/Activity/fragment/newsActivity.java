package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.college.Activity.fragment.adapter.YxxwAdapter;
import com.example.hp.college.R;
import com.example.hp.college.bean.YxxwContact;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.YxxwContactDao;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class newsActivity extends AppCompatActivity{
    private static final String TAG = "newsActivity";
    YxxwAdapter yxxwAdapter;//校园新闻
    private List<YxxwContact> yxxwContacts;
    private String title;
    private String data;
    private String datetime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_main);
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(newsActivity.this);
        DaoSession daoSession = daoManager.getDaoSession();
        //tzgg添加
//        YxxwContactDao yxxwContactDao = daoSession.getYxxwContactDao();
//        YxxwContact yxxwContact = new YxxwContact();
//        yxxwContact.setTitle("图书馆直属党支部开展主题党日活动");
//        yxxwContact.setData("为学习贯彻习近平新时代中国特色社会主义思想，推动全面从严治党向纵深发展，进一步规范党内政治生活，强化党员教育管理，提升支部活力，图书馆直属党支部于3月4日召开“学习习近平中国特色社会主义思想，做好党员民主评议”的主题党日活动。图书馆直属党支部全体党员参加，活动由支部书记高晓波主持。" +
//                "高晓波带领全体党员从“坚持实事求是、坚持战略定位、坚持问题导向、坚持全面协调、坚持底线思维、坚持调查研究、坚持抓铁有痕、坚持历史担当”八个方面对马克思主义思想方法和工作方法进行了深入解读，有效指导图书馆的工作。不断提高运用马克思主义立场、观点、方法分析和解决实际问题的能力，要深入基层、解放思想、稳中求进、勇于变革，以更宽广的视野、更长远的眼光来思考把握工作面临的一系列问题，为提升工作质量，助推内涵式发展贡献力量。\n" +
//                "\n" +
//                "支部党员代表夏伯平、刘金立、胡怡明分享学习心得体会。各位代表结合实际工作，辩证地分析了面临的问题和改进的思考，图书馆的工作要以读者为导向，提高透过现象看本质的问题分析能力；要守住安全意识的底线；要多调研多听取群众意见。坚持主动学习，在习近平新时代中国特色社会主义思想指引下，认识规律，不断创新。\n" +
//                "\n" +
//                "按照学校党委的统一部署，高晓波对开展专题组织生活会和党员民主评议工作进行了动员。明确会前准备、会议时间和会议议程，要求全体党员做好批评与自我批评的发言准备，高度重视此项工作，务必要以务实、高效、严谨的工作态度，严格按照既定方案开展。\n" +
//                "\n" +
//                "结合“3月5日学雷锋”活动，经过支委会讨论决定，全体党员于3月5日开展志愿服务工作，全面盘点图书馆家具、设备等固定资产。提高全体党员无私奉献的志愿服务意识，发挥党员先锋模范作用，增强支部的凝聚力。 \n" +
//                "\n" +
//                "最后，全体党员按照核定标准缴纳党费。\n");
//        yxxwContact.setDate("2019-03-07");
//        yxxwContactDao.insert(yxxwContact);
//        yxxwContactDao.save(yxxwContact);

        initDatas();
        init();
        initView();

    }

    private void initView() {
        ListView news = findViewById(R.id.news_listView);
        yxxwAdapter = new YxxwAdapter(newsActivity.this, yxxwContacts);
        news.setAdapter(yxxwAdapter);

        news.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                YxxwContact yxxwContact = yxxwContacts.get(position);
                title = yxxwContact.getTitle();
                data = yxxwContact.getData();
                datetime = yxxwContact.getDate();
                Intent intent = new Intent(newsActivity.this,yxxwActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
    }

    private void init() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        YxxwContactDao yxxwContactDao = daoManager.getYxxwContactDao();
        List<YxxwContact> yxxwContacts = yxxwContactDao.queryBuilder().list();
        for (YxxwContact yxxwContact : yxxwContacts) {
            Log.i(TAG, "title = " + yxxwContact.getTitle());
            Log.i(TAG, "data = " + yxxwContact.getData());
//            Log.i(TAG, "date = " + xsjzContact.getDate(JiaowuPageFragment.this));
//            Log.i(TAG, "date = " + xsjzContact.getDate(ShezhiPageFragment.this));
        }
    }

    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        yxxwContacts = daoManager.getYxxwContactDao().queryBuilder().list();
    }
}

package com.example.hp.college.Activity.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.college.Activity.fragment.adapter.KydtAdapter;
import com.example.hp.college.Activity.fragment.adapter.XmcgAdapter;
import com.example.hp.college.R;
import com.example.hp.college.bean.KydtContact;
import com.example.hp.college.bean.XmcgContact;
import com.example.hp.college.bean.dao.DaoSession;
import com.example.hp.college.bean.dao.KydtContactDao;
import com.example.hp.college.bean.dao.XmcgContactDao;
import com.example.hp.college.util.DaoManager;

import java.util.List;

public class technologyActivity extends AppCompatActivity {
    private static final String TAG = "technologyActivity";
    KydtAdapter kydtAdapter;
    XmcgAdapter xmcgAdapter;
    private List<KydtContact> kydtContacts;
    private List<XmcgContact> xmcgContacts;
    private String title;
    private String data;
    private String datetime;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.technology_main);
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(technologyActivity.this);
        DaoSession daoSession = daoManager.getDaoSession();
        //tzgg添加
//        KydtContactDao kydtContactDao = daoSession.getKydtContactDao();
//        KydtContact kydtContact = new KydtContact();
//        kydtContact.setTitle("美国知名科普网站Science Trends报道陈新军课题组研究成果 \n");
//        kydtContact.setData("1月14日，美国知名科普网站Science Trends以“Identifying The Impacts OfThe El Niño And La Niña Events On Habitat Quality Of Chub Mackerel In The EastChina Sea”报道了海洋科学学院陈新军课题组关于厄尔尼诺和拉尼娜现象对中国东海鲐鱼栖息地的影响研究，该工作于2018年发表于Fisheries Research渔业著名期刊上（青年教师余为博士为第一作者）。\n" +
//                "\n" +
//                "ScienceTrends网站为国际知名科普网站，主要针对当前科学前沿论文进行跟踪报道，为各国科学家分享最新研究成果。Science Trends网站在EARTH&ENVIRONMENT专栏中以长摘要的形式在报道上海海洋大学鱿钓科学技术组的研究成果，该文阐明了东海海域鲐鱼栖息地对不同强度和类型的厄尔尼诺和拉尼娜事件的生态响应过程，充分肯定了该研究在大洋中上层鱼类栖息地方面所做出的积极贡献。\n" +
//                "\n" +
//                "网站报道链接：\n" +
//                "\n" +
//                "https://sciencetrends.com/identifying-the-impacts-of-the-el-nino-and-la-nina-events-on-habitat-quality-of-chub-mackerel-in-the-east-china-sea/\n" +
//                "\n" +
//                "期刊论文链接：https://doi.org/10.1016/j.fishres.2018.06.007\n");
//        kydtContact.setDate("2019-01-15");
//        kydtContactDao.insert(kydtContact);
//        kydtContactDao.save(kydtContact);
//
//        XmcgContactDao xmcgContactDao = daoSession.getXmcgContactDao();
//        XmcgContact xmcgContact = new XmcgContact();
//        xmcgContact.setTitle("我校获得2个水产新品种 \n");
//        xmcgContact.setData("5月31日，2018全球水产养殖论坛水产种业发展分论坛在厦门召开。会上举行了2018年农业农村部公告的水产新品种证书颁发仪式。我校获得三角帆蚌“申紫1号”（GS-01-011-2017）和缢蛏“申浙1号”（GS-01-013-2017）2个水产新品种证书。农业农村部渔业渔政管理局养殖处处长陈家勇和全国水产技术推广总站副站长胡红浪分别向我校课题组代表白志毅教授、刘晓军博士颁发证书。\n" +
//                "\n" +
//                "三角帆蚌“申紫1号”采用群体选育辅以家系选择方法，经连续5代选育而成。该品种最大特点是贝壳珍珠质深紫色，紫色个体比例达95.6%以上，所育紫色珍珠比例提高43.0%以上。2006年，我校曾获得淡水珍珠蚌第一个新品种——“康乐蚌”，去年我校白志毅教授成为全国贝类产业技术体系淡水珍珠贝种质资源与品种改良岗位科学家，三角帆蚌“申紫1号”新品种是我国第二个淡水珍珠蚌新品种。“康乐蚌”和三角帆蚌“申紫1号”是我国仅有的2个淡水珍珠蚌新品种，标志着我校淡水珍珠蚌种质资源与品种改良研发继续走在全国前列。\n" +
//                "\n" +
//                "缢蛏“申浙1号”采用群体选育技术，经连续5代选育而成，在相同养殖条件下壳长和体重分别提高17.4%和38.2%以上。缢蛏“申浙1号”是我校第一个人工选育的海水养殖动物新品种，是全国第五个滩涂贝类新品种，标志着我校滩涂贝类种质资源与品种改良研发接近全国前列，向海水养殖领域迈出了坚实的一步。\n");
//        xmcgContact.setDate("2018-06-04");
//        xmcgContactDao.insert(xmcgContact);
//        xmcgContactDao.save(xmcgContact);

        initDatas();
        init();
        initView();
    }

    private void initView() {
        ListView kydt = findViewById(R.id.kydt_listView);
        kydtAdapter = new KydtAdapter(technologyActivity.this, kydtContacts);
        kydt.setAdapter(kydtAdapter);
        ListView xmcg = findViewById(R.id.xmcg_listView);
        xmcgAdapter = new XmcgAdapter(technologyActivity.this, xmcgContacts);
        xmcg.setAdapter(xmcgAdapter);

        kydt.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                KydtContact kydtContact = kydtContacts.get(position);
                title = kydtContact.getTitle();
                data = kydtContact.getData();
                datetime = kydtContact.getDate();
                Intent intent = new Intent(technologyActivity.this,kydtActivity.class);
                intent.putExtra("title", title);
                intent.putExtra("data", data);
                intent.putExtra("datetime", datetime);
                startActivity(intent);
                intent.putExtra("position", position);
            }
        });
        xmcg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                XmcgContact xmcgContact = xmcgContacts.get(position);
                title = xmcgContact.getTitle();
                data = xmcgContact.getData();
                datetime = xmcgContact.getDate();
                Intent intent = new Intent(technologyActivity.this,xmcgActivity.class);
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
        KydtContactDao kydtContactDao = daoManager.getKydtContactDao();
        List<KydtContact> kydtContacts = kydtContactDao.queryBuilder().list();
        for (KydtContact kydtContact : kydtContacts) {
            Log.i(TAG, "title = " + kydtContact.getTitle());
            Log.i(TAG, "data = " + kydtContact.getData());
//            Log.i(TAG, "date = " + xsjzContact.getDate(JiaowuPageFragment.this));
//            Log.i(TAG, "date = " + xsjzContact.getDate(ShezhiPageFragment.this));
        }
        XmcgContactDao xmcgContactDao = daoManager.getXmcgContactDao();
        List<XmcgContact> xmcgContacts = xmcgContactDao.queryBuilder().list();
        for (XmcgContact xmcgContact : xmcgContacts) {
            Log.i(TAG, "title = " + xmcgContact.getTitle());
            Log.i(TAG, "data = " + xmcgContact.getData());
//            Log.i(TAG, "date = " + xsjzContact.getDate(JiaowuPageFragment.this));
//            Log.i(TAG, "date = " + xsjzContact.getDate(ShezhiPageFragment.this));
        }
    }

    private void initDatas() {
        DaoManager daoManager = DaoManager.getInstance();
        daoManager.init(getApplicationContext());
        kydtContacts = daoManager.getKydtContactDao().queryBuilder().list();
        xmcgContacts = daoManager.getXmcgContactDao().queryBuilder().list();

    }
}

package com.example.hp.college;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioGroup;
import android.widget.ScrollView;

import com.example.hp.college.Activity.fragment.FaxianPageFragment;
import com.example.hp.college.Activity.fragment.JiaowuPageFragment;
import com.example.hp.college.Activity.fragment.ShezhiPageFragment;
import com.example.hp.college.Activity.fragment.ShouyePageFragment;

public class MainActivity extends AppCompatActivity {

    private static final String TAG ="MainActivity" ;
    ScrollView scrollView;
    ShouyePageFragment shouyePageFragment;
    JiaowuPageFragment jiaowuPageFragment;
    FaxianPageFragment faxianPageFragment;
    ShezhiPageFragment shezhiPageFragment;
    FragmentManager fragmentManager;
    String [] fragmentsNames = {"shouyePageFragment","jiaowuPageFragment","faxianPageFragment","shezhiPageFragment"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_main);
//        DaoManager daoManager = DaoManager.getInstance();
//        daoManager.init(MainActivity.this);
//        DaoSession daoSession = daoManager.getDaoSession();
//        //tzgg添加
//        TzggContactDao tzggContactDao = daoSession.getTzggContactDao();
//        TzggContact tzggContact = new TzggContact();
//        tzggContact.setTitle("关于2018年国家“万人计划”青年拔尖人才推荐人选的公示\n");
//        tzggContact.setData("     学校根据市教委关于开展2018年国家“万人计划”青年拔尖人才申报推荐工作的通知要求，经个人申请，学院按照程序由党政联席会议研究推荐，学校对申报材料复核，综合听取对申报人员的思想品德、教育教学、学术道德、组织纪律等方面内容和学术评议推荐意见，经校长办公会审议、党委常委会审定，确定我校水产与生命学院徐田军教授、海洋科学学院马建教授为2018年国家“万人计划”青年拔尖人才推荐人选。\n" +
//                "         现进行公示，公示期为2018年8月6日—10日，如有异议，请在公示期内向校人事处反映。联系人：陈老师，联系电话：15692166552、61900263，联系邮箱：renshi@shou.edu.cn。\n" +
//                "\n");
//        tzggContact.setDate("2018-08-06");
//        tzggContactDao.insert(tzggContact);
//        tzggContactDao.save(tzggContact);
        //cfbg添加
//        CfbgContactDao cfbgContactDao = daoSession.getCfbgContactDao();
//        CfbgContact cfbgContact = new CfbgContact();
//        cfbgContact.setTitle("关于外国语学院徐迎春1人赴日本进行访学团出访报告");
//        cfbgContact.setData("出访报告信息表 \n" +
//                "团组基本信息 \n" +
//                "团组名称 外国语学院徐迎春1人赴日本进行访学团 组团单位 上海海洋大学 \n" +
//                "批准人数 1人 批准天数 365 批件号 沪府办外[2017]8556号 团长或领队 徐迎春 \n" +
//                "填表人 徐迎春 联系电话 15692160200 填表\n" +
//                "     时间 2018年10月22日 \n" +
//                "\u200B \n" +
//                "出访情况 \n" +
//                "离境日期 2017年10月20日 抵境日期 2018年10月19日 实际出访天数 365 \n" +
//                "批准出访国家、地区（含经停城市） 日本东京 \n" +
//                "实际出访国家、地区（含经停城市） 日本东京 \n" +
//                "出访人员名单 徐迎春 \n" +
//                "实际出访行程： 2017年10月20日，上海出发，当地时间当日到达日本东京成田机场；\n" +
//                "     2017年10月23日-2017年10月15日，在东京大学办理入住以及入学手续；\n" +
//                "     2017年10月16日-2018年10月8日，进行调查与研究，参加学术研讨会，听东京大学大学院综合文化研究科老师们的课程讲义；\n" +
//                "     2018年10月9日-2018年10月18日 回国准备；\n" +
//                "     2018年10月19日回国（上海）。 \n" +
//                "\n" +
//                "\n" +
//                "主要出访成果： 1.收集海洋文化以及文学方面的资料；2.根据资料申请科研项目(5.6.9.10月份)；3.撰写学术论文(9月份)。 \n" +
//                "需要说明的问题： \u200B \n" +
//                "出访小结是否完成： 完成 \n" +
//                "出访费用是否按规定核销： 是 \n" +
//                "\u200B \n" +
//                "护照管理情况 \n" +
//                "领取护照 本 护照类型 因公普通护照 \u200B 港澳通行证 \u200B \n" +
//                "交回护照 本 护照类型 因公普通护照 \u200B 港澳通行证 \u200B \n" +
//                "护照通行证是否在返回后7个工作日内交回 \u200B \n" +
//                "附件： 出访小结.doc等（内容尽可能详细）  ");
//        cfbgContact.setDate("2018-10-29");
//        cfbgContactDao.insert(cfbgContact);
//        cfbgContactDao.save(cfbgContact);

        initViews();

        int id = getIntent().getIntExtra("id", 0);
        if (id == 1) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frag_jw,new JiaowuPageFragment())
                    .addToBackStack(null)
                    .commit();
        }

    }

    private void initViews() {
        scrollView = (ScrollView) findViewById(R.id.main_content);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.btn_guid);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        shouyePageFragment = new ShouyePageFragment();
        fragmentTransaction.replace(R.id.main_content,shouyePageFragment,fragmentsNames[0]);
        fragmentTransaction.addToBackStack(fragmentsNames[0]);
        fragmentTransaction.commit();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction tempFragmentTransaction = fragmentManager.beginTransaction();
                switch (checkedId) {
                    case R.id.home:
                        if (shouyePageFragment == null) {
                            shouyePageFragment = new ShouyePageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,shouyePageFragment,fragmentsNames[0]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[0]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentHome = fragmentManager.findFragmentByTag(fragmentsNames[0]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentHome,fragmentsNames[0]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.jiaowu:
                        if (jiaowuPageFragment == null) {
                            jiaowuPageFragment = new JiaowuPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,jiaowuPageFragment,fragmentsNames[1]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[1]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[1]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[1]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.faxian:
                        if (faxianPageFragment == null) {
                            faxianPageFragment = new FaxianPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,faxianPageFragment,fragmentsNames[2]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[2]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[2]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[2]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                    case R.id.shezhi:
                        if (shezhiPageFragment == null) {
                            shezhiPageFragment = new ShezhiPageFragment();
                            tempFragmentTransaction.replace(R.id.main_content,shezhiPageFragment,fragmentsNames[3]);
                            tempFragmentTransaction.addToBackStack(fragmentsNames[3]);
                            tempFragmentTransaction.commit();
                        } else {
                            Fragment fragmentMsg = fragmentManager.findFragmentByTag(fragmentsNames[3]);
                            tempFragmentTransaction.replace(R.id.main_content,fragmentMsg,fragmentsNames[3]);
                            tempFragmentTransaction.commit();
                        }
                        break;
                }
            }
        });

    }

}

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
//        TzggContactDao tzggContactDao = daoSession.getTzggContactDao();
//        TzggContact tzggContact = new TzggContact();
//        tzggContact.setTitle("第一个title");
//        tzggContact.setData("第一个data");
//        tzggContact.setDate("2019-08-08");
////        tzggContactDao.insert(tzggContact);
//        tzggContactDao.save(tzggContact);
//
        initViews();
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

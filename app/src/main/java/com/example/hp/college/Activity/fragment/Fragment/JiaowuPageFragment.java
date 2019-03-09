package com.example.hp.college.Activity.fragment;

/**
 * Created by HP on 2019/1/6.
 */

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hp.college.Constants.Constants;
import com.example.hp.college.R;

public class JiaowuPageFragment extends Fragment {
    private ImageView iv_yikatong,iv_score,iv_tel,iv_citiao,iv_schoolkaikuang,iv_rli,iv_schoolmap;


    public JiaowuPageFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jiaowu_main,container,false);
        return view;
    }
    @Override
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

        initView();
        initListener();

    }

    private void initListener() {
        iv_yikatong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_score.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent("Intent.ACTION_DIAL");
                intent.setAction(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:61900100"));
                startActivity(intent);
            }
        });
        iv_citiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://baike.baidu.com/item/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6/1273892?fr=aladdin");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        iv_schoolkaikuang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.shou.edu.cn/xxgk_93/list.htm");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

            }
        });
        iv_rli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        iv_schoolmap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Uri uri = Uri.parse("https://www.shou.edu.cn/xydt/list.htm");
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                Intent intent = new Intent(Constants.SMAP_ACTION);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        iv_yikatong = getView().findViewById(R.id.btn_yikatong);
        iv_score = getView().findViewById(R.id.btn_score);
        iv_tel = getView().findViewById(R.id.btn_tel);
        iv_citiao = getView().findViewById(R.id.btn_citiao);
        iv_schoolkaikuang = getView().findViewById(R.id.btn_schoolkaikuang);
        iv_rli = getView().findViewById(R.id.btn_rli);
        iv_schoolmap = getView().findViewById(R.id.btn_schoolmap);
    }


}
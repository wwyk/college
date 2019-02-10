package com.example.hp.college.Activity.fragment;

/**
 * Created by HP on 2019/1/6.
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.hp.college.R;


public class FaxianPageFragment extends Fragment {
    private Button mCallButton;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.faxian_main,null);
//        mCallButton = (Button).findViewById(R.id.police);
//        mCallButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent Intent =  new Intent(android.content.Intent.ACTION_CALL,Uri.parse("tel:" + 110));//跳转到拨号界面，同时传递电话号码
//                startActivity(Intent);
//            }
//        });
    }
}
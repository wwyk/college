package com.example.hp.college.Activity.fragment;

/**
 * Created by HP on 2019/1/6.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.college.R;
import com.example.hp.college.zhuceActivity;

public class ShezhiPageFragment extends Fragment {
    private ImageView returnhome;
    private TextView register;

    public ShezhiPageFragment(){
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.shezhi_main,container,false);
        return view;
    }
    public void onActivityCreated(Bundle saveInstanceState){
        super.onActivityCreated(saveInstanceState);

        initView();

    }

    private void initView() {
        register = getView().findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), zhuceActivity.class);
                startActivity(intent);
            }
        });


    }


}

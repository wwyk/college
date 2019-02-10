package com.example.hp.college.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.college.R;


/**
 * Created by HP on 2019/1/27.
 */

public class CustomToolBar extends Toolbar {
    private static final String TAG = "CustomToolBar";
    //文本内容
    private CharSequence mText;
    //文本大小
    private int mTextSize;
    //文本颜色
    private int mTextColor;
    //背景颜色
    private int mBackgroundColor;
    //左侧图片
    private Drawable mLeftIcon;
//    //右侧图片
//    private Drawable mRightIcon;
    //整体根布局xml
    private View mView;
    private LinearLayout mRootView;
    private int mUnderLineColor;
    //item中的控件
    private TextView mTextView;
    private ImageView mLeftImageView;



    public CustomToolBar(Context context) {
        this(context, null);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomToolBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
        initCustomStyle(context, attrs);
        initCustomAttrs();
    }

    private void init(Context context) {
        mView = View.inflate(context, R.layout.toolbar, this);
        mRootView = (LinearLayout) mView.findViewById(R.id.main_layout);
        mTextView = (TextView) mView.findViewById(R.id.custom_title);
        mLeftImageView = (ImageView) mView.findViewById(R.id.custom_left_icon);
    }
    private void initCustomAttrs(){
        mView.setBackgroundColor(mBackgroundColor);
        mTextView.setText(mText);
        mTextView.setTextSize(mTextSize);
        mTextView.setTextColor(mTextColor);
        mLeftImageView.setBackground(mLeftIcon);
        mLeftImageView.setVisibility(mLeftIcon == null ? ImageView.GONE : ImageView.VISIBLE);
           }

    private void initCustomStyle(Context context, @Nullable AttributeSet attrs) {
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomToolBar);
        mText = typedArray.getText(R.styleable.CustomToolBar_text);
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.CustomToolBar_textSize, 20);
        mTextColor = typedArray.getColor(R.styleable.CustomToolBar_textColor, Color.BLACK);
        mLeftIcon = typedArray.getDrawable(R.styleable.CustomToolBar_leftIcon);
        mBackgroundColor = typedArray.getColor(R.styleable.CustomToolBar_BackgroundColor,Color.WHITE);
        typedArray.recycle();
    }
//    private static int px2sp(Context context, int pxValue){
//        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
//        return (int)(pxValue/fontScale+0.52);
//    }
    public void setOnLeftIconClickListener(OnClickListener onClickListener){
        mLeftImageView.setOnClickListener(onClickListener);
    }


}



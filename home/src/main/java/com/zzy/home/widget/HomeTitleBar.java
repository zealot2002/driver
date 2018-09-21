package com.zzy.home.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zzy.home.R;


public class HomeTitleBar extends RelativeLayout{
    private LinearLayout llLeft,llRight;
    private TextView tvCity;
/**************************************************************************************************************/
    public HomeTitleBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }
    public HomeTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View.inflate(context, R.layout.home_titlebar, this);
        setupViews();
    }

    private void setupViews() {
        llLeft = findViewById(R.id.llLeft);
        llRight = findViewById(R.id.llRight);
        tvCity = findViewById(R.id.tvCity);
    }

    public HomeTitleBar(Context context) {
        this(context,null);
    }

    public void setSelectCityClickedListener(OnClickListener listener){
        if(llLeft!=null)
            llLeft.setOnClickListener(listener);
    }
    public void setSearchClickedListener(OnClickListener listener){
        if(llRight!=null)
            llRight.setOnClickListener(listener);
    }
    public void setCity(String city){
        tvCity.setText(city);
    }

    public void hideCity(){
        if(llLeft!=null)
            llLeft.setVisibility(GONE);
    }
    public void hideSearch(){
        if(llRight!=null)
            llRight.setVisibility(GONE);
    }
}

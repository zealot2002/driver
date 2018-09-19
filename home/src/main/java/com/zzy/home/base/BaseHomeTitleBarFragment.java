package com.zzy.home.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.commonlib.base.BaseFragment;
import com.zzy.home.R;
import com.zzy.home.widget.HomeTitleBar;

/**
 * zzy
 */

abstract public class BaseHomeTitleBarFragment extends BaseFragment{
    private HomeTitleBar titleBar;
    private View rootView;
/***************************************************************************************************/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.home_titlebar_container, container, false);
        initViews();
        return rootView;
    }
    private void initViews(){
        titleBar = rootView.findViewById(R.id.titleBar);
    }

    protected ViewGroup getContainer() {
        return rootView.findViewById(R.id.container);
    }
    protected void setCity(String city){
        if(titleBar!=null)
            titleBar.setCity(city);
    }
    public void setSelectCityClickedListener(View.OnClickListener listener){
        if(titleBar!=null)
            titleBar.setSelectCityClickedListener(listener);
    }
    public void setSearchClickedListener(View.OnClickListener listener){
        if(titleBar!=null)
            titleBar.setSearchClickedListener(listener);
    }
}

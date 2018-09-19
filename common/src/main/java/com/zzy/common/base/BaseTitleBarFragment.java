package com.zzy.common.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.common.R;
import com.zzy.common.widget.BackTitleBar;
import com.zzy.commonlib.base.BaseFragment;

/**
 * zzy
 */

abstract public class BaseTitleBarFragment extends BaseFragment{
    private BackTitleBar titleBar;
    private View rootView;
/***************************************************************************************************/
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.base_titlebar_container, container, false);
        initViews();
        return rootView;
    }
    protected void initViews(){
        titleBar = rootView.findViewById(R.id.titleBar);
    }
    protected void setTitle(String title){
        if(titleBar!=null)
            titleBar.setTitle(title);
    }
    protected void setOnBackEventListener(View.OnClickListener listener){
        if(titleBar!=null)
            titleBar.setOnBackEventListener(listener);
    }
    protected ViewGroup getContainer() {
        return rootView.findViewById(R.id.container);
    }

}

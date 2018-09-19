package com.zzy.common.base;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.zzy.common.R;
import com.zzy.common.widget.BackTitleBar;
import com.zzy.commonlib.base.BaseActivity;

/**
 * zzy
 */

abstract public class BaseTitleBarActivity extends BaseActivity{
    private BackTitleBar titleBar;

/********************************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_titlebar_container);
        titleBar = findViewById(R.id.titleBar);

    }

    protected void setTitle(String title){
        if(titleBar!=null)
            titleBar.setTitle(title);
    }
    protected void setOnBackEventListener(View.OnClickListener listener){
        if(titleBar!=null)
            titleBar.setOnBackEventListener(listener);
    }
    protected ViewGroup getContainer(){
        return findViewById(R.id.container);
    }
}

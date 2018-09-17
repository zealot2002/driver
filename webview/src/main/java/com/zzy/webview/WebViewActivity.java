package com.zzy.webview;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;

import com.zzy.commonlib.base.BaseActivity;

/**
 * @author zzy
 * @date 2018/9/17
 */

public class WebViewActivity extends BaseActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.webview_main);


    }
}

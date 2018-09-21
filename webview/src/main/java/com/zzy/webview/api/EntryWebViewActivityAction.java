package com.zzy.webview.api;

import android.content.Context;
import android.os.Bundle;

import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.ActivityUtils;
import com.zzy.core.serverCenter.ScAction;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.webview.WebViewActivity;

/**
 * @author zzy
 * @date 2018/8/13
 */

@ScActionAnnotation(ScmConstants.API_ENTRY_WEBVIEW)
public class EntryWebViewActivityAction implements ScAction {

    @Override
    public void invoke(Context context, Bundle bundle, String tag, ScCallback scCallback) {
        ActivityUtils.startActivity(context,bundle,WebViewActivity.class);
        if(scCallback!=null){
            scCallback.onCallback(true,bundle,tag);
        }
    }
}

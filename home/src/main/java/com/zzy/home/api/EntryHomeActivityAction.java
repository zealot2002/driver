package com.zzy.home.api;

import android.content.Context;
import android.content.Intent;

import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.core.serverCenter.ScAction;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.home.view.HomeActivity;

/**
 * @author zzy
 * @date 2018/8/13
 */

@ScActionAnnotation(ScmConstants.API_ENTRY_HOME)
public class EntryHomeActivityAction implements ScAction {
    @Override
    public void invoke(Context context, String param, final ScCallback callback) {
        Intent intent = new Intent();
        intent.setClass(context, HomeActivity.class);
        context.startActivity(intent);

        callback.onCallback(true,"entry success","");
    }
}

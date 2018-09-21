package com.zzy.home.api;

import android.content.Context;
import android.os.Bundle;

import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.ActivityUtils;
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
    public void invoke(Context context, Bundle param,String tag, final ScCallback callback) {
        ActivityUtils.startActivity(context,HomeActivity.class);
        if(callback!=null){
            callback.onCallback(true,Bundle.EMPTY,tag);
        }
    }
}

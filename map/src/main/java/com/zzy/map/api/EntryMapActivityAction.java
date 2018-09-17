package com.zzy.map.api;

import android.content.Context;
import android.os.Bundle;

import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.ActivityUtils;
import com.zzy.core.serverCenter.ScAction;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.map.MapActivity;

/**
 * @author zzy
 * @date 2018/8/13
 */

@ScActionAnnotation(ScmConstants.API_ENTRY_MAP)
public class EntryMapActivityAction implements ScAction {

    @Override
    public void invoke(Context context, Bundle bundle, String tag, ScCallback scCallback) {
        ActivityUtils.startActivity(context,bundle,MapActivity.class);
        scCallback.onCallback(true,null,tag);
    }
}

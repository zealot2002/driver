package com.zzy.update.api;

import android.content.Context;
import android.os.Bundle;

import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.listener.ExceptionHandler;
import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.constants.SpConstants;
import com.zzy.common.utils.MyActivityManager;
import com.zzy.core.serverCenter.ScAction;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.flysp.core.spHelper.SPHelper;
import com.zzy.update.UpdateAppHttpUtil;

/**
 * @author zzy
 * @date 2018/8/13
 */

@ScActionAnnotation(ScmConstants.API_TEST_IDLE)
public class TestIdleAction implements ScAction {

    @Override
    public void invoke(final Context context, Bundle bundle, String tag, ScCallback callback) {

        SPHelper.save(SpConstants.TEST_IDLE,1);
        if(callback!=null){
            callback.onCallback(true,Bundle.EMPTY,tag);
        }
    }
}

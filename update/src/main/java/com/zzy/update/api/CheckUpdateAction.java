package com.zzy.update.api;

import android.content.Context;
import android.os.Bundle;

import com.vector.update_app.UpdateAppManager;
import com.vector.update_app.listener.ExceptionHandler;
import com.zzy.annotations.ScActionAnnotation;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.MyActivityManager;
import com.zzy.core.serverCenter.ScAction;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.update.UpdateAppHttpUtil;

/**
 * @author zzy
 * @date 2018/8/13
 */

@ScActionAnnotation(ScmConstants.API_CHECK_UPDATE)
public class CheckUpdateAction implements ScAction {
    private String mUpdateUrl = "https://raw.githubusercontent.com/WVector/AppUpdateDemo/master/json/json.txt";

    @Override
    public void invoke(final Context context, Bundle bundle, String tag, ScCallback callback) {
        new UpdateAppManager
                .Builder()
                //当前Activity
                .setActivity(MyActivityManager.getInstance().getCurrentActivity())
                //更新地址
                .setUpdateUrl(mUpdateUrl)
                .handleException(new ExceptionHandler() {
                    @Override
                    public void onException(Exception e) {
                        e.printStackTrace();
                    }
                })
                //实现httpManager接口的对象
                .setHttpManager(new UpdateAppHttpUtil())
                .build()
                .update();
        if(callback!=null){
            callback.onCallback(true,Bundle.EMPTY,tag);
        }
    }
}

package com.zzy.common.job;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.evernote.android.job.Job;
import com.zzy.common.constants.ParamConstants;
import com.zzy.common.utils.ApplicationUtils;
import com.zzy.commonlib.log.MyLog;
import com.zzy.core.serverCenter.SCM;

/**
 * @author zzy
 * @date 2018/9/13
 */
public class LazyJob extends Job {

    public static final String TAG = "LazyJob";

    @Override
    @NonNull
    protected Result onRunJob(@NonNull Params params) {
        // run your job here
        MyLog.e("onRunJob thread:"+Thread.currentThread().getName());
        String scmAction = params.getTransientExtras().getString(ParamConstants.PARAM_ACTION,"");
        Bundle bundle = params.getTransientExtras();
        MyLog.e("onRunJob scmAction:"+scmAction);
        try {
            SCM.getInstance().req(ApplicationUtils.get(),scmAction,bundle,null);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.RESCHEDULE;
        }
        return Result.SUCCESS;
    }
}
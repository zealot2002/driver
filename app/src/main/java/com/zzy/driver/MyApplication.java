package com.zzy.driver;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.baidu.mapapi.SDKInitializer;
import com.evernote.android.job.JobManager;
import com.zhy.autolayout.config.AutoLayoutConifg;
import com.zzy.driver.job.MyJobCreator;
import com.zzy.common.utils.ApplicationUtils;
import com.zzy.common.utils.CommonUtils;
import com.zzy.core.serverCenter.SCM;

/**
 * @author zzy
 * @date 2018/8/10
 */

public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG,"onCreate");

        //init跨进程库
        initMultiProcessCoreLib();

        //非主进程，至此返回
        if(!CommonUtils.isMainProcess(this)) return;

        //init主进程库
        initMainProcessCoreLib();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // dex突破65535的限制
        MultiDex.install(this);
    }

    private void initMainProcessCoreLib() {
        SDKInitializer.initialize(this);
    }

    private void initMultiProcessCoreLib() {
        try {
            //服务中心
            SCM.getInstance().init(this);
            /**/
            ApplicationUtils.init(this);
            /*初始化设计稿尺寸*/
            AutoLayoutConifg.getInstance().useDeviceSize().init(this);

            JobManager.create(this).addJobCreator(new MyJobCreator());
            //sp content provider
//            SPHelper.init(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

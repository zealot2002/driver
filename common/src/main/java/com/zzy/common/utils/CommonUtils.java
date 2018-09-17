package com.zzy.common.utils;

import android.app.ActionBar;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/**
 * @author zzy
 * @date 2018/9/3
 */

public class CommonUtils {
    /**
     * 设置Activity的statusBar隐藏
     * @param activity
     */
    public static void statusBarHide(Activity activity){
        try{
            // 代表 5.0 及以上
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                View decorView = activity.getWindow().getDecorView();
                int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN;
                decorView.setSystemUiVisibility(option);
                activity.getWindow().setStatusBarColor(Color.TRANSPARENT);
                ActionBar actionBar = activity.getActionBar();
                actionBar.hide();
                return;
            }

            // versionCode > 4.4  and versionCode < 5.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    private static String getCurrentProcessName(Application application) {
        int pid = android.os.Process.myPid();
        String processName = "";
        ActivityManager manager = (ActivityManager) application.getSystemService
                (Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo process : manager.getRunningAppProcesses()) {
            if (process.pid == pid) {
                processName = process.processName;
            }
        }
        return processName;
    }
    public static boolean isMainProcess(Application application) {
        String packageName = application.getPackageName();
        return packageName.equals(CommonUtils.getCurrentProcessName(application));
    }
}

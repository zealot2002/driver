package com.zzy.home.view;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import com.evernote.android.job.JobRequest;
import com.zzy.common.constants.EventConstants;
import com.zzy.common.constants.ParamConstants;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.constants.SpConstants;
import com.zzy.common.job.LazyJob;
import com.zzy.common.job.LazyWorkJob;
import com.zzy.common.utils.MyToast;
import com.zzy.common.utils.StatusBarUtils;
import com.zzy.commonlib.log.MyLog;
import com.zzy.commonlib.utils.ActivityManager;
import com.zzy.flysp.core.spHelper.SPHelper;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeActivity;
import com.zzy.home.view.fragment.CommunityFragment;
import com.zzy.home.view.fragment.ExamFragment;
import com.zzy.home.view.fragment.MineFragment;
import com.zzy.home.view.fragment.SchoolFragment;


/**
 * 首页
 */
public class HomeActivity extends BaseHomeActivity{
    private static final String TAG = "HomeActivity";
/***********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StatusBarUtils.setStatusBarFontIconDark(this);
    }
    private void testJob() {
//        Bundle bundle = new Bundle();
//        bundle.putString(ParamConstants.PARAM_ACTION,ScmConstants.API_TEST_IDLE);
//        new JobRequest.Builder(LazyJob.TAG)
//                .setExecutionWindow(3000L,1000*60*30L)
//                .setTransientExtras(bundle)
//                .setRequirementsEnforced(true)
//                .setRequiresDeviceIdle(true)
////                .setRequiresCharging(true)
////                .setRequiredNetworkType(JobRequest.NetworkType.UNMETERED)
//                .build()
//                .schedule();
    }
//    private void registerReceiver() {
//        receiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                String data = intent.getStringExtra(ParamConstants.PARAM_DATA);
//                Log.e(TAG,"onReceive data:"+data);
//            }
//        };
//        IntentFilter intent = new IntentFilter();
//        intent.addAction(EventConstants.EVENT_ORDER_SUCCESS);
//        registerReceiver(receiver,intent);
//    }

    @Override
    protected TabContext getTabContext() {
        TabContext tabContext = new TabContext();
        TabBean tab1 = new TabBean("驾校",R.mipmap.home_school_icon_normal,R.mipmap.home_school_icon_selected);
        TabBean tab2 = new TabBean("考试",R.mipmap.home_exam_icon_normal,R.mipmap.home_exam_icon_selected);
        TabBean tab3 = new TabBean("社区",R.mipmap.home_community_icon_normal,R.mipmap.home_community_icon_selected);
        TabBean tab4 = new TabBean("我的",R.mipmap.home_mine_icon_normal,R.mipmap.home_mine_icon_selected);
        tabContext.getTabBeanList().add(tab1);
        tabContext.getTabBeanList().add(tab2);
        tabContext.getTabBeanList().add(tab3);
        tabContext.getTabBeanList().add(tab4);

        tabContext.setNormalTextColorId(R.color.home_tab_text_color_normal);
        tabContext.setCheckedTextColorId(R.color.home_tab_text_color_checked);

        tabContext.setFragments(new Fragment[]{new SchoolFragment(),new ExamFragment(),new CommunityFragment(),new MineFragment()});
        return tabContext;
    }

    @Override
    protected void onShowFragment(int position) {
        if(position == 3){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.orange));
            }
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }else{
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getResources().getColor(R.color.white));
            }
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                MyToast.show(this, "再按一次退出程序");
                exitTime = System.currentTimeMillis();
            } else {
                ActivityManager.getInstance().exitApp(this);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}

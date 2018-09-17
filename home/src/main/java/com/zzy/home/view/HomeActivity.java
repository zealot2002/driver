package com.zzy.home.view;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;

import com.zzy.common.constants.ParamConstants;
import com.zzy.common.constants.ScmConstants;
import com.zzy.common.utils.MyToast;
import com.zzy.commonlib.log.MyLog;
import com.zzy.commonlib.utils.ActivityManager;
import com.zzy.core.serverCenter.SCM;
import com.zzy.core.serverCenter.ScCallback;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeActivity;


/**
 * 首页
 */
public class HomeActivity extends BaseHomeActivity{
    private static final String TAG = "HomeActivity";
/***********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        new JobRequest.Builder(TestJob.TAG)
//                .setExecutionWindow(3_000L, 4_000L)
//                .setBackoffCriteria(5_000L, JobRequest.BackoffPolicy.LINEAR)
//                .setRequirementsEnforced(true)
//                .build()
//                .schedule();

        try {
            SCM.getInstance().req(this, ScmConstants.API_CHECK_UPDATE, new ScCallback() {
                @Override
                public void onCallback(boolean b, Bundle data, String tag) {
                    if(b){
//                        finish();
                    }else {
//                        MyLog.e(TAG,"return:"+data);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected TabContext getTabContext() {
        TabContext tabContext = new TabContext();
        TabBean tab1 = new TabBean("驾校",R.mipmap.home_tab1_normal,R.mipmap.home_tab1_checked);
        TabBean tab2 = new TabBean("考试",R.mipmap.home_tab2_normal,R.mipmap.home_tab2_checked);
        TabBean tab3 = new TabBean("社区",R.mipmap.home_tab3_normal,R.mipmap.home_tab3_checked);
        TabBean tab4 = new TabBean("我的",R.mipmap.home_tab3_normal,R.mipmap.home_tab3_checked);
        tabContext.getTabBeanList().add(tab1);
        tabContext.getTabBeanList().add(tab2);
        tabContext.getTabBeanList().add(tab3);
        tabContext.getTabBeanList().add(tab4);

        tabContext.setNormalTextColorId(R.color.home_tab_text_color_normal);
        tabContext.setCheckedTextColorId(R.color.home_tab_text_color_checked);

        tabContext.setFragments(new Fragment[]{new SchoolFragment(),new ExamFragment(),new CommunityFragment(),new MineFragment()});
        return tabContext;
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
}

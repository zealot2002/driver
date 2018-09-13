package com.zzy.home.view;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.zzy.home.R;
import com.zzy.home.base.BaseHomeActivity;
/**
 * 首页
 */
public class HomeActivity extends BaseHomeActivity{


/***********************************************************************************************/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        tabContext.setFragments(new Fragment[]{new Fragment(),new Fragment(),new Fragment(),new Fragment()});
        return tabContext;
    }
//
//
//    private long exitTime = 0;
//    /**
//     * 再按一次退出程序
//     */
//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
//            if ((System.currentTimeMillis() - exitTime) > 2000) {
//                //T.showShort(this, "再按一次退出程序");
//                SnackyHelper.showDefault(this,"再按一次退出程序");
//                exitTime = System.currentTimeMillis();
//            } else {
//                ActivityManager.getInstance().exitApp(this);
//            }
//            return true;
//        }
//        return super.onKeyDown(keyCode, event);
//    }
}
